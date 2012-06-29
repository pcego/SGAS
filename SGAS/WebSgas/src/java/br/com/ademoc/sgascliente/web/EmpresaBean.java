/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import br.com.ademoc.sgas.DomainModel.Empresa;
import br.com.ademoc.sgas.DomainModel.IRepositorioEmpresa;
import javax.ejb.EJB;
import br.com.ademoc.sgas.DomainModel.Usuario;
import br.com.ademoc.sgas.Util.UsuarioConectado;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



/**
 *
 * @author www
 */
@Named(value = "empresaBean")
@RequestScoped
public class EmpresaBean {

    @EJB
    IRepositorioEmpresa repo;
    
    private String codigo;
    private Usuario usuario;
    private String razaoSocial;
    private String fantasia;
    private String ramoAtividade;
    private String cnpj;
    private String iscricao;
    private String responsavel;
    private Usuario usuarioAtualizacao;
    Calendar calendar = Calendar.getInstance();
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
    List<Empresa> listagem;

    public List<Empresa> getListagem() {
        if (listagem == null) {
            listagem = repo.listaTodas();
        }
        return listagem;
    }

    public void setListagem(List<Empresa> listagem) {
        this.listagem = listagem;
    }
    
    

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    
    
    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getIscricao() {
        return iscricao;
    }

    public void setIscricao(String iscricao) {
        this.iscricao = iscricao;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public IRepositorioEmpresa getRepo() {
        return repo;
    }

    public void setRepo(IRepositorioEmpresa repo) {
        this.repo = repo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    
    public void salvar(){
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(razaoSocial);
        empresa.setFantasia(fantasia);
        empresa.setRamoAtividade(ramoAtividade);
        empresa.setCnpj(cnpj);
        empresa.setInscricao(iscricao);
        empresa.setReponsavel(responsavel);
        empresa.setDataCadastro(calendar.getTime());        
        empresa.setUsuarioAtualizacao(UsuarioConectado.getUsuarioConectado());
        empresa.setEndRua(endRua);
        empresa.setEndNumero(endNumero);
        empresa.setEndComplemento(endComplemento);
        empresa.setEndBairro(endBairro);
        empresa.setEndEstado(endEstado);
        empresa.setEndCidade(endCidade);
        empresa.setEndCep(endCep);
        empresa.setEmail(email);
        empresa.setTelefone(telefone);
        empresa.setCelular(celular);
        empresa.setDataCadastro(calendar.getTime());
        try {
            repo.salvar(empresa);
            FacesMessage message = new FacesMessage("Salvo com Sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            FacesMessage message = new FacesMessage("ERRO so Salvar, verifique os campos, ou tente novamente mais tarde");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public EmpresaBean() {
    }
}
