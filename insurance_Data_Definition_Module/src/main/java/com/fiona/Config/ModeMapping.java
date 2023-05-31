package com.fiona.Config;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModeMapping {
    //        ! todo  WHY do we need this bean ???? If we need it, we can create a folder called configs of the root repository then add the bean. -done
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
