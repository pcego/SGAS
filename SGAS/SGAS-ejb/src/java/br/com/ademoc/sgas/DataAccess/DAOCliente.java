/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Cliente;
import br.com.ademoc.sgas.DomainModel.IRepositorioCliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOCliente extends DAOGenerico<Cliente> implements IRepositorioCliente {

    public DAOCliente() {
        super(Cliente.class);
    }

    @Override
    protected Long getID(Cliente obj) {
        return obj.getId();
    }

    @Override
    public List<Cliente> listaTodos() {
        Query consulta = getManager().createQuery("select cli from Cliente cli");
        return consulta.getResultList();
    }

    @Override
    public List<Cliente> buscaPorCpf(String cpf) {
        Query consulta = getManager().createQuery("select cli from Cliente cli where cli.cpf=:cpf");
        consulta.setParameter("cpf", cpf);
        return consulta.getResultList();

    }

    @Override
    public List<Cliente> listaPorNome(String nome) {
        Query consulta = getManager().createQuery("select cli from Cliente cli where cli.nome like '%:nome%' order by c.nome");
        consulta.setParameter("nome", nome);
        return consulta.getResultList();

    }

    @Override
    public List<Cliente> listaContribuintes() {
        Query consulta = getManager().createQuery("select cli from Cliente cli where cli.contribuinte = 1");
        return consulta.getResultList();
    }
}
