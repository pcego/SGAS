/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.IRepositorioTipoDeficiencia;
import br.com.ademoc.sgas.DomainModel.TipoDeficiencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class DAOTipoDeficiencia extends DAOGenerico<TipoDeficiencia> implements IRepositorioTipoDeficiencia {
    
    public DAOTipoDeficiencia(){
        
        super(TipoDeficiencia.class);
    }
    
    @Override
    protected Long getID(TipoDeficiencia obj) {
        
        return obj.getId();
    }

    @Override
    public List listarTodos() {
        
        Query consulta = getManager().createQuery("select td from TipoDeficiencia td");
        return consulta.getResultList();
    }
    
}
