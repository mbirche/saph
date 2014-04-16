/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

/**
 *
 * @author marcelo
 */
@ManagedBean (name = "usuarioMB")
@SessionScoped
public class UsuarioMB {
    
    private DualListModel dualListModel;
    private List<Role> source;
    private List<Role> target;

    public UsuarioMB() {
        source = new ArrayList<Role>();
        source.add(Role.ADMINISTRATOR);
        source.add(Role.COORDINATOR);
        source.add(Role.TEACHER);
        source.add(Role.STUDENT);
        target = new ArrayList();
        dualListModel = new DualListModel(source, target);
    }

    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }

    public List<Role> getSource() {
        return source;
    }

    public void setSource(List<Role> source) {
        this.source = source;
    }

    public List<Role> getTarget() {
        return target;
    }

    public void setTarget(List<Role> target) {
        this.target = target;
    }
    
}
