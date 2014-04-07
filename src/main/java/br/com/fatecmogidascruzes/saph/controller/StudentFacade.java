/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.StudentDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.List;

/**
 *
 * @author Birche
 */
public class StudentFacade extends AbstractFacade implements IStudentFacade{
    
    private static StudentFacade facade;
    private StudentDAO dao;
    public static StudentFacade getInstance(){
        if(facade == null){
            facade = new StudentFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private StudentFacade(){
        dao = new StudentDAO();
    }

    @Override
    public List<StudentClass> getStudentClasses(Student student) {
        return dao.getStudentClasses(student);
    }

    @Override
    public List<ClassAssignment> getStudentAssignments(Student student) {
        return dao.getStudentAssignments(student);
    }

    @Override
    public List<TestApplication> getStudentTestApplications(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TestResult> getStudentTestResults(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Course> getStudentCourses(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Discipline> getStudentDisciplines(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
