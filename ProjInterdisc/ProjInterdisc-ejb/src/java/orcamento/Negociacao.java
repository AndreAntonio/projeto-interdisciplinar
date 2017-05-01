/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orcamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31548751
 */
@Entity
@Table(name = "NEGOCIACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Negociacao.findAll", query = "SELECT n FROM Negociacao n")
    , @NamedQuery(name = "Negociacao.findByIdNegociacao", query = "SELECT n FROM Negociacao n WHERE n.idNegociacao = :idNegociacao")
    , @NamedQuery(name = "Negociacao.findByMensagem", query = "SELECT n FROM Negociacao n WHERE n.mensagem = :mensagem")
    , @NamedQuery(name = "Negociacao.findByStatus", query = "SELECT n FROM Negociacao n WHERE n.status = :status")})
public class Negociacao implements Serializable {

    @Size(max = 144)
    @Column(name = "PEDIDO")
    private String pedido;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NEGOCIACAO")
    private Long idNegociacao;
    @Size(max = 200)
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "FK_ORCAMENTO", referencedColumnName = "ID_ORCAMENTO")
    @ManyToOne
    private Orcamento fkOrcamento;

    public Negociacao() {
    }

    public Negociacao(Long idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public Long getIdNegociacao() {
        return idNegociacao;
    }

    public void setIdNegociacao(Long idNegociacao) {
        this.idNegociacao = idNegociacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Orcamento getFkOrcamento() {
        return fkOrcamento;
    }

    public void setFkOrcamento(Orcamento fkOrcamento) {
        this.fkOrcamento = fkOrcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNegociacao != null ? idNegociacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negociacao)) {
            return false;
        }
        Negociacao other = (Negociacao) object;
        if ((this.idNegociacao == null && other.idNegociacao != null) || (this.idNegociacao != null && !this.idNegociacao.equals(other.idNegociacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "orcamento.Negociacao[ idNegociacao=" + idNegociacao + " ]";
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }
    
}
