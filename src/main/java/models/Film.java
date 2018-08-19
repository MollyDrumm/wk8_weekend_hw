package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "films")

public class Film {
    private int id;
    private String title;
    private String genre;
    private List<ActorActress> actorActresses;
    private Studio studio;
    private Director director;

    public Film(){
    }

    public Film(String title, String genre, Studio studio, Director director) {
        this.title = title;
        this.genre = genre;
        this.actorActresses = new ArrayList<ActorActress>();
        this.studio = studio;
        this.director = director;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(
            name = "actorsActresses_films",
            joinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "actorActress_id", nullable = false, updatable = false)}
    )
    public List<ActorActress> getActorActresses() {
        return actorActresses;
    }

    public void setActorActresses(List<ActorActress> actorActresses) {
        this.actorActresses = actorActresses;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }


    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addActorActress(ActorActress actorActress){
        this.actorActresses.add(actorActress);
    }
}
