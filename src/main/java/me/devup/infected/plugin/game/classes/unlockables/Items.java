package me.devup.infected.plugin.game.classes.unlockables;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.devup.infected.framework.utils.ItemBuilder;
import me.devup.infected.plugin.game.classes.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

@Getter @AllArgsConstructor
public enum Items {

    LEATHER_HELMET(new ItemBuilder().setMaterial(Material.LEATHER_HELMET).build(), Rarity.DEFAULT),

    LEATHER_CHESTPLATE(new ItemBuilder().setMaterial(Material.LEATHER_CHESTPLATE).build(), Rarity.DEFAULT),

    LEATHER_LEGGINGS(new ItemBuilder().setMaterial(Material.LEATHER_LEGGINGS).build(), Rarity.DEFAULT),

    LEATHER_BOOTS(new ItemBuilder().setMaterial(Material.LEATHER_BOOTS).build(), Rarity.DEFAULT),

    GOLD_HELMET(new ItemBuilder().setMaterial(Material.GOLD_HELMET).build(), Rarity.UNCOMMON),

    GOLD_CHESTPLATE(new ItemBuilder().setMaterial(Material.GOLD_CHESTPLATE).build(), Rarity.UNCOMMON),

    GOLD_LEGGINGS(new ItemBuilder().setMaterial(Material.GOLD_LEGGINGS).build(), Rarity.UNCOMMON),

    GOLD_BOOTS(new ItemBuilder().setMaterial(Material.GOLD_BOOTS).build(), Rarity.UNCOMMON),

    IRON_HELMET(new ItemBuilder().setMaterial(Material.IRON_HELMET).build(), Rarity.RARE),

    IRON_CHESTPLATE(new ItemBuilder().setMaterial(Material.IRON_CHESTPLATE).build(), Rarity.RARE),

    IRON_LEGGINGS(new ItemBuilder().setMaterial(Material.IRON_LEGGINGS).build(), Rarity.RARE),

    IRON_BOOTS(new ItemBuilder().setMaterial(Material.IRON_BOOTS).build(), Rarity.RARE),

    DIAMOND_HELMET(new ItemBuilder().setMaterial(Material.DIAMOND_HELMET).build(), Rarity.ULTRA_RARE),

    DIAMOND_CHESTPLATE(new ItemBuilder().setMaterial(Material.DIAMOND_CHESTPLATE).build(), Rarity.ULTRA_RARE),

    DIAMOND_LEGGINGS(new ItemBuilder().setMaterial(Material.DIAMOND_LEGGINGS).build(), Rarity.ULTRA_RARE),

    DIAMOND_BOOTS(new ItemBuilder().setMaterial(Material.DIAMOND_BOOTS).build(), Rarity.ULTRA_RARE),

