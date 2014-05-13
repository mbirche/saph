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
public class EntityDAO extends AbstractDAO{
    
    private static EntityDAO dao;
    public static EntityDAO getInstance(){
        if(dao == null){
            dao = new EntityDAO();
            return dao;
        }else{
            return dao;
        }
    }   
}
