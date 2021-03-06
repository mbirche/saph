/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
public class TestResult extends Entity {

    private Boolean answered;
    @Cascade(CascadeType.ALL)
    @ManyToMany
    private List<Answer> answers;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private TestApplication testApplication;
    
    @Cascade(CascadeType.ALL)
    @OneToOne
    private User student;

    public Boolean addAnswer(Answer ans){
        return answers.add(ans);
    }
    public TestResult(){
        answers = new ArrayList<Answer>();
    }
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public TestApplication getTestApplication() {
        return testApplication;
    }

    public void setTestApplication(TestApplication testApplication) {
        this.testApplication = testApplication;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Boolean isAnswered() {
        return answered;
    }

    public void setAnswered(Boolean answered) {
        this.answered = answered;
    }
}
