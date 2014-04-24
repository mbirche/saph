/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.interfaces.IAbstractService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.service.AbilityService;
import br.com.fatecmogidascruzes.saph.service.KnowledgeAreaService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcelo
 */
public class ServiceFactory {
    
    private Map<Class, IAbstractService> map;
    private static ServiceFactory factory;
    
    public IAbstractService getService(Class cl){
        return map.get(cl);
    }
    public static ServiceFactory getInstance(){
        if(factory == null){
            return new ServiceFactory();
        }else{
            return factory;
        }
    }
    private ServiceFactory(){
        map = new HashMap<Class, IAbstractService>();
        
        map.put(KnowledgeArea.class, KnowledgeAreaService.getInstance());
        map.put(Ability.class, AbilityService.getInstance());
//        map.put(EvaluatedItem.class, EvaluatedItemFacade.getInstance());
//        map.put(Alternative.class, AlternativeFacade.getInstance());
//        map.put(Question.class, QuestionFacade.getInstance());
//        map.put(Test.class, TestFacade.getInstance());
//        map.put(TestApplication.class, TestApplicationFacade.getInstance());
//        map.put(TestResult.class, TestResultFacade.getInstance());
//        map.put(Student.class, StudentFacade.getInstance());
//        map.put(ClassAssignment.class, ClassAssignmentFacade.getInstance());
//        map.put(StudentClass.class, StudentClassFacade.getInstance());
//        map.put(Course.class, CourseFacade.getInstance());
//        map.put(Coordinator.class, CoordinatorFacade.getInstance());
//        map.put(Teacher.class, TeacherFacade.getInstance());
    }
}
