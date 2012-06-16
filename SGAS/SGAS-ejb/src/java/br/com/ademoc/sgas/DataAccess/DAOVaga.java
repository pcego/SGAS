/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Empresa;
import br.com.ademoc.sgas.DomainModel.IRepositorioVaga;
import br.com.ademoc.sgas.DomainModel.Vaga;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOVaga extends DAOGenerico<Vaga> implements IRepositorioVaga {

    public DAOVaga() {

        super(Vaga.class);
    }

    @Override
    protected Long getID(Vaga obj) {

        return obj.getId();
    }

    @Override
    public List<Vaga> listaTodos() {

        Query consulta = getManager().createQuery("select v from Vaga v");
        return consulta.getResultList();
    }

    @Override
    public List<Vaga> listaPorEmpresa(Empresa empresa) {

        Query consulta = getManager().createQuery("select v from Vaga v where v.empresa= :empresa order by v.dtInclusao");
        consulta.setParameter("empresa", empresa);
        return consulta.getResultList();
    }

    @Override
    public List<Vaga> listaPorDescricao(String descricao) {

        Query consulta = getManager().createQuery("select v from Vaga v where v.descricao= :descricao order by v.dtInclusao");
        consulta.setParameter("descricao", descricao);
        return consulta.getResultList();
    }

    @Override
    public List<Vaga> listaPorDataInclusao(Date data) {

        Query consulta = getManager().createQuery("select v from Vaga v where v.dtInclusao= :data order by v.dtInclusao");
        consulta.setParameter("data", data, TemporalType.DATE);
        return consulta.getResultList();
    }

    @Override
    public void fechaVaga() {
        
       Query consulta = getManager().createQuery("update Vaga v set v.status = 1");
        consulta.executeUpdate();
    }
    
}
