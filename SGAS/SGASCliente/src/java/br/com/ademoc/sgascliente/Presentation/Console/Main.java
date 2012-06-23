/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.Presentation.Console;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pcego
 */


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        try {
            
            Calendar c = Calendar.getInstance();
            
            Context context = (Context) new InitialContext();            
            IRepositorioUsuario repo = (IRepositorioUsuario) context.lookup("java:global/SGAS/SGAS-ejb/DAOUsuario");
            
            Usuario usuario = new Usuario();
            usuario.setNome("Kennedi");
            usuario.setLogon("root");
            usuario.setSenha("124");
            usuario.setNivel(true);
            usuario.setDtcadastro(c.getTime());
            usuario.setDataCadastro(c.getTime());
            usuario.setEmail("pcego@uol.com.br");
            usuario.setEndBairro("Todos os Santos");
            usuario.setEndCep("39400-000");
            usuario.setEndCidade("Montes Claros");
            usuario.setEndComplemento("Casa");
            usuario.setEndEstado("Minas Gerais");
            usuario.setEndNumero(112);
            usuario.setEndRua("Santa Lúcia");
            usuario.setTelefone("3213-6281");
            usuario.setCelular("8822-1797");
            
            
            repo.salvar(usuario);
            
     //       List<Usuario> list = repo.listaTodos();
            
    //        Iterator<Usuario> i = list.listIterator();
    //        while(i.hasNext()){
                                            
    //            System.out.println(i.next().getNome());
 //           }
            
            
                   
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
