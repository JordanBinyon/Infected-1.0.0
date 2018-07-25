package me.devup.infected.plugin.game.classes.loadout;

import com.mongodb.BasicDBObject;
import lombok.Getter;
import lombok.Setter;
import me.devup.infected.framework.utils.ItemBuilder;
import me.devup.infected.framework.utils.PlayerUtils;
import me.devup.infected.plugin.game.classes.ClassType;
import me.devup.infected.plugin.game.classes.unlockables.Items;
import me.devup.infected.plugin.game.classes.unlockables.Morphs;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.UUID;

@Getter @Setter
public class Loadout {

    private UUID owner;

    private int id;

    private ClassType type;

    private Items[] armour = new Items[] { Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS };

    private Items sword = Items.STONE_SWORD, bow = Items.BOW;

    private Morphs morph = Morphs.ZOMBIE;

    private boolean selected = false;

    public Loadout(UUID owner, int id, ClassType type) {
        this.owner = owner;

        this.id = id;

        this.type = type;
    }

    public BasicDBObject toDatabaseObject() {
        BasicDBObject object = new BasicDBObject();

        object.append(Integer.toString(id), new BasicDBObject().append("armour", armourToString())
                .append("sword", sword.toString().toLowerCase())
                .append("bow", bow.toString().toLowerCase())
                .append("morph", morph.toString().toLowerCase())
                .append("selected", selected));

        return object;
    }

    public void equip() {
        Player player = Bukkit.getPlayer(owner);

        PlayerUtils.clearInventory(player);

        player.getInventory().setHelmet(armour[0].getItemStack());

        player.getInventory().setChestplate(armour[1].getItemStack());

        player.getInventory().setLeggings(armour[2].getItemStack());

        player.getInventory().setBoots(armour[3].getItemStack());

        player.getInventory().addItem(sword.getItemStack());

        if(type.equals(ClassType.HUMAN)) {
            player.getInventory().addItem(bow.getItemStack());

            player.getInventory().setItem(8, new ItemBuilder().setMaterial(Material.ARROW).setAmount(10).build());
        } else {
            // TODO Disguise the player
        }
    }

    public void armourFromStringArray(String[] armour) {
        this.armour = new Items[] { Items.valueOf(armour[0].toUpperCase()), Items.valueOf(armour[1].toUpperCase()), Items.valueOf(armour[2].toUpperCase()), Items.valueOf(armour[3].toUpperCase()) };
    }

    protected String[] armourToString() {
        return new String[] { armour[0].toString().toLowerCase(), armour[1].toString().toLowerCase(), armour[2].toString().toLowerCase(), armour[3].toString().toLowerCase() };
    }
}
