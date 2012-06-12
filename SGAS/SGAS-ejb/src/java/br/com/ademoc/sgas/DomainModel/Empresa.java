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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pcego
 */
@Entity
@Table(name="empresas")
public class Empresa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")    
    private Long id;
    
    @OneToOne(cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="dadosgerais",nullable=false)
    private DadosGeral dadosGeral;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @Column(name="razaosocial",length=100,nullable=false)
    private String razaoSocial;
    
    @Column(name="fantasia",length=100)
    private String fantasia;
    
    @Column(name="ramoatividade",length=100,nullable=false)
    private String ramoAtividade;
    
    @Column(name="cnpj",length=30,nullable=false,unique=true)
    private String cnpj;
    
    @Column(name="inscricao",length=30)
    private String inscricao;
    
    @Column(name="responsavel",length=100,nullable=false)
    private String reponsavel;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dtatualizacao")
    private Date dtAtualizacao;
    
    @ManyToOne(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
    @JoinColumn(name="usuarioatualizacao")
    private Usuario usuarioAtualizacao;
    
    public Empresa(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public DadosGeral getDadosGeral() {
        return dadosGeral;
    }

    public void setDadosGeral(DadosGeral dadosGeral) {
        this.dadosGeral = dadosGeral;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getReponsavel() {
        return reponsavel;
    }

    public void setReponsavel(String reponsavel) {
        this.reponsavel = reponsavel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(Usuario usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Empresa[ id=" + id + " ]";
    }
    
}
