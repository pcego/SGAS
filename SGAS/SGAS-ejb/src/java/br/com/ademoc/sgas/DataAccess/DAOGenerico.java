/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DataAccess;

import br.com.ademoc.sgas.DomainModel.Repositorio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pcego
 */
public abstract class DAOGenerico<T> implements Repositorio<T> {

    private Class type;
    @PersistenceContext(unitName = "SGAS-ejbPU")
    protected EntityManager manager;

    protected EntityManager getManager() {
        return manager;
    }

    public DAOGenerico(Class tipo) {
        type = tipo;

    }

    protected abstract Long getID(T obj);

    @Override
    public T abrir(Long codigo) throws Exception{
        
        return (T) getManager().find(type, codigo);
    }

    @Override
        public boolean apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
        public boolean salvar(T obj) {

        try {
            getManager().merge(obj);
            getManager().flush();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
}

