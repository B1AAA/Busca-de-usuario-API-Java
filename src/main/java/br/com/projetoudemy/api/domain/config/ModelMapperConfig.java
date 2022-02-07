package br.com.projetoudemy.api.domain.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {// MAPEAR O DTO NO RETORNO FindById

    @Bean
    public ModelMapper mapper(){
      return new ModelMapper();
    }

}
