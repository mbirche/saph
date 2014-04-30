/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.CourseDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ICourseFacade;

import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author Birche
 */
public class CourseFacade extends AbstractFacade implements ICourseFacade{
    
    private static CourseFacade facade;
    private CourseDAO dao;
    public static CourseFacade getInstance(){
        if(facade == null){
            facade = new CourseFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private CourseFacade(){
        dao = new CourseDAO();
    }

    @Override
    public List<Course> getCoursesByCoordinator(User coordinator) {
        return dao.getCoursesByCoordinator(coordinator);
    }

    @Override
    public List<Course> getCoursesByDiscipline(Discipline discipline) {
        return dao.getCoursesByDiscipline(discipline);
    }

    
}
