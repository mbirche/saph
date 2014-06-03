/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.Answer;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.Performance;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author marcelo
 */
@ManagedBean(name = "analisarAvaliacaoMB")
@SessionScoped
public class AnalisarAvaliacaoMB {
    
    private ITestApplicationFacade testAppFacade;
    private ITestResultFacade testResultfacade;
    
    private List<TestApplication> allTestApplications;
    private TestApplication selectedTestApp;
    
    private List<TestResult> testResults;
    private TestResult selectedTestResult;
    
    public AnalisarAvaliacaoMB() {
        
        testAppFacade = (ITestApplicationFacade) FacadeFactory.getInstance().getFacade(TestApplication.class);
        testResultfacade = (ITestResultFacade) FacadeFactory.getInstance().getFacade(TestResult.class);
        
        fillTestApplicationList();
    }
    
    public void analisarProva(TestResult testResult) {
        
        Set<Ability> abilities = new HashSet<Ability>();
        
        for (Answer ans : testResult.getAnswers()) {
            for (EvaluatedItem ev : ans.getAlternative().getEvaluatedItems()) {
                abilities.add(ev.getAbility());
            }
        }
        Map<Ability, Integer> mapaNumeroQuestoesPorHabilidade = new HashMap<Ability, Integer>();
        Map<Ability, Integer> mapaAcertosPorHabilidade = new HashMap<Ability, Integer>();
        
        for (Ability ab : abilities) {
            mapaNumeroQuestoesPorHabilidade.put(ab, 0);
            mapaAcertosPorHabilidade.put(ab, 0);
        }
        
        for (Answer ans : testResult.getAnswers()) {
            for (Ability ab : abilities) {
                if (ans.getQuestion().getAlternatives().get(0).hasAbility(ab)) {
                    mapaNumeroQuestoesPorHabilidade.put(ab, mapaNumeroQuestoesPorHabilidade.get(ab) + 1);
                }
            }
            
            Alternative alt = ans.getAlternative();
            
                for (EvaluatedItem ev : alt.getEvaluatedItems()) {
                    Ability ability = ev.getAbility();
                    if (ev.getPerformance().equals(Performance.SATISFATORY)) {
                        mapaAcertosPorHabilidade.put(ability, mapaAcertosPorHabilidade.get(ability) + 1);
                    }
                }
            
        }
        System.out.println("pare");
    }

    public void fillTestResultsByTestApplication() {
        testResults = (List<TestResult>) (List) testResultfacade.getTestResultsByTestApplication(selectedTestApp);
    }

    public void fillTestApplicationList() {
        allTestApplications = (List<TestApplication>) (List) testAppFacade.getAll(TestApplication.class);
    }
    
    public List<TestApplication> getAllTestApplications() {
        return allTestApplications;
    }
    
    public void setAllTestApplications(List<TestApplication> allTestApplications) {
        this.allTestApplications = allTestApplications;
    }
    
    public TestApplication getSelectedTestApp() {
        return selectedTestApp;
    }
    
    public void setSelectedTestApp(TestApplication selectedTestApp) {
        this.selectedTestApp = selectedTestApp;
    }
    
    public List<TestResult> getTestResults() {
        return testResults;
    }
    
    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }
    
    public TestResult getSelectedTestResult() {
        return selectedTestResult;
    }
    
    public void setSelectedTestResult(TestResult selectedTestResult) {
        this.selectedTestResult = selectedTestResult;
    }
    
}
