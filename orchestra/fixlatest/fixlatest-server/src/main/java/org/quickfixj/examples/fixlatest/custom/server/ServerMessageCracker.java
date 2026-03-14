package org.quickfixj.examples.fixlatest.custom.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.*;
import quickfix.field.*;
import quickfix.fixlatest.BusinessMessageReject;
import quickfix.fixlatest.ExecutionReport;
import quickfix.fixlatest.MessageCracker;
import quickfix.fixlatest.NewOrderSingle;
import quickfix.fixlatest.component.Instrument;

import java.time.LocalDateTime;
import java.util.UUID;

public class ServerMessageCracker extends MessageCracker {
    private final Logger log = LoggerFactory.getLogger(ServerMessageCracker.class);

    @Override
    public void onMessage(NewOrderSingle newOrderSingle, SessionID sessionID)
            throws FieldNotFound {
        Instrument instrumentComponent = newOrderSingle.getInstrumentComponent(); // invariant
        log.info("Received NewOrderSingle from sender [{}]: clOrdID {}, symbol {}, side {}, transactTime {}, ordType {}, securityIDSource {}, securityID {}",
                newOrderSingle.getHeader().getString(SenderCompID.FIELD),
                newOrderSingle.getClOrdID().getValue(),
                instrumentComponent.getSymbol().getValue(),
                newOrderSingle.getSide().getValue(),
                newOrderSingle.getTransactTime().getValue(),
                newOrderSingle.getOrdType().getValue(),
                instrumentComponent.isSetSecurityIDSource() ? instrumentComponent.getSecurityIDSource().getValue() : "",
                instrumentComponent.isSetSecurityID() ? instrumentComponent.getSecurityID().getValue() : "");
        try {
            Session.sendToTarget(executionReport(newOrderSingle),sessionID);
        } catch (SessionNotFound e) {
            log.error("SessionNot Found", e);
        }
    }

    @Override
    public void onMessage(BusinessMessageReject businessMessageReject, SessionID sessionID)
            throws FieldNotFound {
        log.error("Received Business Message Reject from sender [{}]: refMsgType {}, businessRejectReason{}, Text {}",
                sessionID.getSenderCompID(),
                businessMessageReject.getRefMsgType().getValue(),
                businessMessageReject.getBusinessRejectReason().getValue(),
                businessMessageReject.isSetText() ? businessMessageReject.getText().getValue() : "");
    }

    private static ExecutionReport executionReport(NewOrderSingle newOrderSingle) throws FieldNotFound {
        ExecutionReport executionReport = new ExecutionReport();
        executionReport.set(newOrderSingle.getClOrdID());
        executionReport.set(newOrderSingle.getSide());
        executionReport.set(newOrderSingle.getOrdType());
        executionReport.set(new TransactTime(LocalDateTime.now()));
        executionReport.set(new OrderID(UUID.randomUUID().toString()));
        executionReport.set(new ExecID(UUID.randomUUID().toString()));
        executionReport.set(new ExecType(ExecType.TRADE));
        executionReport.set(new OrdStatus(OrdStatus.FILLED));
        executionReport.set(newOrderSingle.getInstrumentComponent());
        executionReport.set(new LeavesQty(0));
        executionReport.set(new CumQty(newOrderSingle.getOrderQtyDataComponent().getOrderQty().getValue()));
        executionReport.set(new LastQty(newOrderSingle.getOrderQtyDataComponent().getOrderQty().getValue()));
        if (newOrderSingle.isSetPrice()) {
            Price px = newOrderSingle.getPrice();
            executionReport.set(px);
            executionReport.set(new LastPx(px.getValue()));
        } else {
            executionReport.set(new LastPx(1.0d));
        }
        return executionReport;
    }
}
