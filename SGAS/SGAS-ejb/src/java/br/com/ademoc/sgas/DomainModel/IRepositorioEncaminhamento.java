/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.DomainModel;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Kennedi Paulo S. Malheiros
 */
public interface IRepositorioEncaminhamento extends Repositorio<Encaminhamento> {
    
    List<Encaminhamento> listaTodos();
    
    List<Encaminhamento> listaPorVaga(Vaga vaga);
    
    List<Encaminhamento> listaPorCliente(Cliente cliente);
    
    List<Encaminhamento> listaPorData(Date data);
    
    List<Encaminhamento> listaPorUsuario(Usuario usuario);
    
}
