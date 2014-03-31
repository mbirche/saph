package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.IStudentClassFacade;

/**
 * All fonts were produced for author's graduation project
 * @date 31/03/2014
 * @author Birche
 */
public class StudentClassDAO extends AbstractDAO implements IStudentClassFacade{

    private static StudentClassDAO dao;

    public static StudentClassDAO getInstance() {
        if (dao == null) {
            dao = new StudentClassDAO();
            return dao;
        } else {
            return dao;
        }
    }
}
