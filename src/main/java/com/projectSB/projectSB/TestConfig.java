package com.projectSB.projectSB;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@Profile("test")
public class TestConfig {

    private Server server;

    @PostConstruct
    public void startH2Console() {
        try {
            server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
            System.out.println(">>> H2 CONSOLE RODANDO EM: http://localhost:8082 <<<");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void stopH2Console() {
        if (server != null) {
            server.stop();
        }
    }
}