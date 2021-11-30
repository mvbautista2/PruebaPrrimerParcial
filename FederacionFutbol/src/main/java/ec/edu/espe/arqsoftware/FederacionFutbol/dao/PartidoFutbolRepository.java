/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.dao;

import ec.edu.espe.arqsoftware.FederacionFutbol.model.PartidoFutbol;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author valen
 */
public interface PartidoFutbolRepository extends JpaRepository<PartidoFutbol,String>{
    
}
