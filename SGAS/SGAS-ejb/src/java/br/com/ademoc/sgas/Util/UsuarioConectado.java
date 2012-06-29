/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgas.Util;

import br.com.ademoc.sgas.DomainModel.Usuario;

/**
 *
 * @author www
 */
public class UsuarioConectado {

    private int cod;
    private String nomeUsuario;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    public static Usuario usuarioConectado;

    public static Usuario getUsuarioConectado() {
        if (usuarioConectado == null) {
            usuarioConectado = new Usuario();
        }
        return usuarioConectado;
    }

    public static void setUsuarioConectado(Usuario usuarioConectado) {
        UsuarioConectado.usuarioConectado = usuarioConectado;
    }
    
    
}
