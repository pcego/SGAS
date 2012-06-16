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
@Table(name="profissionais")
public class Profissional extends DadosGeral implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")    
    private Long id;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="especialidade",nullable=false)
    private Especialidade especialidade;
            
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @Column(name="nome",length=100,nullable=false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dtnasc",nullable=false)
    private Date dtNasc;
    
    @Column(name="cartprofissional",length=30,nullable=false)
    private String cartProfissional;
    
    @Column(name="status",nullable=false)
    private boolean status;
    
    @Column(name="sexo",length=10,nullable=false)
    private String sexo;
    
    @Temporal(TemporalType.DATE)
    @Column(name="dtatualizacao")
    private Date dtAtualizacao;
    
    @ManyToOne(cascade=CascadeType.MERGE,fetch= FetchType.EAGER)
    @JoinColumn(name="usuarioatualizacao")
    private Usuario usuarioAtualizacao;
    
    public Profissional(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartProfissional() {
        return cartProfissional;
    }

    public void setCartProfissional(String cartProfissional) {
        this.cartProfissional = cartProfissional;
    }
   
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        if (!(object instanceof Profissional)) {
            return false;
        }
        Profissional other = (Profissional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Profissional[ id=" + id + " ]";
    }
    
}
