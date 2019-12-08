package persistenceLogic;

import application.GameApplication;
import javafx.scene.Node;
import model.Board;
import model.Chip;
import model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class PersistenceFacadeImpl implements PersistenceFacade {
    private GameApplication application;
    private Session dao;

    public PersistenceFacadeImpl(GameApplication application) {
        this.application = application;
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata()
                .buildSessionFactory();
        dao = sessionFactory.openSession();
    }

    @Override
    public List<Game> findAll() {
        return dao.createQuery("select game from Game game", Game.class).getResultList();
    }

    @Override
    public void insertGame(String game) {
        System.out.println(game);
        dao.save(new Game(game, application.getBoardFacade().getCurrentPlayer()));
    }

    @Override
    public String parseGameIntoString(Board board) {
        String game = "";

        int row = application.getBoardFacade().getRowCount();
        int column = application.getBoardFacade().getColumnCount();
        Node result;
        for (Node node : board.getChildren()) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (board.getColumnIndex(node) == c && board.getRowIndex(node) == r) {
                        result = node;
                        Chip chip = (Chip) result;
                        game += "" + chip.getColumn() + chip.getRow() + chip.getOccupiedByPlayer() + ",";
                    }
                }
            }
        }
        return game;
    }

    @Override
    public Board unparseGameIntoBoard(String unparsedBoard) {
        Board board = new Board();
        List<Chip> chips = new ArrayList<>();
        String[] list = unparsedBoard.split(",");
        for (String chipSplitted : list) {
            chips.add(new Chip(
                    Character.getNumericValue(chipSplitted.charAt(0)),
                    Character.getNumericValue(chipSplitted.charAt(1)),
                    Character.getNumericValue(chipSplitted.charAt(2))));
        }
        int row = application.getBoardFacade().getRowCount();
        int column = application.getBoardFacade().getColumnCount();
        for (Chip chip : chips) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (chip.getRow() == r && chip.getColumn() == c) {
                        board.add(chip, c, r);
                    }
                }
            }
        }
        return board;
    }
}
