/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOEncaminhamento extends DAOGenerico<Encaminhamento> implements IRepositorioEncaminhamento {

    public DAOEncaminhamento() {
        super(Encaminhamento.class);
    }
    
    
    @Override
    protected Long getID(Encaminhamento obj) {
       return obj.getId();
    }

    @Override
    public List<Encaminhamento> listaTodos() {
        Query consulta = getManager().createQuery("select enc from Encaminhamento enc");
        return consulta.getResultList();
    }

    @Override
    public List<Encaminhamento> listaPorVaga(Vaga vaga) {
        Query consulta = getManager().createQuery("select enc from Encaminhamento enc where enc.vaga = :vaga");
        consulta.setParameter("vaga", vaga);
        return consulta.getResultList();
    }

    @Override
    public List<Encaminhamento> listaPorCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Encaminhamento> listaPorData(Date data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Encaminhamento> listaPorUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
