/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ademoc.sgascliente.web;


import br.com.ademoc.sgas.DomainModel.TipoAparelho;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author petronio
 */
@FacesConverter(value = "TipoAparelhoConverter")  
public class TipoAparelhoConverter implements Converter {  
  
  /* 
   * Um converter não fará Injeção alguma de recursos, não adianta colocar @EJB ou qualquer outra anotação. 
   * Por isso criei o acesso direto à um Managed Bean.   
   */
    
    /*
     * Um Converter é utilizado quando queremos atribuir um objeto (através de setter ou método parecido) vindo de um 
     * select (ComboBox) ou outro objeto de escolha. Em nosso caso, o setter do objeto User é chamado e o converter 
     * entra em ação, convertendo o ID que vem do select (em nosso caso o nome do usuário) pelo método “getAsObject”, que 
     * realiza uma busca pelo objeto real.
     * FONTE: http://uaihebert.com/?p=35
     */
  
  @Override 
   public Object getAsObject(FacesContext facesContext, UIComponent uicomp, String value) {  
      try {
       
        FacesContext context = FacesContext.getCurrentInstance();
        TipoDeficienciaBean aparelho = (TipoDeficienciaBean) context.getELContext().getELResolver().getValue(context.getELContext(), null, "TipoDeficienciaBean");
        for(TipoAparelho c : aparelho.getAparelhos())
            if(c. getDescricao().equals(value))
                return c;
        
        return null;
      }
      catch(Exception ex){
          return null;
      }
   }  
  
  @Override 
   public String getAsString(FacesContext facesContext, UIComponent uicomp, Object entity) {  
       return entity == null ? "" :String.valueOf(((TipoAparelho)entity).getDescricao());  
   }  
}