package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 * @date 16/04/2014
 * @author Birche
 */
@ManagedBean(name="turmaMB")
@SessionScoped
public class TurmaMB {

    private DualListModel<User> dualListModel;
    private List<User> source;
    private List<User> target;

    public TurmaMB() {
        User s1 = new User();
        s1.setName("Marcelo");
        User s2 = new User();
        s2.setName("Tabata");
        
        source = new ArrayList<User>();
        source.add(s1);
        target = new ArrayList<User>();
        target.add(s2);
        
        dualListModel = new DualListModel<User>(source, target);
    }

    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<User> getSource() {
        return source;
    }

    public void setSource(List<User> source) {
        this.source = source;
    }

    public List<User> getTarget() {
        return target;
    }

    public void setTarget(List<User> target) {
        this.target = target;
    }
    
}
