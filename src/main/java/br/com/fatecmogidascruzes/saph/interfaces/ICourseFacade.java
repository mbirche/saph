package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Coordinator;
import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 02/04/2014
 * @author Birche
 */
public interface ICourseFacade extends IAbstractFacade{
    
    public List<Course> getCoursesByCoordinator(Coordinator coordinator);
    
    public List<Course> getCoursesByDiscipline(Discipline discipline);
}
