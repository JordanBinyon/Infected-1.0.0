package me.devup.infected.plugin.game.classes.unlockables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.devup.infected.plugin.game.classes.Rarity;
import org.bukkit.entity.EntityType;

@Getter @AllArgsConstructor
public enum Morphs {
    ZOMBIE(EntityType.ZOMBIE, Rarity.DEFAULT), SKELETON(EntityType.SKELETON, Rarity.RARE), ZOMBIE_PIGMAN(EntityType.PIG_ZOMBIE, Rarity.RARE), ENDERMAN(EntityType.ENDERMAN, Rarity.RARE), WITHER_SKELETON(EntityType.SKELETON, Rarity.RARE), CREEPER(EntityType.CREEPER, Rarity.ULTIMATE), WITCH(EntityType.WITCH, Rarity.ULTIMATE), BLAZE(EntityType.BLAZE, Rarity.ULTIMATE);

    private EntityType type;

    private Rarity rarity;

}
