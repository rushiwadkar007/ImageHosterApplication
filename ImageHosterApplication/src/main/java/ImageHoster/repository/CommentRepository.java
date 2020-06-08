package ImageHoster.repository;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;
/*
---------------------------------------------------------------------------------------------------------------------------------------
 Version         Modification Date                Developer                Modifications
---------------------------------------------------------------------------------------------------------------------------------------
 *@ 1.0.0.1         30-Dec-2018                  Dhruv Sharma              Functionality Upgrade: Users can add comments for any image.
*/
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory entityManager;

    public void addComments(Comments comments){
        EntityManager entity = entityManager.createEntityManager();
        EntityTransaction transaction = entity.getTransaction();

        try{
            transaction.begin();
            entity.persist(comments);
            transaction.commit();
        }catch(Exception exception){
            transaction.rollback();
        }
    }

    public List<Comments> retrieveComments(Image image){
        List<Comments> comments = new ArrayList<>();
        EntityManager em = entityManager.createEntityManager();
        TypedQuery<Comments> typedQuery = null; //Fix for image upload issue.
        try{
        typedQuery = (TypedQuery<Comments>) em.createQuery("SELECT c from Comments c where c.image =:image", Comments.class); //Added by Dhruv Sharma. Fix for image upload issue.
        typedQuery.setParameter("image",image);
        comments = typedQuery.getResultList();
        }catch(Exception ex){
         ex.printStackTrace();
        }
        return comments;
    }
}
