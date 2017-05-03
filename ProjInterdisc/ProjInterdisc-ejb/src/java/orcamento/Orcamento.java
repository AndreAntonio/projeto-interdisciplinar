/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import Contrato.Contrato;
import Servico.Servico;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 31520731
 */
@Entity
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")
    , @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento")
    , @NamedQuery(name = "Orcamento.findByValortot", query = "SELECT o FROM Orcamento o WHERE o.valortot = :valortot")
    , @NamedQuery(name = "Orcamento.findByStatus", query = "SELECT o FROM Orcamento o WHERE o.status = :status")
    , @NamedQuery(name = "Orcamento.findByTempotot", query = "SELECT o FROM Orcamento o WHERE o.tempotot = :tempotot")
    , @NamedQuery(name = "Orcamento.findByValidade", query = "SELECT o FROM Orcamento o WHERE o.validade = :validade")})
public class Orcamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORCAMENTO")
    private Long idOrcamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOT")
    private Double valortot;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "TEMPOTOT")
    private String tempotot;
    @Column(name = "VALIDADE")
    @Temporal(TemporalType.DATE)
    private Date validade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Servico servico;
    @OneToMany(mappedBy = "fkOrcamento")
    private List<Item> itemList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Contrato contrato;
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

    public Double getValortot() {
        return valortot;
    }

    public void setValortot(Double valortot) {
        this.valortot = valortot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTempotot() {
        return tempotot;
    }

    public void setTempotot(String tempotot) {
        this.tempotot = tempotot;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
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
        return "Contrato.Orcamento[ idOrcamento=" + idOrcamento + " ]";
    }
    
}
