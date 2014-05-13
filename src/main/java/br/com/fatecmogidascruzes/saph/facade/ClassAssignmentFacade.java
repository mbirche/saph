/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.IClassAssignmentFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;

import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.User;
import br.com.fatecmogidascruzes.saph.service.ClassAssignmentService;

import java.util.List;

/**
 *
 * @author Birche
 */
public class ClassAssignmentFacade extends AbstractFacade implements IClassAssignmentFacade{
    
    private static ClassAssignmentFacade facade;
    private ClassAssignmentService service;
    public static ClassAssignmentFacade getInstance(){
        if(facade == null){
            facade = new ClassAssignmentFacade();
            return facade;
        }else{
            return facade;
        }
    }   

    public ClassAssignmentFacade() {
        service = new ClassAssignmentService();
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByTeacher(User teacher) {
        return service.getClassAssignmentsByTeacher(teacher);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByCourse(Course course) {
        return service.getClassAssignmentsByCourse(course);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByDiscipline(Discipline discipline) {
        return service.getClassAssignmentsByDiscipline(discipline);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudentClass(StudentClass studentClass) {
        return service.getClassAssignmentsByStudentClass(studentClass);
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudent(User student) {
        return service.getClassAssignmentsByStudent(student);
    }
    
}
