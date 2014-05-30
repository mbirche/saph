/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.ITestFacade;
import br.com.fatecmogidascruzes.saph.service.TestService;

/**
 *
 * @author Birche
 */
public class TestFacade extends AbstractFacade implements ITestFacade{
    private static TestFacade facade;
    private TestService service;
    public static TestFacade getInstance(){
        if(facade == null){
            facade = new TestFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestFacade(){
        service = new TestService();
    }
}
