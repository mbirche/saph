/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.controller;

/**
 *
 * @author Birche
 */
public class KnowledgeAreaFacade extends AbstractFacade{
    
    private static KnowledgeAreaFacade facade;
    public static KnowledgeAreaFacade getInstance(){
        if(facade == null){
            facade = new KnowledgeAreaFacade();
            return facade;
        }else{
            return facade;
        }
    }   
}
