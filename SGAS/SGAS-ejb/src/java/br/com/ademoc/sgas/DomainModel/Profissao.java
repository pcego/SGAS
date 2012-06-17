/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * @version 1.0
 * @since 1.0 06/06/2012
 * @author Kennedi Paulo S. Malheiros
 */
@Entity
@Table(name="profissoes")
public class Profissao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")    
    private Long id;
    
    @Column(name="descricao",length =100,nullable = false)
    private String descricao;
       
    @ManyToMany(mappedBy = "profissoes")
    private List<Cliente> cliente;

    //Construtor Classe
    public void Profissao() {
    }
    
    public List<Cliente> getCliente() {
        return cliente;
    }
    
    
    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void addCliente(Cliente cliente){
        this.cliente.add(cliente);
    }
    
    public void removeCliente(Cliente cliente){
        this.cliente.remove(cliente);
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
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Profissao[ id=" + id + " ]";
    }
}
