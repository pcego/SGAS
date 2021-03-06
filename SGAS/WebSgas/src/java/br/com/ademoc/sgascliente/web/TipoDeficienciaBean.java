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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

/**
 *
 * @author www
 */
@Named(value = "tipoDeficienciaBean")
@SessionScoped
public class TipoDeficienciaBean implements Serializable {

    @EJB
    IRepositorioTipoDeficiencia repo;
    
    @EJB
    IRepositorioTipoAparelho repoTipoAparelho;
    
    @EJB
    IRepositorioCategoria repoCategoria;
    
    private String codigo;
    private TipoAparelho aparelho;
    private Categoria categoria;
    private String descricao;
    TipoDeficiencia tipoDeficiencia;
    List<TipoDeficiencia> listagem;
    List<Categoria> categorias;
    List<TipoAparelho> aparelhos;
    

    @Override
    public String toString() {
        return this.codigo
                + this.descricao;
    }

    public IRepositorioTipoDeficiencia getRepo() {
        return repo;
    }

    public void setRepo(IRepositorioTipoDeficiencia repo) {
        this.repo = repo;
    }

    public IRepositorioCategoria getRepoCategoria() {
        return repoCategoria;
    }

    public void setRepoCategoria(IRepositorioCategoria repoCategoria) {
        this.repoCategoria = repoCategoria;
    }

    public IRepositorioTipoAparelho getRepoTipoAparelho() {
        return repoTipoAparelho;
    }

    public void setRepoTipoAparelho(IRepositorioTipoAparelho repoTipoAparelho) {
        this.repoTipoAparelho = repoTipoAparelho;
    }

    public TipoDeficiencia getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiente(TipoDeficiencia tipoDeficiencia) {
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

    public List<Categoria> buscaCategorias(String val) {
        List<Categoria> suggestions = new ArrayList<Categoria>();
        for (Categoria c : getCategorias()) {
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
        
        if(tipoDeficiencia == null)
            tipoDeficiencia = new TipoDeficiencia();
        
        tipoDeficiencia.setCategoria(categoria);
        tipoDeficiencia.setTipoAparelho(aparelho);
        tipoDeficiencia.setDescricao(descricao);
        try {
            repo.salvar(tipoDeficiencia);
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
