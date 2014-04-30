package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 03/04/2014
 * @author Birche
 */
public interface ICoordinatorFacade extends IAbstractFacade{
    
    public List<Course> getCoursesByCoordinator(User coordinator);

}
