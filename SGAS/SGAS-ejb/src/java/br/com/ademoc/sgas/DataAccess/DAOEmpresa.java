/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Empresa;
import br.com.ademoc.sgas.DomainModel.IRepositorioEmpresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOEmpresa extends DAOGenerico<Empresa> implements IRepositorioEmpresa {

    public DAOEmpresa() {
        super(Empresa.class);
    }

    @Override
    protected Long getID(Empresa obj) {
        return obj.getId();
    }

    @Override
    public List<Empresa> listaTodas() {
        Query consulta = getManager().createQuery("select emp from Empresa emp ");
        return consulta.getResultList();
    }

    @Override
    public List<Empresa> listaPorCnpj(String cnpj) {
        Query consulta = getManager().createQuery("select emp from Empresa emp where emp.cnpj=:cnpj");
        consulta.setParameter("cnpj", cnpj);
        return consulta.getResultList();
    }

    @Override
    public List<Empresa> listaPorRazaoSocial(String nome) {
        Query consulta = getManager().createQuery("select emp from Empresa emp where like '% :Razao %' ");
        consulta.setParameter("nome", nome);
        return consulta.getResultList();
    }

    @Override
    public List<Empresa> listaPorRamoAtividade(String ramoAtividade) {
        Query consulta = getManager().createQuery("select emp from Empresa emp where like '% :ramoAtividade %' ");
        consulta.setParameter("ramoAtividade", ramoAtividade);
        return consulta.getResultList();

    }

}
