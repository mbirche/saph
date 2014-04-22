/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.CoordinatorDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinable;
import br.com.fatecmogidascruzes.saph.interfaces.ICoordinatorFacade;
import br.com.fatecmogidascruzes.saph.model.Course;
import java.util.List;

/**
 *
 * @author Birche
 */
public class CoordinatorFacade extends AbstractFacade implements ICoordinatorFacade{
    
    private static CoordinatorFacade facade;
    private CoordinatorDAO dao;
    public static CoordinatorFacade getInstance(){
        if(facade == null){
            facade = new CoordinatorFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private CoordinatorFacade(){
        dao = new CoordinatorDAO();
    }

    @Override
    public List<Course> getCoursesByCoordinator(ICoordinable coordinator) {
        return dao.getCoursesByCoordinator(coordinator);
    }
    
}
