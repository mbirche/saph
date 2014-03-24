package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.ITestResultFacade;

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
}
