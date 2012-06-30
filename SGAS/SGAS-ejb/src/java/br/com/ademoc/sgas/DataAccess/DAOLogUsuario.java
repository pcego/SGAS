/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.IRepositorioLogUsuario;
import br.com.ademoc.sgas.DomainModel.LogUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOLogUsuario extends DAOGenerico<LogUsuario> implements IRepositorioLogUsuario{

    public DAOLogUsuario(){
        super(LogUsuario.class);
    }
    
    
    @Override
    protected Long getID(LogUsuario obj) {
        return obj.getId();
    }

    @Override
    public List<LogUsuario> listarTodos() {
        Query consulta = getManager().createQuery("select lusu from LogUsuario lusu order by lusu.dataAcesso");
        return consulta.getResultList();
    }
    
}
