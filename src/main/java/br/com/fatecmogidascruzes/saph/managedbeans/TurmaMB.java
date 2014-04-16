package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.model.Student;
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

    private DualListModel dualListModel;
    private List<Student> source;
    private List<Student> target;

    public TurmaMB() {
        Student s1 = new Student();
        s1.setName("Marcelo");
        Student s2 = new Student();
        s2.setName("Tabata");
        
        source = new ArrayList<Student>();
        source.add(s1);
        target = new ArrayList<Student>();
        target.add(s2);
        
        dualListModel = new DualListModel(source, target);
    }

    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<Student> getSource() {
        return source;
    }

    public void setSource(List<Student> source) {
        this.source = source;
    }

    public List<Student> getTarget() {
        return target;
    }

    public void setTarget(List<Student> target) {
        this.target = target;
    }
    
}
