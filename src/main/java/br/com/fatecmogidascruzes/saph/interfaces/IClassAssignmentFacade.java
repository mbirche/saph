package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 27/03/2014
 * @author Birche
 */
public interface IClassAssignmentFacade extends IAbstractFacade{

    public List<ClassAssignment> getClassAssignmentsByTeacher(Teacher teacher);
    
    public List<ClassAssignment> getClassAssignmentsByCourse(Course course);
    
    public List<ClassAssignment> getClassAssignmentsByDiscipline(Discipline discipline);
    
    public List<ClassAssignment> getClassAssignmentsByStudentClass(StudentClass studentClass);
    
    public List<ClassAssignment> getClassAssignmentsByStudent(Student student);
}
