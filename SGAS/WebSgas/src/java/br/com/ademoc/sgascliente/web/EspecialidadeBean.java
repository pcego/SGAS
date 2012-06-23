/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioEspecialidade;
import br.com.ademoc.sgas.DomainModel.Especialidade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author www
 */
@Named(value = "especialidade")
@RequestScoped
public class EspecialidadeBean implements Serializable {
    
    @EJB
    IRepositorioEspecialidade repo;
    private String codigo;
    private String descricao;
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public EspecialidadeBean() {
    }
    
    public void salvar() {
        Especialidade especialidade = new Especialidade();
        especialidade.setDescricao(descricao);
        repo.salvar(especialidade);
        
    }
}
