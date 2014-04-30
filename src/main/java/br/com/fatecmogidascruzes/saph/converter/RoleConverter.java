/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.model.Role;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Role.class, value = "roleConverter")
public class RoleConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        Role role = Role.getRole(Integer.valueOf(value));
        
        return role;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Role role = (Role) value;
        
        return role.getCode().toString();
    }
    
}
