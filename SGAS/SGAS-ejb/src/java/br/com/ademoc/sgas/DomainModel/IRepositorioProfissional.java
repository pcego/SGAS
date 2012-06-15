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
public interface IRepositorioProfissional extends Repositorio<Profissional> {
    
    List<Profissional> listaTodos();
    List<Profissional> listaPorNome(String nome);
    List<Profissional> listaPorEspecialidade(Especialidade especialidade);
    List<Profissional> listaPorSexo(String sexo);
    List<Profissional> listaPorDataNasc(Date data);
    
    
}
