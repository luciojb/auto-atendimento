package generic;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class GenericDAO<T> {

    @SuppressWarnings("rawtypes")
	private final Class typeClass;
	private EntityManagerFactory emf;

	@SuppressWarnings("rawtypes")
	public GenericDAO(Class classType) {
		emf = Persistence.createEntityManagerFactory("atendimento");
		this.typeClass = classType;
	}

	public boolean insert(T obj) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean update(T obj) {
		EntityManager em = emf.createEntityManager();
       try{
    	   em.getTransaction().begin();
           em.merge(obj);
           em.getTransaction().commit();
           return true;
       } catch (Exception e) {
    	   System.err.println(e);
			return false;
       } finally {
		 em.close();
       }
	}
	
    public boolean remove(T obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(obj));
            em.getTransaction().commit();
            return true;
        } catch (PersistenceException e) {
            return false;
        }finally{
            em.close();
        }
    }
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT e FROM ");
            builder.append(typeClass.getSimpleName());
            builder.append(" e");
            return em.createQuery(builder.toString()).getResultList();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            em.close();
        }
	}
	
	@SuppressWarnings("unchecked")
	public T findById(long id) {
        try{
        	EntityManager em = emf.createEntityManager();
        	T obj = (T) em.find(typeClass, id);
            em.close();
            return obj;
        } catch (Exception e) {
        	System.err.println(e);
            return null;
		}
        
    }
	
	@SuppressWarnings("unchecked")
	public T findByField(String field, String desc) {
        EntityManager em = emf.createEntityManager();
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT e FROM ");
            builder.append(typeClass.getSimpleName());
            builder.append(" e");
            builder.append(" WHERE e." + field);
            builder.append(" = '" + desc+"'");
            if (((T) em.createQuery(builder.toString()).getSingleResult())!=null){
            	return (T) em.createQuery(builder.toString()).getSingleResult();
            }
            return null;
        } catch (Exception e) {
        	System.err.println(e);
            return null;
        } finally {
            em.close();
        }
	}
	
	@SuppressWarnings("unchecked")
	public boolean search(String field, String desc) {
        EntityManager em = emf.createEntityManager();
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT e FROM ");
            builder.append(typeClass.getSimpleName());
            builder.append(" e");
            builder.append(" WHERE e." + field);
            builder.append(" LIKE %'" + desc+"'%");
            if (((T) em.createQuery(builder.toString()).getSingleResult())!=null){
            	return true;
            }
            return false;
        } catch (Exception e) {
        	System.err.println(e);
            return false;
        } finally {
            em.close();
        }
	}

	@PreDestroy
	public void destruct() {
		emf.close();
	}
	
}
