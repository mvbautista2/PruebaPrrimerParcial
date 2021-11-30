/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.EndPoint;


import ec.edu.espe.arqsoftware.FederacionFutbol.exception.CreateException;
import ec.edu.espe.arqsoftware.FederacionFutbol.model.LocalidadPartido;
import ec.edu.espe.arqsoftware.FederacionFutbol.service.LocalidadPartidoService;
import ec.edu.espe.arqsoftware.federacionfutbol.ws.LocalidadesRS;
import ec.edu.espe.arqsoftware.federacionfutbol.ws.ObtenerLocalidadesDisponiblesRequest;
import ec.edu.espe.arqsoftware.federacionfutbol.ws.ObtenerLocalidadesDisponiblesResponse;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author valen
 */
@Endpoint
@Slf4j
public class LocalidadPartidoEndpoint {

    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/FederacionFutbol/ws";

    @Autowired
    public LocalidadPartidoEndpoint(LocalidadPartidoService service) {
        this.service = service;
    }

    private final LocalidadPartidoService service;
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerLocalidadPartidoPorCodigoRequest")
    @ResponsePayload
    public ObtenerLocalidadesDisponiblesResponse obtenerLocalidadPartidoPorCodigo(@RequestPayload ObtenerLocalidadesDisponiblesRequest request) throws CreateException{
       String errorMessage = "Error de Busqueda.";
        try {
            LocalidadPartido localidadPartido = (LocalidadPartido) this.service.obtenerLocalidadPartidoPorCodigo(request.getCodigo());
            ObtenerLocalidadesDisponiblesResponse response = new ObtenerLocalidadesDisponiblesResponse();
            response.setLocalidadesRS((List<LocalidadesRS>) localidadPartido);
            return response;
        } catch (Exception e) {
            log.error(errorMessage);
            throw new RuntimeException();
        }
    }
    
    
    
}
