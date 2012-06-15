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
public interface IRepositorioProfissao extends Repositorio<Profissao> {

    List<Profissao> listaTodos();

    List<Profissao> listaPorDescricao(String descricao);
}
