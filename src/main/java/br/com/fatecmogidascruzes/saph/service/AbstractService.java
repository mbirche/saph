/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.controller.DAOFactory;
import br.com.fatecmogidascruzes.saph.interfaces.IAbstractFacade;
import br.com.fatecmogidascruzes.saph.interfaces.IDAO;
import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class AbstractService implements IAbstractFacade, IDAO{

   private DAOFactory daoFactory;
    
    public AbstractService(){
        daoFactory = DAOFactory.getInstance();
    }
    
    @Override
    public Entity save(Entity entity) {
        return daoFactory.getDAO(entity.getClass()).save(entity); 
    }

    @Override
    public Entity update(Entity entity) {
        return daoFactory.getDAO(entity.getClass()).update(entity);
    }

    @Override
    public Entity get(Long id, Class<? extends Entity> cl) {
        return daoFactory.getDAO(cl).get(id, cl);  
    }

    @Override
    public void delete(Entity entity) {
        daoFactory.getDAO(entity.getClass()).delete(entity);
    }

    @Override
    public List<Entity> getAll(Class<? extends Entity> entity) {
        return daoFactory.getDAO(entity).getAll(entity);
    }
    
}
