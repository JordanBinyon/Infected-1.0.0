package me.devup.infected.framework.arena;

import lombok.Getter;
import lombok.Setter;
import me.devup.infected.framework.utils.Boundary;
import me.devup.infected.framework.utils.ILocation;

import java.io.Serializable;
import java.util.HashMap;

@Getter @Setter
public class ArenaMap implements Serializable {

    private static final long serialVersionUID = 4811082946519855097L;

    private String name;

    private Boundary boundary;

    private HashMap<Integer, ILocation> spawns = new HashMap<>();

}
