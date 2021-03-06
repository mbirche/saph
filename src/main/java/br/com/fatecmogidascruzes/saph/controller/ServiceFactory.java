/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.interfaces.IAbstractService;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Question;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Test;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import br.com.fatecmogidascruzes.saph.service.AbilityService;
import br.com.fatecmogidascruzes.saph.service.ClassAssignmentService;
import br.com.fatecmogidascruzes.saph.service.CourseService;
import br.com.fatecmogidascruzes.saph.service.DisciplineService;
import br.com.fatecmogidascruzes.saph.service.EvaluatedItemService;
import br.com.fatecmogidascruzes.saph.service.KnowledgeAreaService;
import br.com.fatecmogidascruzes.saph.service.QuestionService;
import br.com.fatecmogidascruzes.saph.service.StudentClassService;
import br.com.fatecmogidascruzes.saph.service.TestApplicationService;
import br.com.fatecmogidascruzes.saph.service.TestResultService;
import br.com.fatecmogidascruzes.saph.service.TestService;
import br.com.fatecmogidascruzes.saph.service.UserService;
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
        map.put(EvaluatedItem.class, EvaluatedItemService.getInstance());
//        map.put(Alternative.class, AlternativeFacade.getInstance());
        map.put(Question.class, QuestionService.getInstance());
        map.put(Test.class, TestService.getInstance());
        map.put(TestApplication.class, TestApplicationService.getInstance());
        map.put(TestResult.class, TestResultService.getInstance());
        map.put(ClassAssignment.class, ClassAssignmentService.getInstance());
//        map.put(StudentClass.class, StudentClassFacade.getInstance());
        map.put(Course.class, CourseService.getInstance());
        map.put(User.class, UserService.getInstance());
        map.put(StudentClass.class, StudentClassService.getInstance());
        map.put(Discipline.class, DisciplineService.getInstance());
    }
}
