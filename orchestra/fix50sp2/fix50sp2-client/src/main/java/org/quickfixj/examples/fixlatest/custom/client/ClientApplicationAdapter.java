package org.quickfixj.examples.fixlatest.custom.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.*;
import quickfix.field.*;
import quickfix.fix50sp2.MessageCracker;
import quickfix.fix50sp2.NewOrderSingle;
import quickfix.fix50sp2.component.Instrument;
import quickfix.fix50sp2.component.OrderQtyData;

import java.time.LocalDateTime;
import java.util.UUID;

public class ClientApplicationAdapter implements Application {

    private final MessageCracker messageCracker;
    private final Logger log = LoggerFactory.getLogger(ClientApplicationAdapter.class);

    public ClientApplicationAdapter(MessageCracker messageCracker) {
        this.messageCracker = messageCracker;
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("logged on [{}] - [{}]", sessionID.getSenderCompID(), sessionID.getTargetCompID());
        try {
            Session.sendToTarget(newOrderSingle(),sessionID);
        } catch (SessionNotFound e) {
            log.error("SessionNot Found", e);
        }
    }

    @Override
    public void onLogout(SessionID sessionID) {
        log.info("logged out [{}] - [{}]", sessionID.getSenderCompID(), sessionID.getTargetCompID());
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) {
        log.info("fromAdmin: Message={}, SessionId={}", message, sessionId);
    }

    @Override
    public void onCreate(SessionID sessionId) {
        log.info("onCreate: SessionId={}", sessionId);
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        log.info("toAdmin: Message={}, SessionId={}", message, sessionId);
    }

    @Override
    public void toApp(Message message, SessionID sessionId) {
        log.info("toApp: Message={}, SessionId={}", message, sessionId);
    }

    @Override
    public void fromApp(Message message, SessionID sessionID)
            throws FieldNotFound, IncorrectTagValue, UnsupportedMessageType {
        this.messageCracker.crack(message, sessionID);
    }

    private static NewOrderSingle newOrderSingle() {
        NewOrderSingle newOrderSingle = new NewOrderSingle();
        newOrderSingle.set(new ClOrdID(UUID.randomUUID().toString()));
        newOrderSingle.set(new OrdType(OrdType.LIMIT));
        newOrderSingle.set(new Price(99.09d));
        newOrderSingle.set(new Side(Side.BUY));
        newOrderSingle.set(new TransactTime(LocalDateTime.now()));
        Instrument instrument = new Instrument();
        instrument.set(new Symbol("EX.AMPLE"));
        instrument.set(new SecurityIDSource(SecurityIDSource.EXAMPLE_CUSTOM_SECURITY_ID_SOURCE));
        instrument.set(new SecurityID("202491685"));
        newOrderSingle.set(instrument);
        OrderQtyData orderQtyData = new OrderQtyData();
        orderQtyData.set(new OrderQty(1.0d));
        newOrderSingle.set(orderQtyData);
        return newOrderSingle;
    }
}