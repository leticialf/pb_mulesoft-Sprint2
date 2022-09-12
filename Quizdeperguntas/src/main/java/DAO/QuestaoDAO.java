package DAO;

import Modelo.Questao;
import util.JPAutil;

import javax.persistence.EntityManager;
import java.util.List;

public class QuestaoDAO {
    private EntityManager entityManager = JPAutil.getEntityManager();
    public List <Questao> questionario (){
        try {
            String jpql= "select q from Questao q where q.ativa =  true";
            return entityManager.createQuery(jpql,Questao.class).getResultList();

        } catch (Exception e){
            return null;
        }
    }


}
