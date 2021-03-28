package co.edu.utp.isc.gia.restuser.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {
    //Carga objetos/librerias de terceros
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
