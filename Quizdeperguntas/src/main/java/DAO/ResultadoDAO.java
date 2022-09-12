package DAO;
import Modelo.Resultado;
import util.JPAutil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ResultadoDAO {
        private EntityManager entityManager = JPAutil.getEntityManager();
        public void addresposta (Resultado resultado){
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(resultado);
                entityManager.getTransaction().commit();
            } catch (Exception e ){
            }
        }
        public List<Resultado> questionario (){
            try {
                String jpql= "select r from Resultado r ";
                return entityManager.createQuery(jpql,Resultado.class).getResultList();
            } catch (Exception e){
                 List<Resultado> placar = new ArrayList<>();
                 Resultado r = new Resultado();
                placar.add( r );
                return placar;


            }
        }


    }

