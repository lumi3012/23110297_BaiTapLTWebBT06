package decorator.dao.impl;

import decorator.config.JPAConfig;
import decorator.dao.UserDao;
import decorator.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl implements UserDao {
	
	@Override
    public User findById(Long id) {
        EntityManager em = JPAConfig.getEntityManager();
        try { return em.find(User.class, id); }
        finally { em.close(); }
    }

    @Override
    public User findByUsername(String username) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username=:u", User.class);
            q.setParameter("u", username);
            return q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally { em.close(); }
    }

    @Override
    public User findByEmail(String email) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email=:e", User.class);
            q.setParameter("e", email);
            return q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally { em.close(); }
    }

    @Override
    public User create(User u) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return u;
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw ex;
        } finally { em.close(); }
    }
}
