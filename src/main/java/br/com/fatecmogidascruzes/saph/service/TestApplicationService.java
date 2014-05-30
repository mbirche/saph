/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.dao.TestApplicationDAO;
import br.com.fatecmogidascruzes.saph.interfaces.ITestApplicationService;
import br.com.fatecmogidascruzes.saph.model.TestApplication;

/**
 *
 * @author marcelo
 */
public class TestApplicationService extends AbstractService implements ITestApplicationService{

    private static TestApplicationService service;
    private TestApplicationDAO dao;

    public static TestApplicationService getInstance() {
        if (service == null) {
            service = new TestApplicationService();
            return service;
        } else {
            return service;
        }
    }

    public TestApplicationService() {
        dao = (TestApplicationDAO) DAOFactory.getInstance().getDAO(TestApplication.class);
    }
}
