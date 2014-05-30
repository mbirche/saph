/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.TestDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestService;
import br.com.fatecmogidascruzes.saph.model.Test;

/**
 *
 * @author marcelo
 */
public class TestService extends AbstractService implements ITestService{
    
    private static TestService service;
    private TestDAO dao;
    public static TestService getInstance(){
        if(service == null){
            service = new TestService();
            return service;
        }else{
            return service;
        }
    }   
    public TestService(){
        dao = (TestDAO) DAOFactory.getInstance().getDAO(Test.class);
    }
    
}
