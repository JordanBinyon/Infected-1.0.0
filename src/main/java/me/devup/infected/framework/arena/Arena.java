package me.devup.infected.framework.arena;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Arena {

    private String name, id;

    private ArenaState state;

    private ArenaVote vote;

    private ArenaMap map;

    private List<ArenaTeam> arenaTeams = new ArrayList<>();

}
