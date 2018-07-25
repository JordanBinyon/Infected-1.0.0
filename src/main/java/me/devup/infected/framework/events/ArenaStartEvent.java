package me.devup.infected.framework.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArenaStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public ArenaStartEvent() {}

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
