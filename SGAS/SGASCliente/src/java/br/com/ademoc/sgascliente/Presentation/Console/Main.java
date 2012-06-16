/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.Presentation.Console;

import br.com.ademoc.sgas.DomainModel.IRepositorioUsuario;
import br.com.ademoc.sgas.DomainModel.Usuario;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sun.util.calendar.CalendarDate;

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
            usuario.setNome("Paulo César");
            usuario.setLogon("root");
            usuario.setSenha("124");
            usuario.setNivel(true);
            usuario.setDtcadastro(c.getTime());
            usuario.setDataCadastro(c.getTime());
            usuario.setEmail("pcego@uol.com.br");
            usuario.setEndBairro("teste");
            usuario.setEndCep("teste");
            usuario.setEndCidade("teste");
            usuario.setEndComplemento("teste");
            usuario.setEndEstado("teste");
            usuario.setEndNumero(112);
            usuario.setEndRua("teste");
            usuario.setTelefone("3333333");
            usuario.setCelular("5555555");
            
            
            repo.salvar(usuario);
                   
            
        } catch (NamingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
