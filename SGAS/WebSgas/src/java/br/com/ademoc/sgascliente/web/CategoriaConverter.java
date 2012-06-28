/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;

import br.com.ademoc.sgas.DomainModel.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author www
 */
@FacesConverter (value= "CategoriaConverter")
public class CategoriaConverter implements Converter{
      @Override 
   public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
      try {
       
        FacesContext context = FacesContext.getCurrentInstance();
        TipoDeficienciaBean categoria = (TipoDeficienciaBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "TipoDeficienciaBean");
        for(Categoria c : categoria.getCategorias())
            if(c.getDescricao().equals(value))
                return c;
        
        return null;
      }
      catch(Exception ex){
          return null;
      }
   }  
  
  @Override 
   public String getAsString(FacesContext facesContext, UIComponent uicomp, Object entity) {  
       return entity == null ? "" :String.valueOf(((Categoria)entity).getDescricao());  
   }  
}
