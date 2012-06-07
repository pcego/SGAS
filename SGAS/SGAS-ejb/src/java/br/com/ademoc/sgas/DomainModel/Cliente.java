/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author www
 */
@Entity (name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="codigo")
    private Long id;
    
    @OneToOne
    private DadosGeral dadosGeral;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private TipoDeficiencia tipoDeficiencia;
    
    @Column (name="nome", length=100, nullable=false)
    private String nome;
    
    @Column (name="rg", length=12, nullable=true)
    private String rg;
    
    @Column(name="rgOrgaoExpedidor", length=10, nullable=true)
    private String rgOrgaoExpedidor;
    
    @Temporal(TemporalType.DATE)
    private Date rgDataExpedicao;

    
    @Column (name="cpf", length=14, nullable=true, unique=false)
    private String cpf;
    
    @Column (name="tituloEleitor", length=20, nullable=true)
    private String tituloEleitor;
    
    @Column (name="tituloZona", nullable=true)
    private int tituloZona;
    
    @Column (name="tituloSecao", nullable=true)
    private int tituloSecao;
    
    @Column (name="cnh", length=20, nullable=true)
    private String cnh;
    
    @Column (name="categoriaCNH", length=2, nullable=true)
    private String categoriaCNH;
    
    //Certidao de Nascimento
    @Column (name="certNasc", length=15, nullable=true)
    private String certNasc;
    
    //Quanidade de Feficiente na Familia
    @Column (name="qtdDefFamilia", nullable=false)
    private int qtdDefFamilia;
    
    @Column (name="rendaFamiliar", nullable=false)
    private double rendaFamiliar;
    
    @Column (name="moradia", length=20, nullable=false)
    private String moradia;

    @Column (name="contribuinte", nullable=false)
    private Boolean contribuinte;
    
    @Column (name="escolaridade", length=50, nullable=false)
    private String escolaridade;
    
    @Column (name="estadoCivil", length=15, nullable=false)
    private String estadoCivil;
    
    @Column (name="filiacaoMae", length=100, nullable=false)
    private String filiacaoMae;
    
    @Column (name="filiacaoPai", length=100, nullable=false)
    private String filiacaoPai;
    
    //Data de Nascimento
    @Temporal (TemporalType.DATE)
    private Date dtNasc;
    
    @Column (name="sexo", length=10, nullable=false)
    private String sexo;
    
    @Column (name="obs", length=255, nullable=true)
    private String obs;
    
    @Column (name="naturalidade", length=30, nullable=false)
    private String naturalidade;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @ManyToMany
    private Usuario usuarioAtualizacao;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
