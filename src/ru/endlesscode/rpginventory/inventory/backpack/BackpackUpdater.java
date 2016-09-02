package ru.endlesscode.rpginventory.inventory.backpack;

import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import ru.endlesscode.rpginventory.RPGInventory;

import java.util.Arrays;

/**
 * Created by OsipXD on 26.08.2016
 * It is part of the RpgInventory.
 * All rights reserved 2014 - 2016 © «EndlessCode Group»
 */
public class BackpackUpdater extends BukkitRunnable {
    private final Inventory inventory;
    private final Backpack backpack;

    private BackpackUpdater(Inventory inventory, Backpack backpack) {
        this.inventory = inventory;
        this.backpack = backpack;
    }

    public static void update(Inventory inventory, Backpack backpack) {
        new BackpackUpdater(inventory, backpack).runTaskLater(RPGInventory.getInstance(), 2);
    }

    @Override
    public void run() {
        backpack.onUse();
        backpack.setContents(Arrays.copyOfRange(inventory.getContents(), 0, backpack.getType().getSize()));
    }
}
