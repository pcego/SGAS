/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioEspecialidade;
import br.com.ademoc.sgas.DomainModel.Especialidade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
    List<Especialidade> listagem;

    public List<Especialidade> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodos();
        }
        return listagem;
    }

    public void setListagem(List<Especialidade> listagem) {
        this.listagem = listagem;
    }

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
        try {
            repo.salvar(especialidade);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
        }
    }
    public void apagar() {
        Especialidade especialidade = new Especialidade();
        Long id = Long.parseLong(codigo);
        especialidade.setId(id);
        try {
            repo.apagar(especialidade);
            FacesMessage message = new FacesMessage("Excluido com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
