/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.Presentation.Console;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
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
    public static void main(String[] args) {
        
        try {
            Context context = (Context) new InitialContext();
            IRepositorioUsuario ejb = (IRepositorioUsuario) context.lookup("java:global/SGAS/SGAS-ejb/DAOUsuario");
            Usuario usuario = new Usuario();
            usuario.setNome("Kennedi Paulo");
            usuario.setLogon("root");
            usuario.setSenha("123");
            usuario.setNivel(true);
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
