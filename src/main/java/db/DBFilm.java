package db;

import models.ActorActress;
import models.Director;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.awt.*;
import java.util.List;

public class DBFilm {

    private static Session session;
    private static Transaction transaction;

    public static void addFilmToActorActress(Film film, ActorActress actorActress){
        film.addActorActress(actorActress);
        actorActress.addFilm(film);
        DBHelper.update(film);
    }
    public static List<ActorActress> getActorsActressesForFilms(Film film){
        List<ActorActress> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(ActorActress.class);
            cr.createAlias("films", "film");
            cr.add(Restrictions.eq("film.id", film.getId()));
            results =cr.list();
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


}
