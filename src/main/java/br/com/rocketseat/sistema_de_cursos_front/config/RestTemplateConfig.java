package br.com.rocketseat.sistema_de_cursos_front.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate ( ) {
        var requestFactory = new HttpComponentsClientHttpRequestFactory ( );
        requestFactory.setConnectTimeout ( 5000 );

        var restTemplate = new RestTemplate ( );
        restTemplate.setRequestFactory ( requestFactory );

        return restTemplate;
    }
}
