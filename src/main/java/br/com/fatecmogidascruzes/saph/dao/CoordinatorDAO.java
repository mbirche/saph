package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinable;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinatorFacade;
import br.com.fatecmogidascruzes.saph.model.Course;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 03/04/2014
 * @author Birche
 */
public class CoordinatorDAO extends AbstractDAO implements ICoordinatorFacade{
    
    private static CoordinatorDAO dao;

    public static CoordinatorDAO getInstance() {
        if (dao == null) {
            dao = new CoordinatorDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<Course> getCoursesByCoordinator(ICoordinable coordinator) {
        
        session = HSession.getSession();
        String hql = "from Course course WHERE " + coordinator.getId() + " = course.coordinator.id";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

}
