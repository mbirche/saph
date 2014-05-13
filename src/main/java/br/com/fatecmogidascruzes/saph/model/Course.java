/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class Course extends Entity {

    private String name;
    private String description;

    @Cascade(CascadeType.ALL)
    @OneToOne
    private User coordinator;

    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy="course")  
    private List<Discipline> disciplines;

    public Boolean addDiscipline(Discipline disc) {
        return disciplines.add(disc);
    }

    public Course() {
        disciplines = new ArrayList<Discipline>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User coordinator) {
        this.coordinator = coordinator;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
