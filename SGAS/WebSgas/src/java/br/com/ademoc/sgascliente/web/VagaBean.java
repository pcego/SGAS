/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import javax.inject.Named;
import br.com.ademoc.sgas.DomainModel.Vaga;
import br.com.ademoc.sgas.DomainModel.Empresa;
import br.com.ademoc.sgas.DomainModel.IRepositorioVaga;
import br.com.ademoc.sgas.DomainModel.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import br.com.ademoc.sgas.Util.UsuarioConectado;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "vagaBean")
@RequestScoped
public class VagaBean {

    @EJB
    IRepositorioVaga repo;
    private String codigo;
    private Empresa empresa;
    private Usuario usuario;
    private String descricao;
    private boolean statusVaga;
    private Date dataInclusao;
    Calendar calendar = Calendar.getInstance();
    List<Vaga> listagem;

    public VagaBean() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean isStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(boolean statusVaga) {
        this.statusVaga = statusVaga;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar() {
        Vaga vaga = new Vaga();
        vaga.setEmpresa(empresa);
        vaga.setUsuario(UsuarioConectado.getUsuarioConectado());
        vaga.setDescricao(descricao);
        vaga.setStatus(statusVaga);
        vaga.setDtInclusao(calendar.getTime());
        try {
            repo.salvar(vaga);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        Vaga vaga = new Vaga();
        Long id = Long.parseLong(codigo);
        vaga.setId(id);
        try {
            repo.apagar(vaga);
            FacesMessage message = new FacesMessage("Excluido com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<Vaga> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodos();
        }
        return listagem;
    }

    public void setListagem(List<Vaga> listagem) {
        this.listagem = listagem;
    }
     
   
}
