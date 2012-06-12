/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.event.Observes;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity Usuario
 *
 * @version 1.0
 * @since 1.0 06/06/2012
 * @author Kennedi Paulo S. Malheiros
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    @OneToOne(cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="dadosgeral")
    private DadosGeral dadosGeral;
    
    @Column(name = "logon", length = 50, nullable = false)
    private String logon;
    
    @Column(name = "senha", length = 32, nullable = false)
    private String senha;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dtcadastro", nullable = false)    
    private Date dtcadastro;
    
    @Column(name = "nivel", nullable = false)
    private boolean nivel;
    

    //Contrutor da Classe usuario
    public void Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String login) {
        this.logon = login;
    }

    public boolean isNivel() {
        return nivel;
    }

    public void setNivel(boolean nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Usuario[ id=" + id + " ]";
    }
}
