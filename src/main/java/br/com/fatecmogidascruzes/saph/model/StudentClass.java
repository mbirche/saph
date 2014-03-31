/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class StudentClass extends Entity {

    
    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="studentclass_student",
            schema="saph", 
            joinColumns=@JoinColumn(name="id_studentclass"), 
            inverseJoinColumns=@JoinColumn(name="id_student"))
    private Set<Student> students;
    
    
   @ManyToMany(fetch = FetchType.EAGER)
    private Set<ClassAssignment> classAssignments;

    public StudentClass(){
        students = new HashSet<Student>();
        classAssignments = new HashSet<ClassAssignment>();
    }
    public Boolean addStudent(Student st){
        return students.add(st);
    }
    public Boolean addClassAssignment(ClassAssignment assignment){
        return classAssignments.add(assignment);
    }
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<ClassAssignment> getClassAssignments() {
        return classAssignments;
    }

    public void setClassAssignments(Set<ClassAssignment> classAssignments) {
        this.classAssignments = classAssignments;
    }
}
