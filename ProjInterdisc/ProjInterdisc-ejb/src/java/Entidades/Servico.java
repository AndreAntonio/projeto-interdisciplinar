/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import orcamento.Orcamento;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "SERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByIdServico", query = "SELECT s FROM Servico s WHERE s.idServico = :idServico"),
    @NamedQuery(name = "Servico.findByValor", query = "SELECT s FROM Servico s WHERE s.valor = :valor"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Servico.findByStatus", query = "SELECT s FROM Servico s WHERE s.status = :status"),
    @NamedQuery(name = "Servico.findByDatainicial", query = "SELECT s FROM Servico s WHERE s.datainicial = :datainicial"),
    @NamedQuery(name = "Servico.findByDatafinal", query = "SELECT s FROM Servico s WHERE s.datafinal = :datafinal")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private Long idServico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private Double valor;
    @Size(max = 120)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "STATUS")
    private Boolean status;
    @Column(name = "DATAINICIAL")
    @Temporal(TemporalType.DATE)
    private Date datainicial;
    @Column(name = "DATAFINAL")
    @Temporal(TemporalType.DATE)
    private Date datafinal;
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID_AVALIACAO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Avaliacao avaliacao;
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID_ORCAMENTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orcamento orcamento;
    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario fkUsuario;

    public Servico() {
    }

    public Servico(Long idServico) {
        this.idServico = idServico;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServico != null ? idServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idServico == null && other.idServico != null) || (this.idServico != null && !this.idServico.equals(other.idServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Servico[ idServico=" + idServico + " ]";
    }
    
}
