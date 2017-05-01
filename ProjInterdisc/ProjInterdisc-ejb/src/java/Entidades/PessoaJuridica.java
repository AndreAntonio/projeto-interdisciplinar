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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "PESSOA_JURIDICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findByIdPj", query = "SELECT p FROM PessoaJuridica p WHERE p.idPj = :idPj"),
    @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PJ")
    private Long idPj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CNPJ")
    private String cnpj;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaJuridica")
    private Cliente cliente;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Long idPj) {
        this.idPj = idPj;
    }

    public PessoaJuridica(Long idPj, String cnpj) {
        this.idPj = idPj;
        this.cnpj = cnpj;
    }

    public Long getIdPj() {
        return idPj;
    }

    public void setIdPj(Long idPj) {
        this.idPj = idPj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPj != null ? idPj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.idPj == null && other.idPj != null) || (this.idPj != null && !this.idPj.equals(other.idPj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PessoaJuridica[ idPj=" + idPj + " ]";
    }
    
}
