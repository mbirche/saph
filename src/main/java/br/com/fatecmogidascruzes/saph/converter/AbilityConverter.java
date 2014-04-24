/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.service.AbilityService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Ability.class)
public class AbilityConverter implements Converter{

    AbilityService service = new AbilityService();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return service.get(Long.valueOf(value), Ability.class);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Ability ab = (Ability) value;
        
        return ab.getName();
    }
    
}
