/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.List;

/**
 *
 * @author Birche
 */
public interface IAbstractFacade {

    public Entity save(Entity entity);

    public Entity update(Entity entity);

    public Entity get(Long id, Class<? extends Entity> cl);

    public void delete(Entity entity);

    public List<Entity> getAll(Class<? extends Entity> entity);
}
