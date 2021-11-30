/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.FederacionFutbol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author valen
 */
@Entity
@Data
@NoArgsConstructor
public class LocalidadPartido implements Serializable {

    
    @Id
    
    @Column(name = "codigo_localidad")
    private String codigoLocalidad;
    
    @Column(name = "disponibilidad")
    private int disponibilidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "precio")
    private BigDecimal precio;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne
    private PartidoFutbol codigo;

    
    
}
