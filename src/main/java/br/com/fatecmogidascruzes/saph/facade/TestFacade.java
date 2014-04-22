/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.dao.TestDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestFacade;

/**
 *
 * @author Birche
 */
public class TestFacade extends AbstractFacade implements ITestFacade{
    private static TestFacade facade;
    private TestDAO dao;
    public static TestFacade getInstance(){
        if(facade == null){
            facade = new TestFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestFacade(){
        dao = new TestDAO();
    }
}
