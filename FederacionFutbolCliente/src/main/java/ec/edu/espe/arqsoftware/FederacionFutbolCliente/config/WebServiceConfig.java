/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbolCliente.config;

import ec.edu.espe.arqsoftware.FederacionFutbolCliente.service.LocalidadPartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 * @author valen
 */

@Configuration
public class WebServiceConfig {
    @Autowired
    private LocalidadPartidoService client;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ec.edu.espe.arqsoftware.FederacionFutbolCliente.wsdl");
        return marshaller;
    }

    @Bean
    @Primary
    public LocalidadPartidoService localidadPartidoService(Jaxb2Marshaller marshaller) {
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
