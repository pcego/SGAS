/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioProfissional;
import br.com.ademoc.sgas.DomainModel.Profissional;
import br.com.ademoc.sgas.DomainModel.Especialidade;
import br.com.ademoc.sgas.DomainModel.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author www
 */
@Named(value = "profissionalBean")
@RequestScoped
public class ProfissionalBean implements Serializable {

    @EJB
    IRepositorioProfissional repo;
    private String codigo;
    private Especialidade especialidade;
    private Usuario usuario;
    private String nome;
    private Date dtnasc;
    private String cartProfissional;
    private boolean status;
    private String sexo;
    private Date dtAtualizacao;
    private Usuario usuarioAtualizacao;
    Calendar calendar = Calendar.getInstance();

    public ProfissionalBean() {
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getCartProfissional() {
        return cartProfissional;
    }

    public void setCartProfissional(String cartProfissional) {
        this.cartProfissional = cartProfissional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(Usuario usuarioAtualizacao) {
        this.usuarioAtualizacao = usuarioAtualizacao;
    }

    public void salvar() {
        Profissional profissional = new Profissional();

        profissional.setEspecialidade(especialidade);
        profissional.setUsuario(usuario);
        profissional.setNome(nome);
        profissional.setDtNasc(dtnasc);
        profissional.setCartProfissional(cartProfissional);
        profissional.setStatus(status);
        profissional.setDtAtualizacao(calendar.getTime());
        profissional.setUsuarioAtualizacao(usuarioAtualizacao);


        boolean confirme;
        confirme = repo.salvar(profissional);

        if (confirme == true) {
            FacesMessage message = new FacesMessage("Salvo com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() {
        Profissional profissional = new Profissional();
        Long id = Long.parseLong(codigo);
        profissional.setId(id);

        boolean confirme;

        confirme = repo.apagar(profissional);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
