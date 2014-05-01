/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.config.HSession;
import br.com.fatecmogidascruzes.saph.interfaces.IDAO;
import br.com.fatecmogidascruzes.saph.model.Entity;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;

/**
 *
 * @author Birche
 */
public class AbstractDAO implements IDAO {

    protected Session session;
    protected Transaction tx;

    @Override
    public Entity save(Entity entity) {
        session = HSession.getSession();
        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(entity);
            tx.commit();
            session.flush();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
//            session.close();
        }
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        session = HSession.getSession();
        tx = session.beginTransaction();
        try {
            session.update(entity);
            tx.commit();
            session.flush();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
//            session.close();
        }
        return entity;
    }

    @Override
    public void delete(Entity entity) {
        session = HSession.getSession();
        tx = session.beginTransaction();
        try {
            session.delete(entity);
            tx.commit();
            session.flush();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            
//            session.close();
        }
    }

    @Override
    public Entity get(Long id, Class<? extends Entity> cl) {

        session = HSession.getSession();
        Entity entity = (Entity) session.get(cl, id);
//        session.close();

        return entity;
    }

    @Override
    public List getAll(Class cl) {
        session = HSession.getSession();
        Criteria crit = session.createCriteria(cl);
        crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        List entities = crit.list();
//        session.close();
        return entities;
    }
}
