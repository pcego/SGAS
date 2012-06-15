/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import javax.ejb.Remote;

/**
 *
 * @author pcego
 */
@Remote
public interface IRepositorioDadosGeral extends Repositorio<DadosGeral> {
    
    DadosGeral getTodosOsDados(int codigo);
    
    
}
