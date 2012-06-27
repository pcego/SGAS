/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioTipoAparelho;
import br.com.ademoc.sgas.DomainModel.TipoAparelho;
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
@Named(value = "tipoAparelho")
@RequestScoped
public class TipoAparelhoBean implements Serializable {

    @EJB
    IRepositorioTipoAparelho repo;
    private String codigo;
    private String descricao;
    List<TipoAparelho> listagem;

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

    public void salvar() {
        try {
            TipoAparelho tipoAparelho = new TipoAparelho();
            tipoAparelho.setDescricao(descricao);
            repo.salvar(tipoAparelho);
            FacesMessage messageConfirme = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, messageConfirme);
        } catch (Exception e) {
            FacesMessage messageConfirme = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, messageConfirme);
        }
    }

    public void apagar() {
        TipoAparelho tipoAparelho = new TipoAparelho();
        Long id = Long.parseLong(codigo);
        tipoAparelho.setId(id);
        try {
            repo.apagar(tipoAparelho);
            FacesMessage message = new FacesMessage("Excluido com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public TipoAparelhoBean() {
    }

    public List<TipoAparelho> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodos();
        }
        return listagem;
    }

    public void setListagem(List<TipoAparelho> listagem) {
        this.listagem = listagem;
    }
}
