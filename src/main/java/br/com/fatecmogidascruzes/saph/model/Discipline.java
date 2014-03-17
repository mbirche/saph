/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.OneToOne;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class Discipline extends Entity {

    @OneToOne
    private Course course;
    private String name;

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
