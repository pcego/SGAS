/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author pcego
 */

@Remote
public interface IRepositorioTipoDeficiencia extends Repositorio<TipoDeficiencia> {
    
    List<TipoDeficiencia> listarTodos();
    
}
