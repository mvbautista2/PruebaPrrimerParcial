/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author valen
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "partido_futbol")

public class PartidoFutbol implements Serializable {

    
    @Id
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "equipo_local")
    private String equipoLocal;
    
    @Column(name = "equipo_visita")
    private String equipoVisita;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "lugar")
    private String lugar;
    @OneToMany(mappedBy = "codigo")
    private List<LocalidadPartido> localidadPartidoList;

    
}
