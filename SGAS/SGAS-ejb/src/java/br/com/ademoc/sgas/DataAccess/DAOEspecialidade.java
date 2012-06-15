/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Especialidade;
import br.com.ademoc.sgas.DomainModel.IRepositorioEspecialidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOEspecialidade extends DAOGenerico<Especialidade> implements IRepositorioEspecialidade {

    public DAOEspecialidade() {
        super(Especialidade.class);
    }

    @Override
    protected Long getID(Especialidade obj) {
        return obj.getId();
    }

    @Override
    public List<Especialidade> listaTodos() {
        Query consulta = getManager().createQuery("select esp from Especialidade esp");
        return consulta.getResultList();
    }
}
