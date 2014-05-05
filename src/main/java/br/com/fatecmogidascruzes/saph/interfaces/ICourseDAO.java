/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Course;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.User;
import java.util.List;

/**
 *
 * @author marcelo
 */
public interface ICourseDAO extends IDAO{
    
    public List<Course> getCoursesByCoordinator(User coordinator);
    
    public List<Course> getCoursesByDiscipline(Discipline discipline);
    
}
