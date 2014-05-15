/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.AbilityDAO;
import br.com.fatecmogidascruzes.saph.model.Ability;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Ability.class)
public class AbilityConverter implements Converter {

    AbilityDAO dao = (AbilityDAO) DAOFactory.getInstance().getDAO(Ability.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Ability ability = null;
        if (value != null && !value.equals("")) {
            ability = (Ability) dao.get(Long.valueOf(value), Ability.class);
        }
        return ability;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Ability ab = (Ability) value;
            return ab.getId().toString();
        } else {
            return null;
        }

    }

}
