package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Coordinator;
import br.com.fatecmogidascruzes.saph.model.Course;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 03/04/2014
 * @author Birche
 */
public interface ICoordinatorFacade extends IAbstractFacade{
    
    public List<Course> getCoursesByCoordinator(ICoordinable coordinator);

}
