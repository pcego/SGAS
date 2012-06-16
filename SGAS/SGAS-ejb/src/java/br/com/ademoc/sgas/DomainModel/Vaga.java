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
@Table(name="vagas")
public class Vaga implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private Long id;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="empresa",nullable=false)
    private Empresa empresa;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @Column(name="descricao",length=100,nullable=false)
    private String descricao;
    
    @Column(name="status",nullable=false)
    private boolean status;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dtinclusao",nullable=false)
    private Date dtInclusao;
    
    public Vaga(){
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Vaga[ id=" + id + " ]";
    }
    
}
