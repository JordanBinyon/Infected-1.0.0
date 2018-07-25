package me.devup.infected.plugin.game.account;

import com.mongodb.*;
import me.devup.infected.plugin.game.classes.ClassType;
import me.devup.infected.plugin.game.classes.loadout.Loadout;
import me.devup.infected.plugin.game.classes.unlockables.Items;
import me.devup.infected.plugin.game.classes.unlockables.Morphs;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private static AccountManager instance = new AccountManager();

    private List<Account> accounts = new ArrayList<>();

    public static AccountManager getInstance() {
        return instance;
    }

    public void generateAccount(Player player) {
        MongoClient mongoClient = null;

        Account account = new Account(player.getUniqueId());

        try {
            mongoClient = new MongoClient("localhost", 27017);

            DB database = mongoClient.getDB("PlayerData");

            if(!(database.collectionExists("collection")))
                mongoClient.getDatabase("PlayerData").createCollection("collection");

            DBCollection collection = database.getCollection("collection");

            if(containsPlayer(player, collection)) {
                DBCursor cursor = collection.find(new BasicDBObject().append("player", player.getUniqueId().toString())).limit(1);

                while(cursor.hasNext()) {
                    DBObject object = cursor.next();

                    account.setRank((String) object.get("rank"));

                    account.setKills((int) object.get("kills"));

                    account.setDeaths((int) object.get("deaths"));

                    account.setWins((int) object.get("wins"));

                    account.setFlesh((int) object.get("flesh"));

                    account.setFleshMultiplier((int) object.get("fleshmultiplier"));

                    account.setXp((int) object.get("xp"));

                    account.itemsFromStringArray((String[]) object.get("items"));

                    account.morphsFromStringArray((String[]) object.get("morphs"));

                    DBObject loadoutsObject = (DBObject) object.get("human");

                    for(int i = 0; i < 7; i++) {
                        if(loadoutsObject.containsField(Integer.toString(i))) {
                            DBObject loadoutObject = (DBObject) loadoutsObject.get(Integer.toString(i));

                            Loadout loadout = new Loadout(player.getUniqueId(), i, ClassType.HUMAN);

                            loadout.armourFromStringArray((String[]) loadoutObject.get("armour"));

                            loadout.setSword(Items.valueOf(((String) loadoutObject.get("sword")).toUpperCase()));

                            loadout.setBow(Items.valueOf(((String) loadoutObject.get("bow")).toUpperCase()));

                            loadout.setSelected((boolean) loadoutObject.get("selected"));
                        }
                    }

                    loadoutsObject = (DBObject) object.get("infected");

                    for(int i = 0; i < 7; i++) {
                        if(loadoutsObject.containsField(Integer.toString(i))) {
                            DBObject loadoutObject = (DBObject) loadoutsObject.get(Integer.toString(i));

                            Loadout loadout = new Loadout(player.getUniqueId(), i, ClassType.INFECTED);

                            loadout.armourFromStringArray((String[]) loadoutObject.get("armour"));

                            loadout.setSword(Items.valueOf(((String) loadoutObject.get("sword")).toUpperCase()));

                            loadout.setBow(Items.valueOf(((String) loadoutObject.get("bow")).toUpperCase()));

                            loadout.setMorph(Morphs.valueOf(((String) loadoutObject.get("morph")).toUpperCase()));

                            loadout.setSelected((boolean) loadoutObject.get("selected"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(mongoClient != null)
                mongoClient.close();
        }
        accounts.add(account);
    }

    public void saveAccount(Player player) {
        if(getAccount(player) == null)
            return;

        Account account = getAccount(player);

        MongoClient mongoClient = null;

        try {
            mongoClient = new MongoClient("localhost", 27017);

            DB database = mongoClient.getDB("PlayerData");

            if(!(database.collectionExists("collection")))
                mongoClient.getDatabase("PlayerData").createCollection("collection");

            DBCollection collection = database.getCollection("collection");

            if(containsPlayer(player, collection)) {
                collection.update(new BasicDBObject("player", player.getUniqueId().toString()), new BasicDBObject("$set", account.toDatabaseObject()));
            } else {
                collection.insert(account.toDatabaseObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(mongoClient != null)
                mongoClient.close();
        }

        // TODO Save stats to MySQL

        accounts.remove(account);
    }

    public Account getAccount(Player player) {
        for(Account account : accounts) {
            if(account.getOwner().equals(player.getUniqueId().toString())) {
                return account;
            }
        }
        return null;
    }

    protected boolean containsPlayer(Player player, DBCollection collection) {
        return collection.find(new BasicDBObject().append("player", player.getUniqueId().toString())).limit(1).hasNext();
    }

}
