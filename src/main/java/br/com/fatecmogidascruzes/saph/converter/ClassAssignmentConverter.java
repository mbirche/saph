/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.ClassAssignmentDAO;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = ClassAssignment.class)
public class ClassAssignmentConverter implements Converter{

    ClassAssignmentDAO dao = (ClassAssignmentDAO) DAOFactory.getInstance().getDAO(ClassAssignment.class);
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ClassAssignment cl = null;
         if (value != null && !value.equals("")) {
             cl = (ClassAssignment) dao.get(Long.valueOf(value), ClassAssignment.class);
         }
        return cl;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            ClassAssignment cl = (ClassAssignment) value;
            return cl.getId().toString();
        } else {
            return null;
        }
    }
    
}
