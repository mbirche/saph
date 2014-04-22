/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.interfaces.IDAO;
import br.com.fatecmogidascruzes.saph.interfaces.IKnowledgeAreaService;

/**
 *
 * @author marcelo
 */
public class KnowledgeAreaService extends AbstractService implements IKnowledgeAreaService, IDAO{
    
    private static KnowledgeAreaService service;
    public static KnowledgeAreaService getInstance(){
        if(service == null){
            service = new KnowledgeAreaService();
            return service;
        }else{
            return service;
        }
    }   
}
