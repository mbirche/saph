/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.EntityDAO;
import br.com.fatecmogidascruzes.saph.model.Entity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Entity.class, value = "entityConverter")
public class EntityConverter implements Converter{

    EntityDAO dao = (EntityDAO) DAOFactory.getInstance().getDAO(Entity.class);
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Entity entity = null;
        if (value != null && !value.equals("")) {
            entity = (Entity) dao.get(Long.valueOf(value), Entity.class);
        }
        return entity;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Entity entity = (Entity) value;
            return entity.getId().toString();
        } else {
            return null;
        }
    }
    
}
