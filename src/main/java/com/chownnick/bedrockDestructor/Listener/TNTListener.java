package com.chownnick.bedrockDestructor.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.jetbrains.annotations.NotNull;

public final class TNTListener implements Listener {

    @EventHandler
    public void onTNTExplode(ExplosionPrimeEvent event) {
        //Get the entity for the exploding TNT.
        final Entity explodingTNT = event.getEntity();

        //Check if entity is TNT. (If not return)
        if (explodingTNT.getType() != EntityType.TNT) return;

        //Get the world of the exploding TNT.
        @NotNull World world = explodingTNT.getWorld();

        //Location of the exploding TNT.
        Location loc = explodingTNT.getLocation();

        //Define the block where the tnt is and its relative directly facing blocks.
        Block blockAtTNT = world.getBlockAt(loc);
        Block[] allBlocks = new Block[7];
        for (int i = 0; i < 7; i++) {
            int faceIndex = (i % 7) + 1;
            switch (faceIndex) {
                case 1:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.NORTH, 1);
                    break;
                case 2:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.EAST, 1);
                    break;
                case 3:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.SOUTH, 1);
                    break;
                case 4:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.WEST, 1);
                    break;
                case 5:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.UP, 1);
                    break;
                case 6:
                    allBlocks[i] = blockAtTNT.getRelative(BlockFace.DOWN, 1);
                    break;
                case 7:
                    allBlocks[i] = blockAtTNT;
                    break;
            }
        }


        //Checks the TNT's position block along with its faces and, sets them to AIR
        for (Block block : allBlocks) {
            if (block.getType() == Material.BEDROCK) {
                block.setType(Material.AIR);
            }
        }

    }

}