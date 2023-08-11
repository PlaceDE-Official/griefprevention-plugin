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
        if (itemStack == null)
            return false;
        ItemMeta heldItemMeta = itemStack.getItemMeta();
        if (heldItemMeta == null)
            return false;
        ItemMeta toolMeta = GriefPrevention.instance.config_claims_modificationTool.getItemMeta();
        assert toolMeta != null;
        return itemStack.getType() == GriefPrevention.instance.config_claims_modificationTool.getType()
                && heldItemMeta.getCustomModelData() == toolMeta.getCustomModelData()
                && heldItemMeta.isUnbreakable() == toolMeta.isUnbreakable()
                && heldItemMeta.getDisplayName().equals(toolMeta.getDisplayName()
        );
    }
}
