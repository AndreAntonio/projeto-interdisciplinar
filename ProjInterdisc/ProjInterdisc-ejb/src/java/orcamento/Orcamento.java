/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import Contrato.Contrato;
import Servico.Servico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lgd25
 */
@Entity
@Table(name = "ORCAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o")
    , @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.idOrcamento = :idOrcamento")
    , @NamedQuery(name = "Orcamento.findByValortot", query = "SELECT o FROM Orcamento o WHERE o.valortot = :valortot")
    , @NamedQuery(name = "Orcamento.findByStatus", query = "SELECT o FROM Orcamento o WHERE o.status = :status")
    , @NamedQuery(name = "Orcamento.findByTempoexecucao", query = "SELECT o FROM Orcamento o WHERE o.tempoexecucao = :tempoexecucao")})
public class Orcamento implements Serializable{

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
    @Size(max = 30)
    @Column(name = "TEMPOEXECUCAO")
    private String tempoexecucao; 
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Servico servico;
    @OneToMany(mappedBy = "fkOrcamento")
    private List<Item> itemList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Contrato contrato;
    @JoinColumn(name = "FK_SERVICO", referencedColumnName = "ID_SERVICO")
    @ManyToOne
    private Servico fkServico;

    public Orcamento() {
        itemList = new ArrayList();
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

    public String getTempoexecucao() {
        return tempoexecucao;
    }

    public void setTempoexecucao(String tempoexecucao) {
        this.tempoexecucao = tempoexecucao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    
    
    public void calculaValorTot(){
        double valortotal=0;
        for (Item item : itemList) {
            valortotal = valortotal +(item.getValor()*item.getQuantidade());
        }
        this.valortot = valortotal;
    }
    
    public void addItem(Item i){
        itemList.add(i);
    }
    
    public void removeItem(Item i){
        String descricao = i.getDescricao();
        double valor = i.getValor();
        int quant = i.getQuantidade();
        Item i2 = new Item();
        
        for (Item item : itemList) {
            if( item.getDescricao().equals(descricao) && item.getValor()== valor && quant == item.getQuantidade() ){
                i2 = item;
            }
        }
        itemList.remove(i2);
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

    public Servico getFkServico() {
        return fkServico;
    }

    public void setFkServico(Servico fkServico) {
        this.fkServico = fkServico;
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
