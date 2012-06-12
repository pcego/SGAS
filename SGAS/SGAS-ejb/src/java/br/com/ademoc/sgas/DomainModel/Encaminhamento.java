/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pcego
 */
@Entity
@Table(name="encaminhamentos")
public class Encaminhamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Long id;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="vaga",nullable=false)
    private Vaga vaga;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="cliente",nullable=false)
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data",nullable=false)
    private Date data;
    
    public Encaminhamento(){
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encaminhamento)) {
            return false;
        }
        Encaminhamento other = (Encaminhamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Encaminhamento[ id=" + id + " ]";
    }
    
}
