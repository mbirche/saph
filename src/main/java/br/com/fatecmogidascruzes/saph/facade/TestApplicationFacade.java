package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationFacade;
import br.com.fatecmogidascruzes.saph.service.TestApplicationService;

/**
 * All fonts were produced for author's graduation project
 * @date 20/03/2014
 * @author Birche
 */
public class TestApplicationFacade extends AbstractFacade implements ITestApplicationFacade{

    private static TestApplicationFacade facade;
    private TestApplicationService service;
    public static TestApplicationFacade getInstance(){
        if(facade == null){
            facade = new TestApplicationFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private TestApplicationFacade(){
        service = new TestApplicationService();
    }
}
