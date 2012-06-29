/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import br.com.ademoc.sgas.Util.UsuarioConectado;
import java.io.IOException;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;

/**
 *
 * @author www
 */
@Named(value = "validarUsuarioBean")
@SessionScoped
public class ValidarUsuarioBean implements Serializable {

    public ValidarUsuarioBean() {
    }
    @EJB
    IRepositorioUsuario repo;
    String login, senha, alerta;
    Usuario usuario;
    boolean confirma;

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
        usuario.setLogon(login);
        usuario.setSenha(senha);
        try {
            repo.validarUsuario(login, senha);
            System.out.println("Entrou na tela");
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

            return true;

        } catch (Exception e) {
            System.out.println("ERRO verificar usuario");
            FacesContext.getCurrentInstance().getExternalContext().redirect("loginInvalido.xhtml");
            return false;
        }
    }
}
