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
public interface IRepositorioUsuario extends Repositorio<Usuario> {
    
    List<Usuario> listaPorNome(String nome);
    
    List<Usuario> listaPorCpf(String cpf);
    
    List<Usuario> listaTodos();
    
<<<<<<< HEAD
    Usuario validarUsuario(String logon, String senha) throws Exception;
=======
    Usuario validarUsuario (String usuario, String senha); 
>>>>>>> ea37e6d6d360198829fce21a202311e2f02cdf6e
    
}
