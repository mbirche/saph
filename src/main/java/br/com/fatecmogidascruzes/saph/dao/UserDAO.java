/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinatorFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;
import br.com.fatecmogidascruzes.saph.interfaces.ITeacherFacade;
import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.StudentClass;
import br.com.fatecmogidascruzes.saph.model.TestApplication;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author marcelo
 */
public class UserDAO extends AbstractDAO implements IStudentFacade, ICoordinatorFacade, ITeacherFacade{
    
    private static UserDAO dao;

    public static UserDAO getInstance() {
        if (dao == null) {
            dao = new UserDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<StudentClass> getStudentClasses(User student) {
        
        session = HSession.getSession();
        String hql = "from StudentClass stClass WHERE " + student.getId() + " IN (SELECT students.id FROM stClass.students as students)";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<ClassAssignment> getStudentAssignments(User student) {
        
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + student.getId() + " IN (SELECT students.id FROM ca.studentClasses as classes JOIN classes.students as students)";
        Query q = session.createQuery(hql);
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<TestApplication> getStudentTestApplications(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TestResult> getStudentTestResults(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Course> getStudentCourses(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Discipline> getStudentDisciplines(User student) {
        throw new UnsupportedOperationException("Not supported yet.");
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
    public List<ClassAssignment> getClassAssignmentByTeacher(User teacher) {
        
        session = HSession.getSession();
        String hql = "from ClassAssignment ca WHERE " + teacher.getId() + " IN (SELECT teachers.id from ca.teachers as teachers)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }

    @Override
    public List<TestApplication> getTestApplicationsByTeacher(User teacher) {
        
        session = HSession.getSession();
        String hql = "from TestApplication ta WHERE " + teacher.getId() + " IN (SELECT teachers.id from ta.classAssignment.teachers as teachers)";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        session.close();
        return entities;
    }
}
