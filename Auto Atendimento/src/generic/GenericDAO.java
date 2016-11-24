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
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
        return true;
	}
	
    public boolean remove(T obj) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);  
            em.remove(obj);
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
        EntityManager em = emf.createEntityManager();
        T obj = (T) em.find(typeClass, id);
        em.close();
        return obj;
    }

	@PreDestroy
	public void destruct() {
		emf.close();
	}
}
