package org.quickfixj.examples.fixlatest.custom.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;
import quickfix.fixlatest.MessageCracker;

@Configuration
public class ClientApplicationConfiguration {

	@Bean
	MessageCracker messageCracker() {
		return new ClientMessageCracker();
	}

    @Bean
    Application application(MessageCracker messageCracker) {
        return new ClientApplicationAdapter(messageCracker);
    }

   	@Bean
	Initiator clientInitiator(
			Application clientApplication,
			MessageStoreFactory clientMessageStoreFactory,
			SessionSettings clientSessionSettings,
			LogFactory clientLogFactory,
			MessageFactory clientMessageFactory) throws ConfigError {
		return new ThreadedSocketInitiator(clientApplication, clientMessageStoreFactory, clientSessionSettings,
				clientLogFactory, clientMessageFactory);
	}
}
