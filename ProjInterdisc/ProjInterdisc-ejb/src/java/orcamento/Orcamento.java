/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 31548751
 */
@Entity
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")
    , @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento")
    , @NamedQuery(name = "Orcamento.findByFkCliente", query = "SELECT o FROM Orcamento o WHERE o.fkCliente = :fkCliente")
    , @NamedQuery(name = "Orcamento.findByFkFornecedor", query = "SELECT o FROM Orcamento o WHERE o.fkFornecedor = :fkFornecedor")
    , @NamedQuery(name = "Orcamento.findByTempoexec", query = "SELECT o FROM Orcamento o WHERE o.tempoexec = :tempoexec")
    , @NamedQuery(name = "Orcamento.findByStatus", query = "SELECT o FROM Orcamento o WHERE o.status = :status")
    , @NamedQuery(name = "Orcamento.findByDatValidade", query = "SELECT o FROM Orcamento o WHERE o.datValidade = :datValidade")})
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Long idOrcamento;
    @Column(name = "FK_CLIENTE")
    private BigInteger fkCliente;
    @Column(name = "FK_FORNECEDOR")
    private BigInteger fkFornecedor;
    @Size(max = 50)
    @Column(name = "TEMPOEXEC")
    private String tempoexec;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "DAT_VALIDADE")
    private String datValidade;
    @OneToMany(mappedBy = "fkOrcamento")
    private List<Item> itemList;
    @OneToMany(mappedBy = "fkOrcamento")
    private List<Negociacao> negociacaoList;

    public Orcamento() {
    }

    public Orcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public BigInteger getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(BigInteger fkCliente) {
        this.fkCliente = fkCliente;
    }

    public BigInteger getFkFornecedor() {
        return fkFornecedor;
    }

    public void setFkFornecedor(BigInteger fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
    }

    public String getTempoexec() {
        return tempoexec;
    }

    public void setTempoexec(String tempoexec) {
        this.tempoexec = tempoexec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatValidade() {
        return datValidade;
    }

    public void setDatValidade(String datValidade) {
        this.datValidade = datValidade;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<Negociacao> getNegociacaoList() {
        return negociacaoList;
    }

    public void setNegociacaoList(List<Negociacao> negociacaoList) {
        this.negociacaoList = negociacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrcamento != null ? idOrcamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.idOrcamento == null && other.idOrcamento != null) || (this.idOrcamento != null && !this.idOrcamento.equals(other.idOrcamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orcamento.Orcamento[ idOrcamento=" + idOrcamento + " ]";
    }
    
}