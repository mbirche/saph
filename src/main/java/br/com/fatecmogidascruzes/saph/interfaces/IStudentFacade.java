package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public interface IStudentFacade extends IAbstractFacade{

    public List<StudentClass> getStudentClasses(User student);
    
    public List<ClassAssignment> getStudentAssignments(User student);
    
    public List<TestApplication> getStudentTestApplications(User student);
    
    public List<TestResult> getStudentTestResults(User student);
    
    public List<Course> getStudentCourses(User student);
    
    public List<Discipline> getStudentDisciplines(User student);
}
