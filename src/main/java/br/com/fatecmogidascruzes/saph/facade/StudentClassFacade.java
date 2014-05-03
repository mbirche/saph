/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.IStudentClassFacade;
import br.com.fatecmogidascruzes.saph.service.StudentClassService;

/**
 *
 * @author Birche
 */
public class StudentClassFacade extends AbstractFacade implements IStudentClassFacade{
    
    private static StudentClassFacade facade;
    private StudentClassService service;
    public static StudentClassFacade getInstance(){
        if(facade == null){
            facade = new StudentClassFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private StudentClassFacade(){
        service = new StudentClassService();
    }
    
}
