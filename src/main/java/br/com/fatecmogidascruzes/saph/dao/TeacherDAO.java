package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.ITeacherFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 03/04/2014
 * @author Birche
 */
public class TeacherDAO extends AbstractDAO implements ITeacherFacade{
    
    private static TeacherDAO dao;

    public static TeacherDAO getInstance() {
        if (dao == null) {
            dao = new TeacherDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<ClassAssignment> getClassAssignmentByTeacher(Teacher teacher) {
        
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + teacher.getId() + " IN (SELECT teachers.id from ca.teachers as teachers)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

}
