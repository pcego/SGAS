/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Paulo CÃ©sar
 */
public class Criptografia {
    
    /**
     * Criptografa senha em MD5.
     * @param senha recebe a senha original.
     * @return String com senha criptografada.
     */
    public static final String criptografa(String senha) {
        
        // Aumenta a complexidade da senha digitada pelo usuário        
        senha = "5tR1n6_d171C1l" + senha;

        // Converte a senha em um vetor de bytes        
        byte[] defBytes = senha.getBytes();
        byte msgDigest[];
        StringBuilder buf = null;

        try {
            MessageDigest algoritmo = MessageDigest.getInstance("MD5");
            algoritmo.reset();
            algoritmo.update(defBytes);
            msgDigest = algoritmo.digest();

            buf = new StringBuilder();
            for (int i = 0; i < msgDigest.length; i++) {
                buf.append(Integer.toHexString(0xFF & msgDigest[i]));
            }

        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }

        return buf.toString();
    }
    
}
