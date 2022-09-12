package util;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Stack;

public class JPAutil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("pb_quiz");
    public static EntityManager getEntityManager (){
        return FACTORY.createEntityManager();


    }




}
