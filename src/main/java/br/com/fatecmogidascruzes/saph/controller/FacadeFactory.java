/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.facade.AbilityFacade;
import br.com.fatecmogidascruzes.saph.facade.KnowledgeAreaFacade;
import br.com.fatecmogidascruzes.saph.facade.QuestionFacade;
import br.com.fatecmogidascruzes.saph.facade.TestFacade;
import br.com.fatecmogidascruzes.saph.facade.TestResultFacade;
import br.com.fatecmogidascruzes.saph.facade.ClassAssignmentFacade;
import br.com.fatecmogidascruzes.saph.facade.TestApplicationFacade;
import br.com.fatecmogidascruzes.saph.facade.AlternativeFacade;
import br.com.fatecmogidascruzes.saph.facade.CourseFacade;
import br.com.fatecmogidascruzes.saph.facade.DisciplineFacade;
import br.com.fatecmogidascruzes.saph.facade.EvaluatedItemFacade;
import br.com.fatecmogidascruzes.saph.facade.StudentClassFacade;
import br.com.fatecmogidascruzes.saph.facade.UserFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IAbstractFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcelo
 */
public class FacadeFactory {

    private Map<Class, IAbstractFacade> map;
    private static FacadeFactory factory;

    public IAbstractFacade getFacade(Class cl) {
        return map.get(cl);
    }

    public static FacadeFactory getInstance() {
        if (factory == null) {
            return new FacadeFactory();
        } else {
            return factory;
        }
    }

    private FacadeFactory() {
        map = new HashMap<Class, IAbstractFacade>();

        map.put(KnowledgeArea.class, KnowledgeAreaFacade.getInstance());
        map.put(Ability.class, AbilityFacade.getInstance());
        map.put(EvaluatedItem.class, EvaluatedItemFacade.getInstance());
        map.put(Alternative.class, AlternativeFacade.getInstance());
        map.put(Question.class, QuestionFacade.getInstance());
        map.put(Test.class, TestFacade.getInstance());
        map.put(TestApplication.class, TestApplicationFacade.getInstance());
        map.put(TestResult.class, TestResultFacade.getInstance());
        map.put(ClassAssignment.class, ClassAssignmentFacade.getInstance());
        map.put(StudentClass.class, StudentClassFacade.getInstance());
        map.put(Course.class, CourseFacade.getInstance());
        map.put(User.class, UserFacade.getInstance());
        map.put(StudentClass.class, StudentClassFacade.getInstance());
        map.put(Discipline.class, DisciplineFacade.getInstance());
    }

}
