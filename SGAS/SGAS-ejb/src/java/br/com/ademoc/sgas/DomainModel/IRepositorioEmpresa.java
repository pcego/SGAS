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
public interface IRepositorioEmpresa extends Repositorio<Empresa>  {
    
    List<Empresa> listaTodas();
    
    List<Empresa> listaPorCnpj(String cnpj);
    
    List<Empresa> listaPorRazaoSocial(String nome);
    
    List<Empresa> listaPorRamoAtividade(String ramoAtividade);
    
}
