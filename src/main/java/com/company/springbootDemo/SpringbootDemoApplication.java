package com.company.springbootDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.company.springbootdemo.dao")
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
        System.out.println(
            " ___       __    ______                                 __________             _________________________________      \n"+
            " __ |     / /_______  /__________________ ________      ___  ____/_____ __________(_)_____  /_  __ \\_  ___/__  /     \n"+
            " __ | /| / /_  _ \\_  /_  ___/  __ \\_  __ `__ \\  _ \\     __  /_   _  __ `/_  ___/_  /_  __  /_  / / /____ \\__  /  \n"+
            " __ |/ |/ / /  __/  / / /__ / /_/ /  / / / / /  __/     _  __/   / /_/ /_  /   _  / / /_/ / / /_/ /____/ / /_/        \n"+
            " ____/|__/  \\___//_/  \\___/ \\____//_/ /_/ /_/\\___/      /_/      \\__,_/ /_/    /_/  \\__,_/  \\____/ /____/ (_)  \n"
        );
    }

}
