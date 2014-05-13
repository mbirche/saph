package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.dao.StudentClassDAO;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author marcelo
 */
@FacesConverter(forClass = StudentClass.class, value = "studentClassConverter")
public class StudentClassConverter implements Converter {

    StudentClassDAO dao = new StudentClassDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        StudentClass st = null;
        if (value != null && !value.equals("")) {
            st = (StudentClass) dao.get(Long.valueOf(value), StudentClass.class);
        }
        return st;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            StudentClass st = (StudentClass) value;
            return st.getId().toString();
        } else {
            return null;
        }
    }
}
