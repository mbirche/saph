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

    @Cascade(CascadeType.ALL)
    @OneToOne
    private User coordinator;

    @Cascade(CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_discipline",
            schema = "saph",
            joinColumns = @JoinColumn(name = "id_course"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline"))
    private Set<Discipline> disciplines;

    public Boolean addDiscipline(Discipline disc) {
        return disciplines.add(disc);
    }

    public Course() {
        disciplines = new HashSet<Discipline>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(User coordinator) {
        this.coordinator = coordinator;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
