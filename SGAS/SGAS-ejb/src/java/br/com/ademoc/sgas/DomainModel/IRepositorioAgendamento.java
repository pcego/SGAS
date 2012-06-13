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
 * @author pcego
 */
@Remote
public interface IRepositorioAgendamento extends Repositorio<Agendamento> {

    List<Agendamento> listaTodosAgendamentos();
    
    List<Agendamento> listaPorData(Date data);
    
    List<Agendamento> listaAgendamentoPorProfissional(Profissional profissional);
    
    List<Agendamento> listaAgendamentoPorCliente (Cliente cliente);
    
    List<Agendamento> listaPorUsuario (Usuario usuario);
    
    public void atualizaStatus();
    
    
}
