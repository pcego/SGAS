/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @version 1.0
 * @since 1.0 07/06/2012
 * @author Kennedi Paulo S. Malheiros
 */
@Entity
@Table(name="dadosgerais")
public class DadosGeral implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="codigo") 
    private Long id;
    
    @Column(name="endrua", length=100, nullable=false)
    private String endRua;
    
    @Column(name="endnumero", nullable=false)
    private int endNumero;
    
    @Column(name="endcomplemento", length=100 ,nullable=true)
    private String endComplemento;
    
    @Column(name="endbairro", length=100, nullable=false)
    private String endBairro;
    
    @Column(name="endcidade", length=100, nullable=false)
    private String endCidade;
    
    @Column(name="endestado", length=20, nullable=false)
    private String endEstado;
    
    @Column(name="endcep", length=10, nullable=false)
    private String endCep;
    
    @Column(name="email", length=100, nullable=true)
    private String email;
    
    @Column(name="telefone", length=12, nullable=true)
    private String telefone;
    
    @Column(name="celular", length=12, nullable=true)
    private String celular;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datacadastro", nullable=false)
    private Date dataCadastro;
    
    public DadosGeral(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
        
    
    public String getEndRua() {
        return endRua;
    }

    
    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    
    public int getEndNumero() {
        return endNumero;
    }

    
    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }

    
    public String getEndComplemento() {
        return endComplemento;
    }

    
    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    
    public String getEndBairro() {
        return endBairro;
    }

    
    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    
    public String getEndCidade() {
        return endCidade;
    }

    
    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    
    public String getEndEstado() {
        return endEstado;
    }

    
    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    
    public String getEndCep() {
        return endCep;
    }

    
    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getTelefone() {
        return telefone;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getCelular() {
        return celular;
    }

    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        if (!(object instanceof DadosGeral)) {
            return false;
        }
        DadosGeral other = (DadosGeral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.DadosGeral[ id=" + id + " ]";
    }
}
