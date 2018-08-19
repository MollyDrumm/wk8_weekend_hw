import db.*;
import models.ActorActress;
import models.Director;
import models.Film;
import models.Studio;

import java.util.List;

import static db.DBDirector.getFilmsForDirector;

public class Runner {

    public static void main(String[] args){

        Studio studio1 = new Studio("20th Century Fox");
        DBHelper.save(studio1);
        Studio studio2 = new Studio("Warner Bros");
        DBHelper.save(studio2);

        Director director1 = new Director("Christopher Nolan");
        DBHelper.save(director1);
        Director director2 = new Director("Steven Spielberg");
        DBHelper.save(director2);
        Director director3 = new Director("Quentin Tarantino");
        DBHelper.save(director3);

        Film film1 = new Film("The Hateful Eight ", "Western Comedy", studio1, director3);
        DBHelper.save(film1);
        Film film2 = new Film("Inception ", "SciFi", studio2, director1);
        DBHelper.save(film2);
        Film film3 = new Film("E.T", "SciFi", studio1, director2);
        DBHelper.save(film3);
        Film film4 = new Film("Pulp Fiction", "Drama", studio2, director3);
        DBHelper.save(film4);

        ActorActress actorActress1 = new ActorActress("Leonardo DiCapario", 43);
        DBHelper.save(actorActress1);
        ActorActress actorActress2 = new ActorActress("Uma Thurman", 48);
        DBHelper.save(actorActress2);
        ActorActress actorActress3 = new ActorActress("Samuel L Jackson", 69);
        DBHelper.save(actorActress3);
        ActorActress actorActress4 = new ActorActress("Drew Barrymore", 43);
        DBHelper.save(actorActress4);


        List<Film> filmsForDirector = DBDirector.getFilmsForDirector(director1);

        List<Film> filmsForStudio = DBStudio.getFilmsForStudio(studio2);

        DBFilm.addFilmToActorActress(film1, actorActress3);
        DBFilm.addFilmToActorActress(film4, actorActress3);
        DBFilm.addFilmToActorActress(film2, actorActress1);

        List<Film> films = DBActorActress.getFilmsForActorAcresses(actorActress3);
        List<ActorActress> actorActresses = DBFilm.getActorsActressesForFilms(film1);

    }

}
