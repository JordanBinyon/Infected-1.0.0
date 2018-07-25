package me.devup.infected.framework.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.Serializable;

@Getter @Setter
public class ILocation implements Serializable {

    private static final long serialVersionUID = 8156174473979136073L;

    private String world;

    private double x, y, z;

    private float pitch, yaw;

    public ILocation(Location l) {
        this.world = l.getWorld().getName();

        this.x = l.getX();

        this.y = l.getY();

        this.z = l.getY();

        this.pitch = l.getPitch();

        this.yaw = l.getYaw();
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

}

