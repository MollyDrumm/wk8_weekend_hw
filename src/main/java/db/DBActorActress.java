package db;

import models.ActorActress;
import models.Film;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.awt.*;
import java.util.List;

public class DBActorActress {

    private static Session session;

    public static List<Film> getFilmsForActorAcresses(ActorActress actorActress){
        List<Film> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("actorActresses", "actorActress");
            cr.add(Restrictions.eq("actorActress.id", actorActress.getId()));
            results =cr.list();
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
