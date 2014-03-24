/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.dao.StudentDAO;
import br.com.fatecmogidascruzes.saph.dao.TestResultDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IStudentFacade;

/**
 *
 * @author Birche
 */
public class StudentFacade extends AbstractFacade implements IStudentFacade{
    
    private static StudentFacade facade;
    private StudentDAO dao;
    public static StudentFacade getInstance(){
        if(facade == null){
            facade = new StudentFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private StudentFacade(){
        dao = new StudentDAO();
    }
}
