/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioProfissao;
import br.com.ademoc.sgas.DomainModel.Profissao;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "profissaoBean")
@RequestScoped
public class ProfissaoBean {

    @EJB
    IRepositorioProfissao repo;
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

    public void salvar() {
        Profissao profissao = new Profissao();

        profissao.setDescricao(descricao);

        boolean confirme;
        confirme = repo.salvar(profissao);

        if (confirme == true) {
            FacesMessage message = new FacesMessage("Salvo com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        Profissao profissao = new Profissao();
        Long id = Long.parseLong(codigo);
        profissao.setId(id);

        boolean confirme;

        confirme = repo.apagar(profissao);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public ProfissaoBean() {
    }
}
