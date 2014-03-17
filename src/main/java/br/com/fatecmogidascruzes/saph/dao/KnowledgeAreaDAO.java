/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.dao;

/**
 *
 * @author marcelo
 */
public class KnowledgeAreaDAO extends AbstractDAO{
    
    private static KnowledgeAreaDAO dao;
    public static KnowledgeAreaDAO getInstance(){
        if(dao == null){
            dao = new KnowledgeAreaDAO();
            return dao;
        }else{
            return dao;
        }
    }   
}
