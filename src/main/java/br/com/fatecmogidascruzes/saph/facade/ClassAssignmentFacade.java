/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.ClassAssignmentDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IClassAssignmentFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import java.util.List;

/**
 *
 * @author Birche
 */
public class ClassAssignmentFacade extends AbstractFacade implements IClassAssignmentFacade{
    
    private static ClassAssignmentFacade facade;
    private ClassAssignmentDAO dao;
    public static ClassAssignmentFacade getInstance(){
        if(facade == null){
            facade = new ClassAssignmentFacade();
            return facade;
        }else{
            return facade;
        }
    }   

    public ClassAssignmentFacade() {
        dao = new ClassAssignmentDAO();
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByTeacher(Teacher teacher) {
        return dao.getClassAssignmentsByTeacher(teacher);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByCourse(Course course) {
        return dao.getClassAssignmentsByCourse(course);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByDiscipline(Discipline discipline) {
        return dao.getClassAssignmentsByDiscipline(discipline);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudentClass(StudentClass studentClass) {
        return dao.getClassAssignmentsByStudentClass(studentClass);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudent(Student student) {
        return dao.getClassAssignmentsByStudent(student);
    }
    
}
