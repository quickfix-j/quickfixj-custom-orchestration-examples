package org.quickfixj.examples.fixlatest.custom.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.*;
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
        Instrument instrumentComponent = executionReport.getInstrumentComponent(); // invariant
        log.info("Received ExecutionReport from sender [{}]:: clOrdID {}, symbol {}, side {}, transactTime {}, ordType {}, securityIDSource {}, securityID {}",
                executionReport.getHeader().getString(SenderCompID.FIELD),
                executionReport.getClOrdID().getValue(),
                instrumentComponent.getSymbol().getValue(),
                executionReport.getSide().getValue(),
                executionReport.getTransactTime().getValue(),
                executionReport.getOrdType().getValue(),
                instrumentComponent.isSetSecurityIDSource() ? instrumentComponent.getSecurityIDSource().getValue() : "",
                instrumentComponent.isSetSecurityID() ? instrumentComponent.getSecurityID().getValue() : "");
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