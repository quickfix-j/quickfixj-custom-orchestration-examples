package org.quickfixj.examples.legacy.custom.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import quickfix.*;
import quickfix.fix50sp2.MessageCracker;


public class ServerApplicationAdapter extends ApplicationAdapter {

    private final MessageCracker messageCracker;
    private final Logger log = LoggerFactory.getLogger(ServerApplicationAdapter.class);

    public ServerApplicationAdapter(MessageCracker messageCracker) {
        this.messageCracker = messageCracker;
    }

    @Override
    public void onLogon(SessionID sessionID) {
        log.info("logged on [{}] - [{}]", sessionID.getSenderCompID(), sessionID.getTargetCompID());
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
}