/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.StudentClassDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentClassFacade;

/**
 *
 * @author Birche
 */
public class StudentClassFacade extends AbstractFacade implements IStudentClassFacade{
    
    private static StudentClassFacade facade;
    private StudentClassDAO dao;
    public static StudentClassFacade getInstance(){
        if(facade == null){
            facade = new StudentClassFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private StudentClassFacade(){
        dao = new StudentClassDAO();
    }
    
}
