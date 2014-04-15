package br.com.fatecmogidascruzes.saph.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 * @date 14/04/2014
 * @author Birche
 */
@ManagedBean(name="habilidadeAreaMB")
@SessionScoped
public class HabilidadeAreaMB {

    private DualListModel dualListModel;
    private List<String> source;
    private List<String> target;

    public HabilidadeAreaMB() {
        source = new ArrayList();
        source.add("Origem");
        target = new ArrayList();
        target.add("Destino");
        dualListModel = new DualListModel(source, target);
    }

    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }    
}
