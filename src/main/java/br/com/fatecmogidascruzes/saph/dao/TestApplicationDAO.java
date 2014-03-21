package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;

/**
 * All fonts were produced for author's graduation project
 * @date 20/03/2014
 * @author Birche
 */
public class TestApplicationDAO extends AbstractDAO implements ITestApplicationFacade{

    private static TestApplicationDAO dao;

    public static TestApplicationDAO getInstance() {
        if (dao == null) {
            dao = new TestApplicationDAO();
            return dao;
        } else {
            return dao;
        }
    }
}
