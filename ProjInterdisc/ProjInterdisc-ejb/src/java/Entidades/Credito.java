/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findByIdCredito", query = "SELECT c FROM Credito c WHERE c.idCredito = :idCredito"),
    @NamedQuery(name = "Credito.findByTipo", query = "SELECT c FROM Credito c WHERE c.tipo = :tipo")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CREDITO")
    private Long idCredito;
    @Column(name = "TIPO")
    private Integer tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "credito")
    private Pagamento pagamento;

    public Credito() {
    }

    public Credito(Long idCredito) {
        this.idCredito = idCredito;
    }

    public Long getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(Long idCredito) {
        this.idCredito = idCredito;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredito != null ? idCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.idCredito == null && other.idCredito != null) || (this.idCredito != null && !this.idCredito.equals(other.idCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Credito[ idCredito=" + idCredito + " ]";
    }
    
}
