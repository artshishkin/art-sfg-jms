package com.artarkatesoft.artsfgjms;

//import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
//import org.apache.activemq.artemis.core.server.ActiveMQServer;
//import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtSfgJmsApplication {

    public static void main(String[] args) throws Exception {

//        ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//                .setPersistenceEnabled(false)
//                .setSecurityEnabled(false)
//                .setJournalDirectory("target/data/journal")
//                .addAcceptorConfiguration("invm", "vm://0")
//        );
//
//        server.start();

        SpringApplication.run(ArtSfgJmsApplication.class, args);
    }

}
