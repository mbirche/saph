package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public interface IStudentFacade extends IAbstractFacade{

    public List<StudentClass> getStudentClasses(Student student);
    
    public List<ClassAssignment> getStudentAssignments(Student student);
    
    public List<TestApplication> getStudentTestApplications(Student student);
    
    public List<TestResult> getStudentTestResults(Student student);
    
    public List<Course> getStudentCourses(Student student);
    
    public List<Discipline> getStudentDisciplines(Student student);
}
