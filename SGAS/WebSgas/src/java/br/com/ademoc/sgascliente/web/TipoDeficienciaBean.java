/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioTipoDeficiencia;
import br.com.ademoc.sgas.DomainModel.TipoDeficiencia;
import br.com.ademoc.sgas.DomainModel.TipoAparelho;
import br.com.ademoc.sgas.DomainModel.Categoria;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "tipoDeficienciaBean")
@RequestScoped
public class TipoDeficienciaBean implements Serializable{

    @EJB
    IRepositorioTipoDeficiencia repo;
    private String codigo;
    private TipoAparelho aparelho;
    private Categoria categoria;
    private String descricao;

    public TipoAparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(TipoAparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
    

    public TipoDeficienciaBean() {
    }
    
        public void salvar() {
        TipoDeficiencia deficiencia = new TipoDeficiencia();
        
        deficiencia.setCategoria(categoria);
        deficiencia.setTipoAparelho(aparelho);
        deficiencia.setDescricao(descricao);

        boolean confirme;
        confirme = repo.salvar(deficiencia);

        if (confirme == true) {
            FacesMessage message = new FacesMessage("Salvo com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        TipoDeficiencia deficiencia = new TipoDeficiencia();
        Long id = Long.parseLong(codigo);
        deficiencia.setId(id);

        boolean confirme;

        confirme = repo.apagar(deficiencia);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
