/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class ClassAssignment extends Entity {

    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> teachers;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private Discipline discipline;
    
    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<StudentClass> studentClasses;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private Course course;

    
    public Boolean addStudentClass(StudentClass stClass){
        return studentClasses.add(stClass);
    }
    public Boolean addTeacher(User teacher){
        return teachers.add(teacher);
    }
    
    public ClassAssignment(){
        teachers = new HashSet<User>();
        studentClasses = new HashSet<StudentClass>();
    }
    public Set<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<User> teachers) {
        this.teachers = teachers;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Set<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(Set<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
