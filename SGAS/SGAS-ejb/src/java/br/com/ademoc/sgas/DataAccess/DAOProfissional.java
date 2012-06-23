/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Especialidade;
import br.com.ademoc.sgas.DomainModel.IRepositorioProfissional;
import br.com.ademoc.sgas.DomainModel.Profissional;
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
public class DAOProfissional extends DAOGenerico<Profissional> implements IRepositorioProfissional {

    public DAOProfissional() {
        super(Profissional.class);
    }

    @Override
    protected Long getID(Profissional obj) {
        
        return obj.getId();
    }

    @Override
    public List<Profissional> listaTodos() {
        
        Query consulta = getManager().createQuery("select p from Profissional p order by p.nome");
        return consulta.getResultList();
    }

    @Override
    public List<Profissional> listaPorNome(String nome) {
        
        Query consulta = getManager().createQuery("select p from Profissional p where p.nome= :nome order by p.nome");
        consulta.setParameter("nome", nome);
        return consulta.getResultList();
    }

    @Override
    public List<Profissional> listaPorEspecialidade(Especialidade especialidade) {
        
        Query consulta = getManager().createQuery("select p from Profissional p where p.especialidade= :especialidade order by p.nome");
        consulta.setParameter("especialidade", Especialidade.class);
        return consulta.getResultList();
    }

    @Override
    public List<Profissional> listaPorSexo(String sexo) {
        
        Query consulta = getManager().createQuery("select p from Profissional p where p.sexo= : sexo order by p.nome");
        consulta.setParameter("sexo", sexo);
        return consulta.getResultList();
    }

    @Override
    public List<Profissional> listaPorDataNasc(Date data) {
        
        Query consulta = getManager().createQuery("select p from Profissional p where p.dtNasc= :data order by p.nome");
        consulta.setParameter("data", data, TemporalType.DATE);
        return consulta.getResultList();
    }
}
