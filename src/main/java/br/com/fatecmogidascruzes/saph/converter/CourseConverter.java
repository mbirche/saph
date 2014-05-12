/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.CourseDAO;
import br.com.fatecmogidascruzes.saph.model.Course;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Course.class)
public class CourseConverter implements Converter {

    CourseDAO dao = (CourseDAO) DAOFactory.getInstance().getDAO(Course.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Course course = null;
        if (value != null && !value.equals("")) {
            course = (Course) dao.get(Long.valueOf(value), Course.class);
        }
        return course;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Course course = (Course) value;
            return course.getId().toString();
        } else {
            return null;
        }
    }

}
