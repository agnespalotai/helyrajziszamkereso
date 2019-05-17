package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.List;
import model.*;

/**
 * Osztály, ami megkeresei a formátumnak megfelelő helyrajziszámhoz
 * tartozó cím(eke)t az adatbázisban.
 */
public class Kereses {

    /**
     * Adatbáziskezelő.
     */
    private static EntityManager em;

    /**
     * Metódusm ami visszaadja az adatbáziskeresés találati eredményét.
     * @param hrsz a keresendő helyrajziszám
     * @return List<Hrsz> a kapott eredménylista
     */
    public List<Hrsz> readHrszBy(String hrsz){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hrsz_remotemysql");
        em = emf.createEntityManager();

        TypedQuery<Hrsz> q = em.createQuery("SELECT h FROM Hrsz h WHERE h.helyrajziszam='" + hrsz + "'", Hrsz.class);
        List<Hrsz> result = q.getResultList();

        em.close();
        emf.close();
        return result;
    }

}
