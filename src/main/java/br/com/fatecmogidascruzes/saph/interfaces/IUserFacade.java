/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.interfaces;

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
public interface IUserFacade extends IAbstractFacade {

    public List<Course> getCoursesByCoordinator(User coordinator);

    public List<StudentClass> getStudentClasses(User student);

    public List<ClassAssignment> getStudentAssignments(User student);

    public List<TestApplication> getStudentTestApplications(User student);

    public List<TestResult> getStudentTestResults(User student);

    public List<Course> getStudentCourses(User student);

    public List<Discipline> getStudentDisciplines(User student);

    public List<ClassAssignment> getClassAssignmentByTeacher(User teacher);

    public List<TestApplication> getTestApplicationsByTeacher(User teacher);
    
    public User getUserByCredentials(Credential credential);
}
