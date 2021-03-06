/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.AbilityDAO;
import br.com.fatecmogidascruzes.saph.dao.AlternativeDAO;
import br.com.fatecmogidascruzes.saph.dao.ClassAssignmentDAO;
import br.com.fatecmogidascruzes.saph.dao.CourseDAO;
import br.com.fatecmogidascruzes.saph.dao.DisciplineDAO;
import br.com.fatecmogidascruzes.saph.dao.EntityDAO;
import br.com.fatecmogidascruzes.saph.dao.EvaluatedItemDAO;
import br.com.fatecmogidascruzes.saph.dao.KnowledgeAreaDAO;
import br.com.fatecmogidascruzes.saph.dao.QuestionDAO;
import br.com.fatecmogidascruzes.saph.dao.StudentClassDAO;
import br.com.fatecmogidascruzes.saph.dao.TestApplicationDAO;
import br.com.fatecmogidascruzes.saph.dao.TestDAO;
import br.com.fatecmogidascruzes.saph.dao.TestResultDAO;
import br.com.fatecmogidascruzes.saph.dao.UserDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IDAO;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;

import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Entity;
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
public class DAOFactory {
    
    private Map<Class, IDAO> map;
    private static DAOFactory factory;

    public IDAO getDAO(Class cl){
        return map.get(cl);
    }
    public static DAOFactory getInstance(){
        if(factory == null){
            return new DAOFactory();
        }else{
            return factory;
        }
    }
    private DAOFactory(){
        map = new HashMap<Class, IDAO>();
        
        map.put(KnowledgeArea.class, KnowledgeAreaDAO.getInstance());
        map.put(Ability.class, AbilityDAO.getInstance());
        map.put(EvaluatedItem.class, EvaluatedItemDAO.getInstance());
        map.put(Alternative.class, AlternativeDAO.getInstance());
        map.put(Question.class, QuestionDAO.getInstance());
        map.put(Test.class, TestDAO.getInstance());
        map.put(TestApplication.class, TestApplicationDAO.getInstance());
        map.put(TestResult.class, TestResultDAO.getInstance());
        map.put(ClassAssignment.class, ClassAssignmentDAO.getInstance());
        map.put(StudentClass.class, StudentClassDAO.getInstance());
        map.put(Course.class, CourseDAO.getInstance());
        map.put(User.class, UserDAO.getInstance());
        map.put(Discipline.class, DisciplineDAO.getInstance());
        map.put(Entity.class, EntityDAO.getInstance());
    }
}
