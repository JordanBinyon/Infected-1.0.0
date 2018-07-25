package me.devup.infected.framework.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;

@Getter @Setter
public class Boundary {

    private World world;

    private Location lowerBound, upperBound;

    public Boundary(World world, Location corner1, Location corner2) {
        this.world = world;

        this.lowerBound = new Location(world, Math.min(corner1.getX(), corner2.getX()), Math.min(corner1.getX(), corner2.getX()), Math.min(corner1.getX(), corner2.getX()));

        this.upperBound = new Location(world, Math.max(corner1.getX(), corner2.getX()), Math.max(corner1.getX(), corner2.getX()), Math.max(corner1.getX(), corner2.getX()));
    }

    public boolean contains(Location location) {
        return location.getX() >= getLowerBound().getX() && location.getX() <= getUpperBound().getX() && location.getY() >= getLowerBound().getY() && location.getY() <= getUpperBound().getY() && location.getZ() >= getLowerBound().getZ() && location.getZ() <= getUpperBound().getZ();
    }
}
