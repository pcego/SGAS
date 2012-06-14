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
public interface IRepositorioVaga extends Repositorio<Vaga> {

    List<Vaga> listaTodos();

    List<Vaga> listaPorEmpresa(Empresa empresa);

    List<Vaga> listaPorDescricao(String descricao);

    List<Vaga> listaPorDataInclusao(Date data);

    public void fechaVaga();
}
