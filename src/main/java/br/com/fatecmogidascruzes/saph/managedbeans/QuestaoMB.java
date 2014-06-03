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
    
    private Performance performanceSatisfatory;
    private Performance performanceInsatisfatory;
    private Performance performanceEdit;
    
    
    private Alternative alternative;
    
    public QuestaoMB(){
        qFacade = (IQuestionFacade)FacadeFactory.getInstance().getFacade(Question.class);
        abFacade = (IAbilityFacade)FacadeFactory.getInstance().getFacade(Ability.class);
        
        question = new Question();
        
        alternative = new Alternative();
              
        refreshAbilitiesList();
        
        evItem = new EvaluatedItem();
        selectedEvaluatedItems = new ArrayList<EvaluatedItem>();
        
        refreshQuestionList();
        
    }

    private void moveAbility(EvaluatedItem evItem) {


        selectedEvaluatedItems.add(evItem);
        if (abilities.contains(evItem.getAbility())) {
            abilities.remove(evItem.getAbility());
        }
        alternative.setEvaluatedItems(selectedEvaluatedItems);
    }
    
    public void setSatisfatory(Ability ability){
        performanceSatisfatory = Performance.SATISFATORY;
        evItem = new EvaluatedItem(ability, performanceSatisfatory);
        
        moveAbility(evItem);
    }
    public void setInsatisfatory(Ability ability){
        performanceInsatisfatory = Performance.INSATISFATORY;
        evItem = new EvaluatedItem(ability, performanceInsatisfatory);
        
        moveAbility(evItem);
    }
    public void deleteEvItem(EvaluatedItem evItem){
        if (selectedEvaluatedItems.contains(evItem)) {
            selectedEvaluatedItems.remove(evItem);
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
        alternative = new Alternative();
        evItem = new EvaluatedItem();
        selectedEvaluatedItems = new ArrayList<EvaluatedItem>();
        refreshAbilitiesList();
    }
    public void removeAlternative(Alternative alternative){
        if(question.getAlternatives().contains(alternative)){
            question.getAlternatives().remove(alternative);
        }
    }
    public void saveQuestion(){
        qFacade.save(question);
        refreshQuestionList();
        question = new Question();
    }

    public void refreshAbilitiesList(){
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
