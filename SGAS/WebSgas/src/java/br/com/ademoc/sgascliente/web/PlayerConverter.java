/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;


import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import br.com.ademoc.sgas.DomainModel.TipoAparelho;
import br.com.ademoc.sgas.DomainModel.IRepositorioTipoAparelho;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

//import org.primefaces.examples.domain.Player;

public class PlayerConverter implements Converter {

    public static List<TipoAparelho> playerDB;
    IRepositorioTipoAparelho repo;
   
 //       playerDB = repo.listaTodos();
     
    

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (TipoAparelho p : playerDB) {
                    if (p.getId() == number) {
                        return p;
                    }
                }

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((TipoAparelho) value).getId());
        }
    }
}
                    