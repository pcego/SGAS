/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 * 
 * @author Paulo Césa,  Kennedi Paulo S. Malheiros
 */
@Remote
public interface IRepositorioEncaminhamento extends Repositorio<Encaminhamento> {
    
    List<Encaminhamento> listaTodos();
    
    List<Encaminhamento> listaPorVaga(Vaga vaga);
    
    List<Encaminhamento> listaPorCliente(Cliente cliente);
    
    List<Encaminhamento> listaPorData(Date data);
    
    List<Encaminhamento> listaPorUsuario(Usuario usuario);
    
}
