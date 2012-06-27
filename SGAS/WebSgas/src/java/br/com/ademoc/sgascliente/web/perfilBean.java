/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioPerfil;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import br.com.ademoc.sgas.DomainModel.Perfil;
import br.com.ademoc.sgas.DomainModel.Vaga;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "perfilBean")
@RequestScoped
public class perfilBean {

    @EJB
    IRepositorioPerfil repo;
    private String codigo;
    private Vaga vaga;
    private String habilidade;
    private String sexo;
    private int idadeMinima;
    private int idadeMaxima;
    private String escolaridade;

    public perfilBean() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void salvar() {
        Perfil perfil = new Perfil();
        perfil.setVaga(vaga);
        perfil.setHabilidades(habilidade);
        perfil.setSexo(sexo);
        perfil.setIdadeMinima(idadeMinima);
        perfil.setIdadeMaxima(idadeMaxima);
        perfil.setEscolaridade(escolaridade);
        try {
            repo.salvar(perfil);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        Perfil perfil = new Perfil();
        Long id = Long.parseLong(codigo);
        perfil.setId(id);
        try {
            repo.apagar(perfil);
            FacesMessage message = new FacesMessage("Excluido com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
