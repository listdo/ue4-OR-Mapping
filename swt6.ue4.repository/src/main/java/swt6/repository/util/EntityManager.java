package swt6.repository.util;

import java.io.Serializable;

/***
 * Implements generic functions for inserting and updating entities
 * used so not all daos have to implement the insert and update on their own
 ***/
public class EntityManager {
    public static <T> T saveEntity(T entity) {
        try{
            javax.persistence.EntityManager em = JpaUtil.getTransactedEntityManager();
            entity = em.merge(entity);
            JpaUtil.commit();
        } catch(Exception e){
            JpaUtil.rollback();
            throw e;
        }

        return entity;
    }

    public static <T> T updateEntity(Serializable id, T entity, Class<T> type){
        T storedEntity = null;

        try{
            javax.persistence.EntityManager em = JpaUtil.getTransactedEntityManager();

            if(id == null){
                throw new RuntimeException("Entity does not exist.");
            }

            storedEntity = em.find(type, id);
            if(storedEntity == null){
                throw new RuntimeException("Entity does not exist.");
            }

            storedEntity = em.merge(entity);

            JpaUtil.commit();
        } catch(Exception e){
            JpaUtil.rollback();
            throw e;
        }

        return storedEntity;
    }
}
