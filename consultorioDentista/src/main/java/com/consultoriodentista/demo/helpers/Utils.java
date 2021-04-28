package com.consultoriodentista.demo.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Utils {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
