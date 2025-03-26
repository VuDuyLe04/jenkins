package hsf302.se1868vj.he187349.dao.impl;

import hsf302.se1868vj.he187349.dao.RestaurantDAO;
import hsf302.se1868vj.he187349.entity.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
    private final EntityManagerFactory entityManagerFactory;

    public RestaurantDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Restaurant restaurant) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(restaurant);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Restaurant> agents = null;
        try {
            agents = entityManager.createQuery("SELECT a FROM Restaurant a", Restaurant.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return agents;
    }

    @Override
    public boolean isRestaurantExistsByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            long count = entityManager.createQuery("SELECT COUNT(r) FROM Restaurant r WHERE r.email = :email", Long.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
