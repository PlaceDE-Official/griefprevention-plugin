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
        //if he's not holding the claim tool anymore, do nothing
        if (itemStack == null)
            return false;
        ItemMeta heldItemMeta = itemStack.getItemMeta();
        if (heldItemMeta == null)
            return false;

        ItemMeta toolMeta = GriefPrevention.instance.config_claims_modificationTool.getItemMeta();
        assert toolMeta != null;

        if (itemStack.getType() != GriefPrevention.instance.config_claims_modificationTool.getType()) return false;
        if (heldItemMeta.hasDisplayName() != toolMeta.hasDisplayName()) return false;
        if (!heldItemMeta.getDisplayName().equals(toolMeta.getDisplayName())) return false;

        if (heldItemMeta.isUnbreakable() != toolMeta.isUnbreakable()) return false;

        if (heldItemMeta.hasCustomModelData() != toolMeta.hasCustomModelData()) return false;
        if (heldItemMeta.getCustomModelData() != toolMeta.getCustomModelData()) return false;

        return true;
    }
}
