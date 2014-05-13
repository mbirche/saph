/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.KnowledgeAreaDAO;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = KnowledgeArea.class)
public class KnowledgeAreaConverter implements Converter{

    KnowledgeAreaDAO dao = (KnowledgeAreaDAO) DAOFactory.getInstance().getDAO(KnowledgeArea.class);
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        KnowledgeArea ka = null;
        if (value != null && !value.equals("")) {
            ka = (KnowledgeArea) dao.get(Long.valueOf(value), KnowledgeArea.class);
        }
        return ka;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
         if (value != null) {
            KnowledgeArea ka = (KnowledgeArea) value;
            return ka.getId().toString();
        } else {
            return null;
        }
    }
    
}
