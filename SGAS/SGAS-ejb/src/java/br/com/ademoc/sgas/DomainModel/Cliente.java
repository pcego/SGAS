/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author www
 */
@Entity
@Table(name="clientes")
public class Cliente extends DadosGeral implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;
     
       
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="usuario",nullable=false)
    private Usuario usuario;
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE},fetch= FetchType.EAGER)
    @JoinColumn(name="tipodeficiencia",nullable=false)    
    private TipoDeficiencia tipoDeficiencia;
    
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    
    @Column(name = "rg", length = 12, nullable = true)
    private String rg;
    
    @Column(name = "rgOrgaoexpedidor", length = 10, nullable = true)
    private String rgOrgaoExpedidor;
    
    @Temporal(TemporalType.DATE)
    @Column(name="rgdataexpedicao",nullable= true)
    private Date rgDataExpedicao;
    
    @Column(name = "cpf", length = 14, nullable = true, unique = true)
    private String cpf;
    
    @Column(name = "tituloeleitor", length = 20, nullable = true)
    private String tituloEleitor;
    
    @Column(name = "titulozona", nullable = true)
    private int tituloZona;
    
    @Column(name = "titulosecao", nullable = true)
    private int tituloSecao;
    
    @Column(name = "cnh", length = 20, nullable = true)
    private String cnh;
    
    @Column(name = "categoriacnh", length = 2, nullable = true)
    private String categoriaCNH;
    
    //Certidao de Nascimento
    @Column(name = "certnasc", length = 15, nullable = true)
    private String certNasc;
    
    //Quanidade de Feficiente na Familia
    @Column(name = "qtddeffamilia", nullable = false)
    private int qtdDefFamilia;
    
    @Column(name = "rendafamiliar", nullable = false, length=100)
    private String rendaFamiliar;
    
    @Column(name = "moradia", length = 20, nullable = false)
    private String moradia;
    
    @Column(name = "contribuinte", nullable = false)
    private Boolean contribuinte;
    
    @Column(name = "escolaridade", length = 50, nullable = false)
    private String escolaridade;
    
    @Column(name = "estadocivil", length = 15, nullable = false)
    private String estadoCivil;
    
    @Column(name = "filiacaomae", length = 100, nullable = false)
    private String filiacaoMae;
    
    @Column(name = "filiacaopai", length = 100, nullable = true)
    private String filiacaoPai;
    
    //Data de Nascimento
    @Temporal(TemporalType.DATE)
    @Column(name="dtnasc")
    private Date dtNasc;
    
    @Column(name = "sexo", length = 10, nullable = false)
    private String sexo;
    
    @Column(name = "obs", length = 255, nullable = true)
    private String obs;
    
    @Column(name = "naturalidade", length = 30, nullable = false)
    private String naturalidade;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dtatualizacao")
    private Date dataAtualizacao;
    
    //Ultimo usuario que atualizou o cadastro.
    @ManyToOne(cascade= CascadeType.REFRESH,fetch= FetchType.EAGER)
    @JoinColumn(name="usuarioatualizacao", nullable=true)
    private Usuario usuarioAtualizacao;
    
    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, fetch= FetchType.EAGER)
    @JoinTable(name="clientes_profissoes", joinColumns={@JoinColumn(name="cliente_id")}, inverseJoinColumns={@JoinColumn(name="profissao_id")})        
    private List<Profissao> profissoes;

    public void Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public String getCertNasc() {
        return certNasc;
    }

    public void setCertNasc(String certNasc) {
        this.certNasc = certNasc;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Boolean getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Boolean contribuinte) {
        this.contribuinte = contribuinte;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFiliacaoMae() {
        return filiacaoMae;
    }

    public void setFiliacaoMae(String filiacaoMae) {
        this.filiacaoMae = filiacaoMae;
    }

    public String getFiliacaoPai() {
        return filiacaoPai;
    }

    public void setFiliacaoPai(String filiacaoPai) {
        this.filiacaoPai = filiacaoPai;
    }

    public String getMoradia() {
        return moradia;
    }

    public void setMoradia(String moradia) {
        this.moradia = moradia;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getQtdDefFamilia() {
        return qtdDefFamilia;
    }

    public void setQtdDefFamilia(int qtdDefFamilia) {
        this.qtdDefFamilia = qtdDefFamilia;
    }

    public String getRendaFamiliar() {
        return rendaFamiliar;
    }

    public void setRendaFamiliar(String rendaFamiliar) {
        this.rendaFamiliar = rendaFamiliar;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getRgDataExpedicao() {
        return rgDataExpedicao;
    }

    public void setRgDataExpedicao(Date rgDataExpedicao) {
        this.rgDataExpedicao = rgDataExpedicao;
    }

    public String getRgOrgaoExpedidor() {
        return rgOrgaoExpedidor;
    }

    public void setRgOrgaoExpedidor(String rgOrgaoExpedidor) {
        this.rgOrgaoExpedidor = rgOrgaoExpedidor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TipoDeficiencia getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(TipoDeficiencia tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public int getTituloSecao() {
        return tituloSecao;
    }

    public void setTituloSecao(int tituloSecao) {
        this.tituloSecao = tituloSecao;
    }

    public int getTituloZona() {
        return tituloZona;
    }

    public void setTituloZona(int tituloZona) {
        this.tituloZona = tituloZona;
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
    
    
    public List<Profissao> getProfissoes() {
        return profissoes;
    }

   
    public void setProfissoes(List<Profissao> profissoes) {
        this.profissoes = profissoes;
    }
    
    public void addProfissao(Profissao profissao){
        this.profissoes.add(profissao);
    }
    
    public void removeProfissao(Profissao profissao){
        this.profissoes.remove(profissao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ademoc.sgas.DomainModel.Cliente[ id=" + id + " ]";
    }

    
}
