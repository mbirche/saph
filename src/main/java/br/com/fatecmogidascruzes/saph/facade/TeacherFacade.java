/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.TeacherDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITeacherFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import java.util.List;

/**
 *
 * @author Birche
 */
public class TeacherFacade extends AbstractFacade implements ITeacherFacade{
    
    private static TeacherFacade facade;
    private TeacherDAO dao;
    public static TeacherFacade getInstance(){
        if(facade == null){
            facade = new TeacherFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TeacherFacade(){
        dao = new TeacherDAO();
    }

    @Override
    public List<ClassAssignment> getClassAssignmentByTeacher(Teacher teacher) {
        return dao.getClassAssignmentByTeacher(teacher);
    }

    @Override
    public List<TestApplication> getTestApplicationsByTeacher(Teacher teacher) {
        return dao.getTestApplicationsByTeacher(teacher);
    }
}
