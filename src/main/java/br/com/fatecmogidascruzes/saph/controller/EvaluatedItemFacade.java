/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

import br.com.fatecmogidascruzes.saph.interfaces.IEvaluatedItemFacade;

/**
 *
 * @author Birche
 */
public class EvaluatedItemFacade extends AbstractFacade implements IEvaluatedItemFacade{
    
    private static EvaluatedItemFacade facade;
    public static EvaluatedItemFacade getInstance(){
        if(facade == null){
            facade = new EvaluatedItemFacade();
            return facade;
        }else{
            return facade;
        }
    }   
}
