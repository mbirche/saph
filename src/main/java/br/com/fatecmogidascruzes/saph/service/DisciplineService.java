/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.CourseDAO;
import br.com.fatecmogidascruzes.saph.dao.DisciplineDAO;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Entity;

/**
 *
 * @author marcelo
 */
public class DisciplineService extends AbstractService {

    private static DisciplineService service;
    private DisciplineDAO dao;
    private CourseDAO courseDAO;

    public static DisciplineService getInstance() {
        if (service == null) {
            service = new DisciplineService();
            return service;
        } else {
            return service;
        }
    }

    public DisciplineService() {
        dao = (DisciplineDAO) DAOFactory.getInstance().getDAO(Discipline.class);
        courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(Course.class);
    }

    @Override
    public void delete(Entity entity) {
        Discipline discipline = (Discipline) entity;
        if (discipline.getCourse() != null) {
            Course course = discipline.getCourse();
            discipline.setCourse(null);
            course.getDisciplines().remove(discipline);
            courseDAO.update(course);
        }
        super.delete(discipline);
    }
}
