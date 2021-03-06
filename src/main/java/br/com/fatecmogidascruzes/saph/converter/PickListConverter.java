package br.com.fatecmogidascruzes.saph.converter;

import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 24/04/2014
 * @author Birche
 */
@FacesConverter(value = "pickListConverter")
public class PickListConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Object retorno = null;
        if (value != null && !value.equals("")) {
            if (component instanceof PickList) {
                Object dualList = ((PickList) component).getValue();
                DualListModel dl = (DualListModel) dualList;

                for (Iterator iterator = dl.getSource().iterator(); iterator.hasNext();) {
                    Object o = iterator.next();

                    String id = ((Entity) o).getId().toString();

                    if (value.equals(id)) {
                        retorno = o;
                        break;
                    }
                }

                if (retorno == null) {
                    for (Iterator iterator1 = dl.getTarget().iterator(); iterator1.hasNext();) {
                        Object o = iterator1.next();

                        String id = ((Entity) o).getId().toString();

                        if (value.equals(id)) {
                            retorno = o;
                            break;
                        }
                    }
                }
            }
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String str = "";

        if (value instanceof Entity) {
            str = ((Entity) value).getId().toString();
        }

        return str;
    }
}
