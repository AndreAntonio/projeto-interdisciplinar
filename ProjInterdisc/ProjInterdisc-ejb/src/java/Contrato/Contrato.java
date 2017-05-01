/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato;

import Entidades.Usuario;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import orcamento.Orcamento;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c"),
    @NamedQuery(name = "Contrato.findByIdContrato", query = "SELECT c FROM Contrato c WHERE c.idContrato = :idContrato"),
    @NamedQuery(name = "Contrato.findByTermodocontrato", query = "SELECT c FROM Contrato c WHERE c.termodocontrato = :termodocontrato")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO")
    private Long idContrato;
    @Size(max = 1000)
    @Column(name = "TERMODOCONTRATO")
    private String termodocontrato;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_ORCAMENTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orcamento orcamento;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_TERMO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TermoDeAceite termoDeAceite;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Contrato() {
    }

    public Contrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public String getTermodocontrato() {
        return termodocontrato;
    }

    public void setTermodocontrato(String termodocontrato) {
        this.termodocontrato = termodocontrato;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public TermoDeAceite getTermoDeAceite() {
        return termoDeAceite;
    }

    public void setTermoDeAceite(TermoDeAceite termoDeAceite) {
        this.termoDeAceite = termoDeAceite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contrato.Contrato[ idContrato=" + idContrato + " ]";
    }
    
}
