package me.devup.infected.plugin.game.account;

import com.mongodb.BasicDBObject;
import lombok.Getter;
import lombok.Setter;
import me.devup.infected.framework.arena.ArenaState;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.classes.ClassType;
import me.devup.infected.plugin.game.classes.loadout.Loadout;
import me.devup.infected.plugin.game.classes.unlockables.Items;
import me.devup.infected.plugin.game.classes.unlockables.Morphs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
public class Account {

    private UUID owner;

    private String rank = "default";

    private int kills = 0, deaths = 0, wins = 0, flesh = 0, fleshMultiplier = 1, xp = 0;

    private List<Items> items = new ArrayList<>();

    private List<Morphs> morphs = new ArrayList<>();

    private List<Loadout> loadouts = new ArrayList<>();

    public Account(UUID owner) {
        this.owner = owner;
    }

    public BasicDBObject toDatabaseObject() {
        BasicDBObject object = new BasicDBObject();

        object.append("player", owner.toString())
                .append("rank", rank)
                .append("kills", kills)
                .append("deaths", deaths)
                .append("wins", wins)
                .append("flesh", flesh)
                .append("fleshmultiplier", fleshMultiplier)
                .append("xp", xp)
                .append("items", itemsToStringArray())
                .append("morphs", morphsToStringArray());

        for(Loadout loadout : loadouts)
            object.append(loadout.getType().toString().toLowerCase(), loadout.toDatabaseObject());

        return object;
    }

    public void equip() {
        Player player = Bukkit.getPlayer(owner);

        Game game = GameManager.getInstance().getGame(player);

        if(game.getArena().getState() == ArenaState.INGAME || game.getArena().getState() == ArenaState.PREGAME) {
            if(game.isHuman(player)) {
                for(Loadout loadout : loadouts) {
                    if(loadout.getType() == ClassType.HUMAN) {
                        if(loadout.isSelected()) {
                            loadout.equip();
                        }
                    }
                }
            } else if(game.isInfected(player)) {
                for(Loadout loadout : loadouts) {
                    if(loadout.getType() == ClassType.INFECTED) {
                        if(loadout.isSelected()) {
                            loadout.equip();
                        }
                    }
                }
            }
        }
    }

    public void itemsFromStringArray(String[] array) {
        List<Items> items = new ArrayList<>();

        for(String item : array) {
            items.add(Items.valueOf(item.toUpperCase()));
        }
        this.items = items;
    }

    public void morphsFromStringArray(String[] array) {
        List<Morphs> morphs = new ArrayList<>();

        for(String morph : array) {
            morphs.add(Morphs.valueOf(morph.toUpperCase()));
        }
        this.morphs = morphs;
    }

    protected String[] itemsToStringArray() {
        String[] items = new String[this.items.size()];

        int i = 0;

        for(Items item : this.items) {
            items[i] = item.toString().toLowerCase();

            i++;
        }
        return items;
    }

    protected String[] morphsToStringArray() {
        String[] morphs = new String[this.morphs.size()];

        int i = 0;

        for(Morphs morph : this.morphs) {
            morphs[i] = morph.toString().toLowerCase();

            i++;
        }
        return morphs;
    }

}
