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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import orcamento.Item;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "MAO_DE_OBRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaoDeObra.findAll", query = "SELECT m FROM MaoDeObra m"),
    @NamedQuery(name = "MaoDeObra.findByIdMaoDeObra", query = "SELECT m FROM MaoDeObra m WHERE m.idMaoDeObra = :idMaoDeObra"),
    @NamedQuery(name = "MaoDeObra.findByDescricao", query = "SELECT m FROM MaoDeObra m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "MaoDeObra.findByTempoexecucao", query = "SELECT m FROM MaoDeObra m WHERE m.tempoexecucao = :tempoexecucao")})
public class MaoDeObra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MAO_DE_OBRA")
    private Long idMaoDeObra;
    @Size(max = 144)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 100)
    @Column(name = "TEMPOEXECUCAO")
    private String tempoexecucao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "maoDeObra")
    private Item item;

    public MaoDeObra() {
    }

    public MaoDeObra(Long idMaoDeObra) {
        this.idMaoDeObra = idMaoDeObra;
    }

    public Long getIdMaoDeObra() {
        return idMaoDeObra;
    }

    public void setIdMaoDeObra(Long idMaoDeObra) {
        this.idMaoDeObra = idMaoDeObra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTempoexecucao() {
        return tempoexecucao;
    }

    public void setTempoexecucao(String tempoexecucao) {
        this.tempoexecucao = tempoexecucao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaoDeObra != null ? idMaoDeObra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaoDeObra)) {
            return false;
        }
        MaoDeObra other = (MaoDeObra) object;
        if ((this.idMaoDeObra == null && other.idMaoDeObra != null) || (this.idMaoDeObra != null && !this.idMaoDeObra.equals(other.idMaoDeObra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.MaoDeObra[ idMaoDeObra=" + idMaoDeObra + " ]";
    }
    
}
