/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import br.com.fatecmogidascruzes.saph.interfaces.ICoordinable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends User implements ICoordinable{

    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    Set<ClassAssignment> classAssignments;

    public Boolean addClassAssignment(ClassAssignment clAs){
        return classAssignments.add(clAs);
    }
    public Teacher(){
        classAssignments = new HashSet<ClassAssignment>();
    }
    public Set<ClassAssignment> getClassAssignments() {
        return classAssignments;
    }

    public void setClassAssignments(Set<ClassAssignment> classAssignments) {
        this.classAssignments = classAssignments;
    }
}
