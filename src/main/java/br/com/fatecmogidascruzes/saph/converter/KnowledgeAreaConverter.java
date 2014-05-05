/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.KnowledgeAreaDAO;
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
        return dao.get(Long.valueOf(value), KnowledgeArea.class);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        KnowledgeArea ka = (KnowledgeArea) value;
        
        return ka.getId().toString();
    }
    
}
