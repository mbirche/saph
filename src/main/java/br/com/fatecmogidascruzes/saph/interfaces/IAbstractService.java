/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.List;

/**
 *
 * @author marcelo
 */
public interface IAbstractService extends IAbstractFacade, IDAO{
    
    @Override
    public Entity save(Entity entity);

    @Override
    public Entity update(Entity entity);

    @Override
    public Entity get(Long id, Class<? extends Entity> cl);

    @Override
    public void delete(Entity entity);

    @Override
    public List<Entity> getAll(Class<? extends Entity> entity);
}
