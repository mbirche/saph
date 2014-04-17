/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.model.Student;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = Student.class)
public class StudentConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Student st = new Student();
        st.setName(value);
        return st;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Student st = (Student) value;
        
        return st.getName();
    }
    
}
