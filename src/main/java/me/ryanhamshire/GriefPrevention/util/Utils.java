package me.ryanhamshire.GriefPrevention.util;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Utils
{
    private Utils()
    {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean checkHeldItem(ItemStack itemStack)
    {
        //if he's not holding the golden shovel anymore, do nothing
        if (itemStack == null) return false;
        ItemMeta heldItem = itemStack.getItemMeta();
        ItemMeta toolMeta = GriefPrevention.instance.config_claims_modificationTool.getItemMeta();
        if (!(heldItem.getDisplayName().equals(toolMeta.getDisplayName()) && heldItem.getCustomModelData() == toolMeta.getCustomModelData() && heldItem.isUnbreakable() == toolMeta.isUnbreakable()))
            return false;
        return !heldItem.hasDisplayName() || !toolMeta.hasDisplayName() || heldItem.getDisplayName().equals(toolMeta.getDisplayName());
    }
}
