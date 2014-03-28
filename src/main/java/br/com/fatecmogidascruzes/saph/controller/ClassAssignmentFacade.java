/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.interfaces.IClassAssignmentFacade;

/**
 *
 * @author Birche
 */
public class ClassAssignmentFacade extends AbstractFacade implements IClassAssignmentFacade{
    
    private static ClassAssignmentFacade facade;
    public static ClassAssignmentFacade getInstance(){
        if(facade == null){
            facade = new ClassAssignmentFacade();
            return facade;
        }else{
            return facade;
        }
    }   
}
