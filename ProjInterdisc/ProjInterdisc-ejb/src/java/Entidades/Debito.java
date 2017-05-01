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
@Table(name = "DEBITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debito.findAll", query = "SELECT d FROM Debito d"),
    @NamedQuery(name = "Debito.findByIdDebito", query = "SELECT d FROM Debito d WHERE d.idDebito = :idDebito"),
    @NamedQuery(name = "Debito.findByTipo", query = "SELECT d FROM Debito d WHERE d.tipo = :tipo")})
public class Debito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DEBITO")
    private Long idDebito;
    @Column(name = "TIPO")
    private Integer tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "debito")
    private Pagamento pagamento;

    public Debito() {
    }

    public Debito(Long idDebito) {
        this.idDebito = idDebito;
    }

    public Long getIdDebito() {
        return idDebito;
    }

    public void setIdDebito(Long idDebito) {
        this.idDebito = idDebito;
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
        hash += (idDebito != null ? idDebito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Debito)) {
            return false;
        }
        Debito other = (Debito) object;
        if ((this.idDebito == null && other.idDebito != null) || (this.idDebito != null && !this.idDebito.equals(other.idDebito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Debito[ idDebito=" + idDebito + " ]";
    }
    
}
