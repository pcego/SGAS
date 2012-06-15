/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.IRepositorioPerfil;
import br.com.ademoc.sgas.DomainModel.Perfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOPerfil extends DAOGenerico<Perfil> implements IRepositorioPerfil {

    public DAOPerfil() {
        super(Perfil.class);
    }

    @Override
    protected Long getID(Perfil obj) {
        return obj.getId();
    }

    @Override
    public List<Perfil> listarTodos() {

        Query consulta = getManager().createQuery("select p from Perfil p");
        return consulta.getResultList();
    }

    @Override
    public List<Perfil> listarPorSexo(String sexo) {

        Query consulta = getManager().createQuery("select p from Perfil p where p.sexo= :sexo");
        consulta.setParameter("sexo", sexo);
        return consulta.getResultList();
    }

    @Override
    public List<Perfil> listarPorEscolaridade(String escolaridade) {

        Query consulta = getManager().createQuery("select p from Perfil p where p.escolaridade= :escolaridade");
        consulta.setParameter("escolaridade", escolaridade);
        return consulta.getResultList();
    }
}
