package me.devup.infected.framework.arena;

import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter @Setter
public class ArenaMapManager {

    private static ArenaMapManager instance;

    protected Plugin plugin;

    private List<ArenaMap> maps = new ArrayList<>();

    public ArenaMapManager(Plugin plugin) {
        for(File file : new File("plugins/" + plugin.getName() + "/Maps").listFiles()) {
            try {
                @Cleanup FileInputStream fileInputStream = new FileInputStream(file);

                @Cleanup ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                maps.add((ArenaMap) objectInputStream.readObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArenaMapManager getInstance() {
        return instance;
    }

    public static void setInstance(ArenaMapManager instance) {
        ArenaMapManager.instance = instance;
    }

    /*
     *  To be used only when a map does not already exist.
     */
    public void createMap(ArenaMap map) {
        try {
            @Cleanup FileOutputStream fileOutputStream = new FileOutputStream(new File("plugins/" + plugin.getName() + "/Maps/" + map.getName() + ".ser"));

            @Cleanup ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(map);

            maps.add(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArenaMap[] getRandomMaps(int amount) {
        if(amount >= maps.size())
            return (ArenaMap[]) maps.toArray();

        Collections.shuffle(maps);

        ArenaMap[] rMaps = new ArenaMap[amount];

        for(int i = 0; i < amount; i++) {
            rMaps[i]= maps.get(i);
        }
        return rMaps;
    }

    public ArenaMap getMap(String name) {
        for(ArenaMap map : maps) {
            if(map.getName().equalsIgnoreCase(name)) {
                return map;
            }
        }
        return null;
    }

}
