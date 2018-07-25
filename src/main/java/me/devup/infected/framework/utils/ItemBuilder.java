package me.devup.infected.framework.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private ItemStack item = new ItemStack(Material.AIR);

    private ItemMeta itemMeta = item.getItemMeta();

    public ItemBuilder() {}

    public ItemBuilder setMaterial(Material m) {
        item.setType(m);

        return this;
    }

    public ItemBuilder setAmount(int amount) {
        item.setAmount(amount);

        return this;
    }

    public ItemBuilder setData(short s) {
        item.setDurability(s);

        return this;
    }

    public ItemBuilder setName(String name) {
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        return this;
    }

    public ItemBuilder setLore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));

        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        itemMeta.setLore(lore);

        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        item.addEnchantment(enchantment, level);

        return this;
    }

    public ItemBuilder addUnsafeEnchant(Enchantment enchantment, int level) {
        item.addUnsafeEnchantment(enchantment, level);

        return this;
    }

    public ItemStack build() {
        item.setItemMeta(itemMeta);

        return item;
    }
}
