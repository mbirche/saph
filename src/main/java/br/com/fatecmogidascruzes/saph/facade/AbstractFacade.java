/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.facade;

import br.com.fatecmogidascruzes.saph.controller.ServiceFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IAbstractFacade;
import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class AbstractFacade implements IAbstractFacade{

    private ServiceFactory serviceFactory;
    
    public AbstractFacade(){
        serviceFactory = ServiceFactory.getInstance();
    }
    
    @Override
    public Entity save(Entity entity) {
        return serviceFactory.getService(entity.getClass()).save(entity); 
    }

    @Override
    public Entity update(Entity entity) {
        return serviceFactory.getService(entity.getClass()).update(entity);
    }

    @Override
    public Entity get(Long id, Class<? extends Entity> cl) {
        return serviceFactory.getService(cl).get(id, cl);  
    }

    @Override
    public void delete(Entity entity) {
        serviceFactory.getService(entity.getClass()).delete(entity);
    }

    @Override
    public List<Entity> getAll(Class<? extends Entity> entity) {
        return serviceFactory.getService(entity).getAll(entity);
    }
    
}
