package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public class StudentDAO extends AbstractDAO implements IStudentFacade{

    private static StudentDAO dao;

    public static StudentDAO getInstance() {
        if (dao == null) {
            dao = new StudentDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<StudentClass> getStudentClasses(Student student) {
        
        session = HSession.getSession();
        String hql = "from StudentClass stClass WHERE " + student.getId() + " IN (SELECT students.id FROM stClass.students as students)";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getStudentAssignments(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TestApplication> getStudentTestApplications(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TestResult> getStudentTestResults(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Course> getStudentCourses(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Discipline> getStudentDisciplines(Student student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