    GOLD_ULTIMATE_LEVEL_1_HELMET(new ItemBuilder().setMaterial(Material.GOLD_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_1_CHESTPLATE(new ItemBuilder().setMaterial(Material.GOLD_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_1_LEGGINGS(new ItemBuilder().setMaterial(Material.GOLD_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_1_BOOTS(new ItemBuilder().setMaterial(Material.GOLD_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_1_HELMET(new ItemBuilder().setMaterial(Material.IRON_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_1_CHESTPLATE(new ItemBuilder().setMaterial(Material.IRON_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_1_LEGGINGS(new ItemBuilder().setMaterial(Material.IRON_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_1_BOOTS(new ItemBuilder().setMaterial(Material.IRON_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_1_HELMET(new ItemBuilder().setMaterial(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_1_CHESTPLATE(new ItemBuilder().setMaterial(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_1_LEGGINGS(new ItemBuilder().setMaterial(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_1_BOOTS(new ItemBuilder().setMaterial(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_2_HELMET(new ItemBuilder().setMaterial(Material.GOLD_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_2_CHESTPLATE(new ItemBuilder().setMaterial(Material.GOLD_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_2_LEGGINGS(new ItemBuilder().setMaterial(Material.GOLD_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_2_BOOTS(new ItemBuilder().setMaterial(Material.GOLD_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_2_HELMET(new ItemBuilder().setMaterial(Material.IRON_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_2_CHESTPLATE(new ItemBuilder().setMaterial(Material.IRON_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_2_LEGGINGS(new ItemBuilder().setMaterial(Material.IRON_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_2_BOOTS(new ItemBuilder().setMaterial(Material.IRON_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_2_HELMET(new ItemBuilder().setMaterial(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_2_CHESTPLATE(new ItemBuilder().setMaterial(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_2_LEGGINGS(new ItemBuilder().setMaterial(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_2_BOOTS(new ItemBuilder().setMaterial(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_3_HELMET(new ItemBuilder().setMaterial(Material.GOLD_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_3_CHESTPLATE(new ItemBuilder().setMaterial(Material.GOLD_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_3_LEGGINGS(new ItemBuilder().setMaterial(Material.GOLD_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_3_BOOTS(new ItemBuilder().setMaterial(Material.GOLD_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_3_HELMET(new ItemBuilder().setMaterial(Material.IRON_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_3_CHESTPLATE(new ItemBuilder().setMaterial(Material.IRON_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_3_LEGGINGS(new ItemBuilder().setMaterial(Material.IRON_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_3_BOOTS(new ItemBuilder().setMaterial(Material.IRON_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_3_HELMET(new ItemBuilder().setMaterial(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_3_CHESTPLATE(new ItemBuilder().setMaterial(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_3_LEGGINGS(new ItemBuilder().setMaterial(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_3_BOOTS(new ItemBuilder().setMaterial(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_4_HELMET(new ItemBuilder().setMaterial(Material.GOLD_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_4_CHESTPLATE(new ItemBuilder().setMaterial(Material.GOLD_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_4_LEGGINGS(new ItemBuilder().setMaterial(Material.GOLD_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_4_BOOTS(new ItemBuilder().setMaterial(Material.GOLD_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_4_HELMET(new ItemBuilder().setMaterial(Material.IRON_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_4_CHESTPLATE(new ItemBuilder().setMaterial(Material.IRON_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_4_LEGGINGS(new ItemBuilder().setMaterial(Material.IRON_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_4_BOOTS(new ItemBuilder().setMaterial(Material.IRON_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_4_HELMET(new ItemBuilder().setMaterial(Material.DIAMOND_HELMET).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_4_CHESTPLATE(new ItemBuilder().setMaterial(Material.DIAMOND_CHESTPLATE).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_4_LEGGINGS(new ItemBuilder().setMaterial(Material.DIAMOND_LEGGINGS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_4_BOOTS(new ItemBuilder().setMaterial(Material.DIAMOND_BOOTS).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).build(), Rarity.ULTIMATE),

    STONE_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).build(), Rarity.DEFAULT),

    GOLD_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).build(), Rarity.UNCOMMON),

    IRON_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).build(), Rarity.RARE),

    DIAMOND_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).build(), Rarity.ULTRA_RARE),

    GOLD_ULTIMATE_LEVEL_1_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 1).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_1_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 1).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_1_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 1).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_2_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 2).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_2_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 2).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_2_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 2).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_3_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 3).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_3_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 3).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_3_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 3).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_4_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 4).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_4_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 4).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_4_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 4).build(), Rarity.ULTIMATE),

    GOLD_ULTIMATE_LEVEL_5_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 5).build(), Rarity.ULTIMATE),

    IRON_ULTIMATE_LEVEL_5_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 5).build(), Rarity.ULTIMATE),

    DIAMOND_ULTIMATE_LEVEL_5_SWORD(new ItemBuilder().setMaterial(Material.STONE_SWORD).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.DAMAGE_ALL, 5).build(), Rarity.ULTIMATE),

    BOW(new ItemBuilder().setMaterial(Material.BOW).build(), Rarity.DEFAULT),

    BOW_ULTIMATE_LEVEL_1(new ItemBuilder().setMaterial(Material.BOW).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.ARROW_DAMAGE, 1).build(), Rarity.ULTIMATE),

    BOW_ULTIMATE_LEVEL_2(new ItemBuilder().setMaterial(Material.BOW).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.ARROW_DAMAGE, 2).build(), Rarity.ULTIMATE),

    BOW_ULTIMATE_LEVEL_3(new ItemBuilder().setMaterial(Material.BOW).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.ARROW_DAMAGE, 3).build(), Rarity.ULTIMATE),

    BOW_ULTIMATE_LEVEL_4(new ItemBuilder().setMaterial(Material.BOW).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.ARROW_DAMAGE, 4).build(), Rarity.ULTIMATE),

    BOW_ULTIMATE_LEVEL_5(new ItemBuilder().setMaterial(Material.BOW).setName(ChatColor.translateAlternateColorCodes('&', "&c&lUltimate")).addEnchant(Enchantment.ARROW_DAMAGE, 5).build(), Rarity.ULTIMATE);

    private ItemStack itemStack;

    private Rarity rarity;

}
