/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOUsuario extends DAOGenerico<Usuario> implements IRepositorioUsuario {

    public DAOUsuario() {

        super(Usuario.class);
    }

    @Override
    protected Long getID(Usuario obj) {

        return obj.getId();
    }

    @Override
    public List<Usuario> listaPorNome(String nome) {

        Query consulta = getManager().createQuery("select u from Usuario u where u.nome= :nome order by u.nome");
        consulta.setParameter("nome", nome);
        return consulta.getResultList();
    }

    @Override
    public List<Usuario> listaPorCpf(String cpf) {

        Query consulta = getManager().createQuery("select u from Usuario u where u.cpf= :cpf order by u.nome");
        consulta.setParameter("cpf", cpf);
        return consulta.getResultList();
    }

    @Override
    public List<Usuario> listaTodos() {

        Query consulta = getManager().createQuery("select u from Usuario u order by u.nome");
        return consulta.getResultList();

    }
}
