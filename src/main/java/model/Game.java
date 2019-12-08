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
    @Column
    private int latest_player;

    public Game(String name, int latestPlayer) {
        this.game = name;
        this.latest_player = latestPlayer;
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

    public int getLatest_player() {
        return latest_player;
    }

    public void setLatest_player(int latestPlayer) {
        this.latest_player = latestPlayer;
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
