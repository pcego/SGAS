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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @version 1.0
 * @since 1.0 07/06/2012
 * @author Kennedi Paulo S. Malheiros
 */
@Entity (name="dadosgerais")
public class DadosGeral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="codigo")
    private Long id;
    
    @Column (name="endRua", length=100, nullable=false)
    private String endRua;
    
    @Column (name="endNumero", nullable=false)
    private int endNumero;
    
    @Column (name="endComplemento", length=100 ,nullable=true)
    private String endComplemento;
    
    @Column (name="endbairro", length=100, nullable=false)
    private String endBairro;
    
    @Column (name="endCidade", length=100, nullable=false)
    private String endCidade;
    
    @Column (name="endEstado", length=20, nullable=false)
    private String endEstado;
    
    @Column (name="endCep", length=10, nullable=false)
    private String endCep;
    
    @Column (name="email", length=100, nullable=true)
    private String email;
    
    @Column (name="telefone", length=12, nullable=true)
    private String telefone;
    
    @Column (name="celular", length=12, nullable=true)
    private String celular;
    
    @Temporal (TemporalType.TIMESTAMP)
    @Column (name="dataCadastro", nullable=false)
    private Date dataCadastro;

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
