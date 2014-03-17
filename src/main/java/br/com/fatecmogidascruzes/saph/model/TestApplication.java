/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class TestApplication extends Entity {

    @Cascade(CascadeType.ALL)
    @OneToOne
    private ClassAssignment classAssignment;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private Test test;

    public ClassAssignment getClassAssignment() {
        return classAssignment;
    }

    public void setClassAssignment(ClassAssignment classAssignment) {
        this.classAssignment = classAssignment;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
