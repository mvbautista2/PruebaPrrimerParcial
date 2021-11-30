/*
 * Copyright (c) 2021
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.service;


import ec.edu.espe.arqsoftware.FederacionFutbol.dao.LocalidadPartidoRepository;
import ec.edu.espe.arqsoftware.FederacionFutbol.model.LocalidadPartido;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocalidadPartidoService {

    public LocalidadPartidoService(LocalidadPartidoRepository localidadPartidoRepo) {
        this.localidadPartidoRepo = localidadPartidoRepo;
    }

    private final LocalidadPartidoRepository localidadPartidoRepo;

   
    public List<LocalidadPartido> obtenerLocalidadPartidoPorCodigo(String codigo) {
        List<LocalidadPartido> localidadPart = localidadPartidoRepo
                .findByCodigo(codigo);
        localidadPart.stream().filter(l -> ((l.getDisponibilidad())== 0)).forEachOrdered(l -> {
            localidadPart.remove(l);
        });
        return localidadPart;
       
    }
}

   
