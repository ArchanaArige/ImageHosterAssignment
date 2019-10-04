package ImageHoster.repository;

import org.springframework.stereotype.Repository;
import ImageHoster.model.Comment;
import ImageHoster.model.Image;

import javax.persistence.*;
import java.util.List;

/**Comments by Archana: **/
//Defining a CommentRepository for the data to be persisted into the database
//The method receives the Create object to be persisted in the database
//Creates an instance of EntityManager
//Starts a transaction
//The transaction is committed if it is successful
//The transaction is rolled back in case of unsuccessful transaction

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment createComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
                transaction.rollback();
        }
            return comment;
    }

        //Method to retrieve the comments of an image by imageId
        public List<Comment> getAllComments(Integer imageId) {
            EntityManager em = emf.createEntityManager();
            try {
                TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id = :imageId", Comment.class);
                query.setParameter("imageId", imageId);
                List<Comment> resultList = query.getResultList();
                return resultList;
            } catch (NoResultException nre) {
                return null;
            }
        }
    }
