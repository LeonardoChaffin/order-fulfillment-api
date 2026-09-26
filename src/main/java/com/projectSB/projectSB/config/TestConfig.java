package com.projectSB.projectSB.config;

import java.sql.SQLException;
import java.util.Arrays;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectSB.projectSB.entities.User;
import com.projectSB.projectSB.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
    private UserRepository userRepository;

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

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Rose Bouldalair", "roseb@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Marci Pember", "marcip@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Maxwell Paul", "maxp@gmail.com", "966666666", "123456");
        
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
	}
}