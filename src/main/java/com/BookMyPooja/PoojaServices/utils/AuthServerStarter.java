package com.BookMyPooja.PoojaServices.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthServerStarter implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        new ProcessBuilder(
                "/Users/rajgauta/Library/Java/JavaVirtualMachines/openjdk-25/Contents/Home/bin/java", "-jar", "libs/JwtAuthSideCar-0.0.1-SNAPSHOT.jar",
                "--server.port=8081"
        ).inheritIO().start();
    }
}

