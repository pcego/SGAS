/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.IRepositorioTipoAparelho;
import br.com.ademoc.sgas.DomainModel.TipoAparelho;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOTipoAparelho extends DAOGenerico<TipoAparelho> implements IRepositorioTipoAparelho {

    public DAOTipoAparelho() {

        super(TipoAparelho.class);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    protected Long getID(TipoAparelho obj) {
        
        return obj.getId();
    }

    @Override
    public List<TipoAparelho> listaTodos() {
        
        Query consulta = getManager().createQuery("select ta from TipoAparelho ta order by ta.descricao");
        return consulta.getResultList();
    }
}
