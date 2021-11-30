/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbolCliente.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author valen
 */
@Service
@Slf4j
public class LocalidadPartidoService extends WebServiceGatewaySupport{
        private String endpoint = "http://localhost:8090/ws/FederacionFutbol.wsdl";
        
        
        
    
}
