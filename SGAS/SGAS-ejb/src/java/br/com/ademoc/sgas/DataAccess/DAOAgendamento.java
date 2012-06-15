/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOAgendamento extends DAOGenerico<Agendamento> implements IRepositorioAgendamento {

    public DAOAgendamento() {
        super(Agendamento.class);
    }

    @Override
    protected Long getID(Agendamento obj) {
        return obj.getId();
    }

    @Override
    public List<Agendamento> listaTodosAgendamentos() {

        Query consulta = getManager().createQuery("select a from Agendamento a order by a.data");
        return consulta.getResultList();

    }

    @Override
    public List<Agendamento> listaPorData(Date data) {

        Query consulta = getManager().createQuery("select a from Agendamento a where a.data = :data");
        consulta.setParameter("data", data);
        return consulta.getResultList();

    }

    @Override
    public List<Agendamento> listaAgendamentoPorProfissional(Profissional profissional) {

        Query consulta = getManager().createQuery("select a from Agendamento a where a.profissional = :profissional");
        consulta.setParameter("profissional", profissional);
        return consulta.getResultList();
    }

    @Override
    public List<Agendamento> listaAgendamentoPorCliente(Cliente cliente) {

        Query consulta = getManager().createQuery("select a from Agendamento a where a.cliente = :cliente");
        consulta.setParameter("cliente", cliente);
        return consulta.getResultList();
    }

    @Override
    public List<Agendamento> listaPorUsuario(Usuario usuario) {

        Query consulta = getManager().createQuery("select a from Agendamento a where a.usuario = :usuario");
        consulta.setParameter("usuario", usuario);
        return consulta.getResultList();
    }

    @Override
    public void atualizaStatus() {

        Query consulta = getManager().createQuery("update Agendamento a set a.status = 1");
        consulta.executeUpdate();

    }
}
