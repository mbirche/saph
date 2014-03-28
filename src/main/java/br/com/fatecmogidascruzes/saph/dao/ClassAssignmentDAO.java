package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IClassAssignmentFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 27/03/2014
 * @author Birche
 */
public class ClassAssignmentDAO extends AbstractDAO implements IClassAssignmentFacade{

    private static ClassAssignmentDAO dao;

    public static ClassAssignmentDAO getInstance() {
        if (dao == null) {
            dao = new ClassAssignmentDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByTeacher(Teacher teacher) {
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + teacher.getId() + " IN (SELECT teachers.id from ca.teachers as teachers)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByCourse(Course course) {
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + course.getId() + " = ca.course.id";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByDiscipline(Discipline discipline) {
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + discipline.getId() + " = ca.discipline.id";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudentClass(StudentClass studentClass) {
        
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + studentClass.getId() + " IN (SELECT classes.id from ca.studentClasses as classes)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getClassAssignmentsByStudent(Student student) {
        
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + student.getId() + " IN (SELECT students.id from ca.studentClasses as classes join classes.students as students)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

   
}
