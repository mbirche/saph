package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Student;
import br.com.fatecmogidascruzes.saph.model.TestResult;
import java.util.List;

/**
 * All fonts were produced for author's graduation project
 * @date 24/03/2014
 * @author Birche
 */
public interface ITestResultFacade extends IAbstractFacade{
    public List<TestResult> getTestResultsByStudent(Student student);
}
