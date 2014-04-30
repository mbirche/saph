/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.UserDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinatorFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITeacherFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author Birche
 */
public class UserFacade extends AbstractFacade implements IStudentFacade, ICoordinatorFacade, ITeacherFacade{

    private static UserFacade facade;
    private UserDAO dao;
    public static UserFacade getInstance(){
        if(facade == null){
            facade = new UserFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private UserFacade(){
        dao = new UserDAO();
    }
    
   @Override
    public List<StudentClass> getStudentClasses(User student) {
        return dao.getStudentClasses(student);
    }

    @Override
    public List<ClassAssignment> getStudentAssignments(User student) {
        return dao.getStudentAssignments(student);
    }

    @Override
    public List<TestApplication> getStudentTestApplications(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TestResult> getStudentTestResults(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Course> getStudentCourses(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Discipline> getStudentDisciplines(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<Course> getCoursesByCoordinator(User coordinator) {
        return dao.getCoursesByCoordinator(coordinator);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentByTeacher(User teacher) {
        return dao.getClassAssignmentByTeacher(teacher);
    }

    @Override
    public List<TestApplication> getTestApplicationsByTeacher(User teacher) {
        return dao.getTestApplicationsByTeacher(teacher);
    }
    
}
