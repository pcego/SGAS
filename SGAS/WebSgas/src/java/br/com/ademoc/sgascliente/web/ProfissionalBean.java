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

/**
 *
 * @author www
 */
@Named(value = "profissional")
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
    private int usuarioAtualizacao;
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

    public int getUsuarioAtualizacao() {
        return usuarioAtualizacao;
    }

    public void setUsuarioAtualizacao(int usuarioAtualizacao) {
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
        profissional.setUsuarioAtualizacao(usuario);


    }
}
