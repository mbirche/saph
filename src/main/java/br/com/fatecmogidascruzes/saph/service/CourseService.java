/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.CourseDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ICourseDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ICourseFacade;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Entity;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class CourseService extends AbstractService implements ICourseFacade, ICourseDAO{

    private static CourseService service;
    private CourseDAO dao;
    public static CourseService getInstance(){
        if(service == null){
            service = new CourseService();
            return service;
        }else{
            return service;
        }
    }   
    public CourseService(){
        dao = (CourseDAO)DAOFactory.getInstance().getDAO(Course.class);
    }
    
    @Override
    public List<Course> getCoursesByCoordinator(User coordinator) {
        return dao.getCoursesByCoordinator(coordinator);
    }

    @Override
    public List<Course> getCoursesByDiscipline(Discipline discipline) {
        return dao.getCoursesByDiscipline(discipline);
    }
    @Override
    public void delete(Entity entity){
        Course course = (Course) entity;
        course.setCoordinator(null);
        course.getDisciplines().clear();
        super.delete(entity);
    }
}
