/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Categoria;
import br.com.ademoc.sgas.DomainModel.IRepositorioCategoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author www
 */
@Stateless
public class DAOCategoria extends DAOGenerico<Categoria> implements IRepositorioCategoria {

    public DAOCategoria() {
        super(Categoria.class);
    }

    @Override
    protected Long getID(Categoria obj) {
        return obj.getId();
    }

    @Override
    public List<Categoria> listaTodas() {
        Query consulta = getManager().createQuery("select c from Categoria c order by c.descricao");
        return consulta.getResultList();
    }
    
    
    
}
