/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IAbilityFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IQuestionFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.Performance;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "questaoMB")
@SessionScoped
public class QuestaoMB {
    
    private IQuestionFacade qFacade;
    private IAbilityFacade abFacade;
    

    
    private Question question;
    private List<Question> questions;
    
    private Ability ability;
    private List<Ability> abilities;

    private List<EvaluatedItem> selectedEvaluatedItems;
    private EvaluatedItem evItem;
    private EvaluatedItem deletingEvItem;
    
    private Performance performance;
    private Performance performanceEdit;
    
    
    private Alternative alternative;
    
    public QuestaoMB(){
        qFacade = (IQuestionFacade)FacadeFactory.getInstance().getFacade(Question.class);
        abFacade = (IAbilityFacade)FacadeFactory.getInstance().getFacade(Ability.class);
        
        question = new Question();
        
        alternative = new Alternative();
        
        ability = new Ability();
        
        refreshAbilitiesList();
        
        evItem = new EvaluatedItem();
        selectedEvaluatedItems = new ArrayList<EvaluatedItem>();
        
        refreshQuestionList();
        
    }

    public void moveAbility() {

        evItem = new EvaluatedItem(ability, performance);
        ability = new Ability();
        
        selectedEvaluatedItems.add(evItem);
        if (abilities.contains(ability)) {
            abilities.remove(ability);
        }
        alternative.setEvaluatedItems(selectedEvaluatedItems);
    }
    public void editSatisfatory() {
        performanceEdit = Performance.SATISFATORY;
        selectedEvaluatedItems.get(selectedEvaluatedItems.indexOf(evItem)).setPerformance(performanceEdit);
    }

    public void editInsatisfatory() {
        performanceEdit = Performance.INSATISFATORY;
        selectedEvaluatedItems.get(selectedEvaluatedItems.indexOf(evItem)).setPerformance(performanceEdit);
    }
    public void setSatisfatory(){
        performance = Performance.SATISFATORY;
    }
    public void setInsatisfatory(){
        performance = Performance.INSATISFATORY;
    }
    public void deleteEvItem(){
        if (selectedEvaluatedItems.contains(deletingEvItem)) {
            selectedEvaluatedItems.remove(deletingEvItem);
        }
        refreshAbilitiesList();

        for (EvaluatedItem item : selectedEvaluatedItems) {
            if (abilities.contains(item.getAbility())) {
                abilities.remove(item.getAbility());
            }
        }
        alternative.setEvaluatedItems(selectedEvaluatedItems);
    }
    public void addAlternative(){
        question.addAlternative(alternative);
    }
    public void saveQuestion(){
        qFacade.save(question);
        refreshQuestionList();
        question = new Question();
    }

    private void refreshAbilitiesList(){
        abilities = (List<Ability>)(List) abFacade.getAll(Ability.class);
    }
    private void refreshQuestionList(){
        questions = (List<Question>)(List) qFacade.getAll(Question.class);
    }
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public EvaluatedItem getEvItem() {
        return evItem;
    }

    public void setEvItem(EvaluatedItem evItem) {
        this.evItem = evItem;
    }

    public List<EvaluatedItem> getSelectedEvaluatedItems() {
        return selectedEvaluatedItems;
    }

    public void setSelectedEvaluatedItems(List<EvaluatedItem> selectedEvaluatedItems) {
        this.selectedEvaluatedItems = selectedEvaluatedItems;
    }

    public EvaluatedItem getDeletingEvItem() {
        return deletingEvItem;
    }

    public void setDeletingEvItem(EvaluatedItem deletingEvItem) {
        this.deletingEvItem = deletingEvItem;
    }
    
}
