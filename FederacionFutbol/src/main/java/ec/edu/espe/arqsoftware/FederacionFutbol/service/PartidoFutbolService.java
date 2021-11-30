/*
 * Copyright (c) 2021
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.service;


import ec.edu.espe.arqsoftware.FederacionFutbol.dao.PartidoFutbolRepository;
import ec.edu.espe.arqsoftware.FederacionFutbol.exception.FindException;
import ec.edu.espe.arqsoftware.FederacionFutbol.model.PartidoFutbol;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartidoFutbolService {

    private final PartidoFutbolRepository partidoFutbolRepo;

    public PartidoFutbolService(PartidoFutbolRepository partidoFutbolRepo) {
        this.partidoFutbolRepo = partidoFutbolRepo;
        
    }

    public List<PartidoFutbol> obtenerPartidosDisponibles(){
        PartidoFutbol partidoFutbol = new PartidoFutbol();
        LocalDateTime fechaActual = LocalDateTime.now(ZoneId.of("America/New_York")).withNano(0);
        if(partidoFutbol.getFecha().after(fechaActual)){
            return this.partidoFutbolRepo.findAll();
        }else{
            throw new FindException("No hay partidos disponibles");
        }
    }

    
}
