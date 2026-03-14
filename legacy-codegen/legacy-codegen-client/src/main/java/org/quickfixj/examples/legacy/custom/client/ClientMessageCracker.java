package org.quickfixj.examples.legacy.custom.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.FieldNotFound;
import quickfix.SessionID;
import quickfix.field.*;
import quickfix.fix50sp2.BusinessMessageReject;
import quickfix.fix50sp2.ExecutionReport;
import quickfix.fix50sp2.MessageCracker;
import quickfix.fix50sp2.component.Instrument;

public class ClientMessageCracker extends MessageCracker {
    private final Logger log = LoggerFactory.getLogger(ClientMessageCracker.class);

    @Override
    public void onMessage(ExecutionReport executionReport, SessionID sessionID)
            throws FieldNotFound {
        Instrument instrumentComponent = executionReport.getInstrument(); // invariant
        log.info("Received ExecutionReport from sender [{}]:: clOrdID {}, symbol {}, side {}, transactTime {}, ordType {}, securityIDSource {}, securityID {}, quoteMsgID {}",
                executionReport.getHeader().getString(SenderCompID.FIELD),
                executionReport.getClOrdID().getValue(),
                instrumentComponent.getSymbol().getValue(),
                executionReport.getSide().getValue(),
                executionReport.getTransactTime().getValue(),
                executionReport.getOrdType().getValue(),
                instrumentComponent.isSetSecurityIDSource() ? instrumentComponent.getSecurityIDSource().getValue() : "",
                instrumentComponent.isSetSecurityID() ? instrumentComponent.getSecurityID().getValue() : "",
                executionReport.isSetQuoteMsgID() ? executionReport.getQuoteMsgID().getValue() : "");
                // Receiving QuoteMsgID is not a FIX Protocol use case for NewOrderSingle,
                // but it is set by the server to prove the customisation
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
}