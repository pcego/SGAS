/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioTipoDeficiencia;
import br.com.ademoc.sgas.DomainModel.IRepositorioTipoAparelho;
import br.com.ademoc.sgas.DomainModel.IRepositorioCategoria;
import br.com.ademoc.sgas.DomainModel.TipoDeficiencia;
import br.com.ademoc.sgas.DomainModel.TipoAparelho;
import br.com.ademoc.sgas.DomainModel.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

/**
 *
 * @author www
 */
@Named(value = "tipoDeficienciaBean")
@RequestScoped
public class TipoDeficienciaBean implements Serializable {

    @EJB
    IRepositorioTipoDeficiencia repo;
    IRepositorioTipoAparelho repoTipoAparelho;
    IRepositorioCategoria repoCategoria;
    private String codigo;
    private TipoAparelho aparelho;
    private Categoria categoria;
    private String descricao;
    private TipoDeficiencia tipoDeficiencia;
    List<TipoDeficiencia> listagem;
    List<Categoria> categorias;
    List<TipoAparelho> aparelhos;

    public TipoDeficiencia getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setVenda(TipoDeficiencia tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
        this.codigo = tipoDeficiencia.getId().toString();
        this.aparelho = tipoDeficiencia.getTipoAparelho();
        this.categoria = tipoDeficiencia.getCategoria();
        this.descricao = tipoDeficiencia.getDescricao();
    }

    public List<TipoAparelho> getAparelhos() {
        if (aparelhos == null) {
            aparelhos = repoTipoAparelho.listaTodos();
        }
        return aparelhos;
    }

    public void setAparelhos(List<TipoAparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }

    public List<Categoria> getCategorias() {
        if (categorias == null) {
            categorias = repoCategoria.listaTodas();
        }
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<TipoDeficiencia> getListagem() {
        if (listagem == null) {
            listagem = repo.listarTodos();
        }

        return listagem;
    }

    public void setListagem(List<TipoDeficiencia> listagem) {
        this.listagem = listagem;
    }

    public List<TipoAparelho> buscaAparelhos(String val) {
        List<TipoAparelho> suggestions = new ArrayList<TipoAparelho>();
        for (TipoAparelho c : getAparelhos()) {
            if (c.getDescricao().startsWith(val)) {
                suggestions.add(c);
            }
        }
        return suggestions;
    }

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
        try {
            repo.salvar(deficiencia);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        TipoDeficiencia deficiencia = new TipoDeficiencia();
        Long id = Long.parseLong(codigo);
        deficiencia.setId(id);
        try {
            repo.apagar(deficiencia);
            FacesMessage message = new FacesMessage("Excluido com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
