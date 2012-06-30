/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;


import br.com.ademoc.sgas.DomainModel.IRepositorioLogUsuario;
import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import br.com.ademoc.sgas.DomainModel.LogUsuario;
import java.io.IOException;

import javax.inject.Named;
import java.io.Serializable;

import java.util.Calendar;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
//import sun.misc.BASE64Encoder;

/**
 *
 * @author www
 */
@Named(value = "validarUsuarioBean")
@RequestScoped
public class ValidarUsuarioBean implements Serializable {

    public ValidarUsuarioBean() {
    }
    @EJB
    IRepositorioUsuario repo;
    
    @EJB
    IRepositorioLogUsuario repoLogUsuario;
    String login, senha, alerta;
    Usuario usuario;
    boolean confirma;
    Calendar calendar = Calendar.getInstance();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificarUsuario() throws IOException {
        Usuario usuario = new Usuario();
        LogUsuario logUsuario = new LogUsuario();
        usuario .setLogon(login);
        usuario.setSenha(senha);
        logUsuario.setUsuario(login);
        logUsuario.setDataAcesso(calendar.getTime());
        try {
            repo.validarUsuarioWeb(login, senha);
            repoLogUsuario.salvar(logUsuario);
            FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");

            return true;

        } catch (Exception e) {
            System.out.println("ERRO verificar usuario");
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginInvalido.xhtml");
            return false;
        }
    }
}
