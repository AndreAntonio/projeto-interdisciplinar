/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

import Contrato.Contrato;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "TERMO_DE_ACEITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TermoDeAceite.findAll", query = "SELECT t FROM TermoDeAceite t"),
    @NamedQuery(name = "TermoDeAceite.findByIdTermo", query = "SELECT t FROM TermoDeAceite t WHERE t.idTermo = :idTermo"),
    @NamedQuery(name = "TermoDeAceite.findByTermo", query = "SELECT t FROM TermoDeAceite t WHERE t.termo = :termo")})
public class TermoDeAceite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TERMO")
    private Long idTermo;
    @Size(max = 500)
    @Column(name = "TERMO")
    private String termo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "termoDeAceite")
    private Contrato contrato;

    public TermoDeAceite() {
    }

    public TermoDeAceite(Long idTermo) {
        this.idTermo = idTermo;
    }

    public Long getIdTermo() {
        return idTermo;
    }

    public void setIdTermo(Long idTermo) {
        this.idTermo = idTermo;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTermo != null ? idTermo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermoDeAceite)) {
            return false;
        }
        TermoDeAceite other = (TermoDeAceite) object;
        if ((this.idTermo == null && other.idTermo != null) || (this.idTermo != null && !this.idTermo.equals(other.idTermo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TermoDeAceite[ idTermo=" + idTermo + " ]";
    }
    
}
