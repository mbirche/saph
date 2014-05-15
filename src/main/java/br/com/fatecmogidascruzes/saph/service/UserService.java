/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.dao.UserDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IUserService;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Credential;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class UserService extends AbstractService implements IUserService{

    private static UserService service;
    private UserDAO dao;
    public static UserService getInstance(){
        if(service == null){
            service = new UserService();
            return service;
        }else{
            return service;
        }
    }   
    public UserService(){
        dao = new UserDAO();
    }
    @Override
    public List<Course> getCoursesByCoordinator(User coordinator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentClass> getStudentClasses(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClassAssignment> getStudentAssignments(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TestApplication> getStudentTestApplications(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TestResult> getStudentTestResults(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> getStudentCourses(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Discipline> getStudentDisciplines(User student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClassAssignment> getClassAssignmentByTeacher(User teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TestApplication> getTestApplicationsByTeacher(User teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserByCredentials(Credential credential) {
        return dao.getUserByCredentials(credential);
    }
    
}
