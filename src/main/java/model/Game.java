package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String game;
    @Column
    private Timestamp generated;

    public Game(String name) {
        this.game = name;
        this.generated = new Timestamp(System.currentTimeMillis());
    }

    public Game() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String name) {
        this.game = name;
    }

    public Timestamp getGenerated() {
        return generated;
    }

    public void setGenerated(Timestamp generated) {
        this.generated = generated;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + game + '\'' +
                ", generated=" + generated +
                '}';
    }
}
