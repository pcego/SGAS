/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author pcego
 */
@Named(value = "usuario")
@RequestScoped
public class UsuarioBean implements Serializable {

    @EJB
    IRepositorioUsuario repo;
    private String codigo;
    private String nome;
    private String logon;
    private String senha;
    private Date dtcadastro;
    private boolean nivel;
    private String endRua;
    private int endNumero;
    private String endComplemento;
    private String endBairro;
    private String endCidade;
    private String endEstado;
    private String endCep;
    private String email;
    private String telefone;
    private String celular;
    private Date dataCadastro;
    Calendar calendar = Calendar.getInstance();

    public UsuarioBean() {
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public boolean isNivel() {
        return nivel;
    }

    public void setNivel(boolean nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public int getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void abrir() {
        //Abrindo UsuarioBean
        Long id = Long.parseLong(codigo);
        Usuario usuario = null;
        try {
            usuario = repo.abrir(id);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao Carregar Usuario");
        }
        nome = usuario.getNome();
        logon = usuario.getLogon();
        senha = usuario.getSenha();
        dtcadastro = usuario.getDtcadastro();
        nivel = usuario.isNivel();
        endRua = usuario.getEndRua();
        endNumero = usuario.getEndNumero();
        endComplemento = usuario.getEndComplemento();
        endBairro = usuario.getEndBairro();
        endCidade = usuario.getEndCidade();
        endEstado = usuario.getEndEstado();
        endCep = usuario.getEndCep();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
        celular = usuario.getCelular();
        dataCadastro = usuario.getDataCadastro();
    }

    public void salvar() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogon(logon);
        usuario.setSenha(senha);
        usuario.setDtcadastro(calendar.getTime());
        usuario.setNivel(nivel);
        usuario.setEndRua(endRua);
        usuario.setEndNumero(endNumero);
        usuario.setEndComplemento(endComplemento);
        usuario.setEndBairro(endBairro);
        usuario.setEndCidade(endCidade);
        usuario.setEndEstado(endEstado);
        usuario.setEndCep(endCep);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setCelular(celular);
        usuario.setDataCadastro(calendar.getTime());
        try {
            repo.salvar(usuario);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar() throws Exception {
        Usuario usuario = new Usuario();
        Long id = Long.parseLong(codigo);
        usuario.setId(id);

        usuario = repo.abrir(id);
        boolean confirme;

        confirme = repo.apagar(usuario);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void apagar(String cod) {
        Usuario usuario = new Usuario();
        Long id = Long.parseLong(cod);
        usuario.setId(id);

        boolean confirme;

        confirme = repo.apagar(usuario);


        if (confirme == true) {
            FacesMessage message = new FacesMessage("Excluido com Sucesso");

            FacesContext.getCurrentInstance().addMessage(null, message);
        } else if (confirme == false) {
            FacesMessage message = new FacesMessage("ERRO ao Excluir, verifique os campos, ou tente novamente mais tarde");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    List<Usuario> listagem;

    public List<Usuario> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodos();
        }
        return listagem;
    }

    public void setListagem(List<Usuario> listagem) {
        this.listagem = listagem;
    }
}
