/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.UserDAO;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = User.class, value = "userConverter")
public class UserConverter implements Converter {

    UserDAO dao = (UserDAO) DAOFactory.getInstance().getDAO(User.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        User st = null;
        if (value != null && !value.equals("")) {
            st = (User) dao.get(Long.valueOf(value), User.class);
        }
        return st;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            User st = (User) value;
            return st.getId().toString();
        } else {
            return null;
        }
    }

}
