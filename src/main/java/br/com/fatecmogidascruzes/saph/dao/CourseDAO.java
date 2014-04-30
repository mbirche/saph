package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.ICourseFacade;

import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 02/04/2014
 * @author Birche
 */
public class CourseDAO extends AbstractDAO implements ICourseFacade{
    
    private static CourseDAO dao;

    public static CourseDAO getInstance() {
        if (dao == null) {
            dao = new CourseDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<Course> getCoursesByCoordinator(User coordinator) {
        
        session = HSession.getSession();
        String hql = "from Course course WHERE " + coordinator.getId() + " = course.coordinator.id";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<Course> getCoursesByDiscipline(Discipline discipline) {
        session = HSession.getSession();
        String hql = "from Course course WHERE " + discipline.getId() + " IN (SELECT disc.id FROM course.disciplines as disc)";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }

}
