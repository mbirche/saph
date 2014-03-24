package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;

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
}
