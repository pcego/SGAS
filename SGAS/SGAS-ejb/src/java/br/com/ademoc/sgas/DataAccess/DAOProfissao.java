/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Especialidade;
import br.com.ademoc.sgas.DomainModel.IRepositorioProfissao;
import br.com.ademoc.sgas.DomainModel.Profissao;
import br.com.ademoc.sgas.DomainModel.Profissional;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOProfissao extends DAOGenerico<Profissao> implements IRepositorioProfissao {

    public DAOProfissao() {
        super(Profissao.class);
    }

    @Override
    protected Long getID(Profissao obj) {
        return obj.getId();
    }

    @Override
    public List<Profissao> listaTodos() {
        
        Query consulta = getManager().createQuery("select prof from Profissao prof order by prof.descricao");
        return consulta.getResultList();
    }

    @Override
    public List<Profissao> listaPorDescricao(String descricao) {
        
        Query consulta = getManager().createQuery("select prof from Profissao prof where prof.descricao= :descricao order by prof.descricao");
        consulta.setParameter("descricao", descricao);
        return consulta.getResultList();
    }

   
}
