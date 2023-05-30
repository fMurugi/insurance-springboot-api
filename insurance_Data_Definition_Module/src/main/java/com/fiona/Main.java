package com.fiona;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class Main {
    //        ! todo  WHY do we need this bean ???? If we need it, we can create a folder called configs of the root repository then add the bean.
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    public static void main(String[] args) {
//        ! todo remove uninformative comments.
//        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }


}