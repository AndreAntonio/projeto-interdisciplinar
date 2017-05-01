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
@Table(name = "PESSOA_FISICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findByIdPf", query = "SELECT p FROM PessoaFisica p WHERE p.idPf = :idPf"),
    @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")})
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PF")
    private Long idPf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CPF")
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
    private Cliente cliente;

    public PessoaFisica() {
    }

    public PessoaFisica(Long idPf) {
        this.idPf = idPf;
    }

    public PessoaFisica(Long idPf, String cpf) {
        this.idPf = idPf;
        this.cpf = cpf;
    }

    public Long getIdPf() {
        return idPf;
    }

    public void setIdPf(Long idPf) {
        this.idPf = idPf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        hash += (idPf != null ? idPf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.idPf == null && other.idPf != null) || (this.idPf != null && !this.idPf.equals(other.idPf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PessoaFisica[ idPf=" + idPf + " ]";
    }
    
}
