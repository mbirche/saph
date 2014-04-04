package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.ClassAssignment;
import br.com.fatecmogidascruzes.saph.model.Discipline;
import br.com.fatecmogidascruzes.saph.model.Teacher;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 03/04/2014
 * @author Birche
 */
public interface ITeacherFacade {
    
    public List<ClassAssignment> getClassAssignmentByTeacher(Teacher teacher);
    
}
