package org.quickfixj.examples.legacy.custom.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;
import quickfix.fix50sp2.MessageCracker;

@Configuration
public class ServerApplicationConfiguration {
    @Bean
    MessageCracker messageCracker() {
        return new ServerMessageCracker();
    }

    @Bean
    Application application(MessageCracker messageCracker) {
        return new ServerApplicationAdapter(messageCracker);
    }

    @Bean
    Acceptor acceptor(Application application,
                      MessageStoreFactory messageStoreFactory,
                      SessionSettings sessionSettings,
                      LogFactory logFactory,
                      MessageFactory messageFactory) throws ConfigError {
        return new ThreadedSocketAcceptor(application,
                messageStoreFactory,
                sessionSettings,
                logFactory,
                messageFactory);
    }
}
