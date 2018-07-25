package me.devup.infected.plugin.game;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameManager {

    private static GameManager instance = new GameManager();

    private List<Game> games = new ArrayList<>();

    public static GameManager getInstance() {
        return instance;
    }

    public void createGame() {
        Game game = new Game("Infected-" + (games.size() + 1));

        game.end();

        games.add(game);
    }

    public boolean shouldCreateNewGame() {
        for(Game game : games) {
            if(game.getPlayers().size() < 30) {
                return false;
            }
        }
        return true;
    }

    public Game nextFreeGame() {
        for(Game game : games) {
            if(game.getPlayers().size() < 30) {
                return game;
            }
        }
        return null;
    }

    public Game getGame(Player player) {
        for(Game game : games) {
            if(game.getPlayers().contains(player.getUniqueId())) {
                return game;
            }
        }
        return null;
    }

}
