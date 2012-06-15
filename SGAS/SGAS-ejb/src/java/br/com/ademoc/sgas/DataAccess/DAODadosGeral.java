/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.DadosGeral;
import br.com.ademoc.sgas.DomainModel.IRepositorioDadosGeral;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAODadosGeral extends DAOGenerico<DadosGeral> implements IRepositorioDadosGeral {

    public DAODadosGeral() {
        super(DadosGeral.class);
    }

    @Override
    protected Long getID(DadosGeral obj) {
        return obj.getId();
    }

    @Override
    public DadosGeral getTodosOsDados(int codigo) {
        Query consulta = getManager().createQuery("select tdados from TodoOsDados tdados where tdados.codigo=:codigo");
        consulta.setParameter("codigo", codigo);
        return consulta.getResultList();
    }
}
