/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.ClassAssignmentDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IClassAssignmentService;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class ClassAssignmentService extends AbstractService implements IClassAssignmentService{

    private static ClassAssignmentService service;
    private ClassAssignmentDAO dao;
    public static ClassAssignmentService getInstance(){
        if(service == null){
            service = new ClassAssignmentService();
            return service;
        }else{
            return service;
        }
    }   
    public ClassAssignmentService(){
        dao = (ClassAssignmentDAO) DAOFactory.getInstance().getDAO(ClassAssignment.class);
    }
    @Override
    public List<ClassAssignment> getClassAssignmentsByTeacher(User teacher) {
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
    public List<ClassAssignment> getClassAssignmentsByStudent(User student) {
        return dao.getClassAssignmentsByStudent(student);
    }
    
}
