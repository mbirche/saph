/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.interfaces.IDisciplineFacade;
import br.com.fatecmogidascruzes.saph.service.DisciplineService;

/**
 *
 * @author Birche
 */
public class DisciplineFacade extends AbstractFacade implements IDisciplineFacade{
    
    private static DisciplineFacade facade;
    private DisciplineService service;
    public static DisciplineFacade getInstance(){
        if(facade == null){
            facade = new DisciplineFacade();
            return facade;
        }else{
            return facade;
        }
    }
    private DisciplineFacade(){
        service = new DisciplineService();
    }
}
