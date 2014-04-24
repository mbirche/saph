/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.service.KnowledgeAreaService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = KnowledgeArea.class, value = "knowledgeAreaConverter")
public class KnowledgeAreaConverter implements Converter{

    KnowledgeAreaService service = new KnowledgeAreaService();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return service.get(Long.valueOf(value), KnowledgeArea.class);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        KnowledgeArea ka = (KnowledgeArea) value;
        
        return ka.getName();
    }
    
}
