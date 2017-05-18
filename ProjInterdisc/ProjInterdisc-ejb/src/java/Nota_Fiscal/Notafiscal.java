/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nota_Fiscal;

import Contrato.Contrato;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import orcamento.ItemDAO;

/**
 *
 * @author 157
 */
@Entity
@Table(name = "NOTAFISCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notafiscal.findAll", query = "SELECT n FROM Notafiscal n"),
    @NamedQuery(name = "Notafiscal.findByIdNotafiscal", query = "SELECT n FROM Notafiscal n WHERE n.idNotafiscal = :idNotafiscal"),
    @NamedQuery(name = "Notafiscal.findByDataEmissao", query = "SELECT n FROM Notafiscal n WHERE n.dataEmissao = :dataEmissao"),
    @NamedQuery(name = "Notafiscal.findByCustoTotal", query = "SELECT n FROM Notafiscal n WHERE n.custoTotal = :custoTotal")})
public class Notafiscal implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTAFISCAL")
    private Long idNotafiscal;
    @Column(name = "DATA_EMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CUSTO_TOTAL")
    private Double custoTotal;
    @JoinColumn(name = "FK_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne
    private Contrato fkContrato;

    public Notafiscal() {
    }

    public Notafiscal(Long idNotafiscal) {
        this.idNotafiscal = idNotafiscal;
    }

    public Long getIdNotafiscal() {
        return idNotafiscal;
    }

    public void setIdNotafiscal(Long idNotafiscal) {
        this.idNotafiscal = idNotafiscal;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public Contrato getFkContrato() {
        return fkContrato;
    }

    public void setFkContrato(Contrato fkContrato) {
        this.fkContrato = fkContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotafiscal != null ? idNotafiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notafiscal)) {
            return false;
        }
        Notafiscal other = (Notafiscal) object;
        if ((this.idNotafiscal == null && other.idNotafiscal != null) || (this.idNotafiscal != null && !this.idNotafiscal.equals(other.idNotafiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Afiliacao.Notafiscal[ idNotafiscal=" + idNotafiscal + " ]";
    }

   
    
}
