/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author pcego , kennedi Paulo S. Malheiros
 */
@Remote
public interface IRepositorioEspecialidade extends Repositorio<Especialidade> {
    
    List<Especialidade> listaTodos();
    
}
