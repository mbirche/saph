package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;
import br.com.fatecmogidascruzes.saph.model.TestApplication;

import br.com.fatecmogidascruzes.saph.model.TestResult;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;
import org.hibernate.Query;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public class TestResultDAO extends AbstractDAO implements ITestResultFacade{

    private static TestResultDAO dao;

    public static TestResultDAO getInstance() {
        if (dao == null) {
            dao = new TestResultDAO();
            return dao;
        } else {
            return dao;
        }
    }

    @Override
    public List<TestResult> getTestResultsByStudent(User student) {
        
        session = HSession.getSession();
        String hql = "from TestResult tr WHERE " + student.getId() + " = tr.student.id";
        Query q = session.createQuery(hql);
        
        List entities = q.list();
        return entities;
    }

    @Override
    public List<TestResult> getTestResultsByTestApplication(TestApplication testApp) {
        session = HSession.getSession();
        String hql = "from TestResult tr WHERE :testAppId = tr.testApplication.id";
        Query q = session.createQuery(hql);
        q.setString("testAppId", testApp.getId().toString());
        
        List entities = q.list();
        return entities;
    }
}
