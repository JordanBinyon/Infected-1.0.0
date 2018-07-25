package me.devup.infected.framework.arena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.*;

@Getter @Setter
public class ArenaVote {

    private Set<UUID> voted = new HashSet<>();

    private Map<String, Integer> votes = new HashMap<>();

    private boolean cancelled = false;

    public void setOptions(String... options) {
        for(String option : options) {
            votes.put(option, 0);
        }
    }

    public void addOption(String option) {
        votes.put(option, 0);
    }

    public int getVotesOf(String option) {
        return votes.containsKey(option) ? votes.get(option) : -1;
    }

    public TreeMap<String, Integer> getOrdered() {
        OrderComparator orderComparator = new OrderComparator(votes);

        TreeMap<String, Integer> ordered = new TreeMap<>(orderComparator);

        ordered.putAll(votes);

        return ordered;
    }

    public Set<String> getTopOptions() {
        return getOrdered().keySet();
    }

    public Collection<Integer> getTopVotes() {
        return getOrdered().values();
    }

    public boolean vote(Player player, String option) {
        if(voted.contains(player.getUniqueId()))
            return false;

        voted.add(player.getUniqueId());

        votes.put(option, votes.get(option) + 1);

        return true;
    }

    public void reset() {
    voted.clear();

        votes.clear();
    }

    @AllArgsConstructor
    class OrderComparator implements Comparator<String> {

        private Map<String, Integer> input;

        public int compare(String a, String b) {
            return input.get(a) >= input.get(b) ? -1 : 1;
        }
    }

}
