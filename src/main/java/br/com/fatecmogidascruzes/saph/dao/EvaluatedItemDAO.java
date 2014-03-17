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
public class EvaluatedItemDAO extends AbstractDAO{
    
    private static EvaluatedItemDAO dao;
    public static EvaluatedItemDAO getInstance(){
        if(dao == null){
            dao = new EvaluatedItemDAO();
            return dao;
        }else{
            return dao;
        }
    }   
}
