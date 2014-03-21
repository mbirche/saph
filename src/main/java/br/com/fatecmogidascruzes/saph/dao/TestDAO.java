package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.ITestFacade;

/**
 * All fonts were produced for author's graduation project
 * @date 20/03/2014
 * @author Birche
 */
public class TestDAO extends AbstractDAO implements ITestFacade{

    private static TestDAO dao;

    public static TestDAO getInstance() {
        if (dao == null) {
            dao = new TestDAO();
            return dao;
        } else {
            return dao;
        }
    }
}
