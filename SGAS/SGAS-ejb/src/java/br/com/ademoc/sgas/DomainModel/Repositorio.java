/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import br.com.ademoc.sgas.DataAccess.DAOGenerico;
import javax.ejb.Remote;

/**
 *
 * @author pcego
 */

@Remote
public interface Repositorio <T>{
   
    public boolean salvar(T obj);
    public boolean apagar(T obj);    
    public T abrir(Long codigo) throws Exception;
   
    
}
