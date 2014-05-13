/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
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

    private String name;
    
    @Cascade(CascadeType.ALL)
    @ManyToMany
    private List<User> teachers;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private Discipline discipline;
    
    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<StudentClass> studentClasses;
    
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
        teachers = new ArrayList<User>();
        studentClasses = new ArrayList<StudentClass>();
    }
    public List<User> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<User> teachers) {
        this.teachers = teachers;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public List<StudentClass> getStudentClasses() {
        return studentClasses;
    }

    public void setStudentClasses(List<StudentClass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
