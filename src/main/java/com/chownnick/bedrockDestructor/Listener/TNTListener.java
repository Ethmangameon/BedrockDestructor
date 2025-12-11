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
        //Get the Entity for the Exploding TNT
        final Entity explodingTNT = event.getEntity();

        //Check if Entity is TNT
        if (explodingTNT.getType() != EntityType.TNT) {return;}

        //Get the World of the Exploding TNT
        @NotNull World world = explodingTNT.getWorld();

        //Location of TNT
        Location loc = explodingTNT.getLocation();

        //Block of tnt and relative blocks
        Block Block = world.getBlockAt(loc);
        Block North = Block.getRelative(BlockFace.NORTH, 1);
        Block East = Block.getRelative(BlockFace.EAST, 1);
        Block South = Block.getRelative(BlockFace.SOUTH, 1);
        Block West = Block.getRelative(BlockFace.WEST, 1);
        Block Up = Block.getRelative(BlockFace.UP, 1);
        Block Down = Block.getRelative(BlockFace.DOWN, 1);

        //Checks the relative blocks of TNT and sets them to AIR
        if (Block.getType() == Material.BEDROCK) {Block.setType(Material.AIR);};
        if (North.getType() == Material.BEDROCK) {North.setType(Material.AIR);};
        if (East.getType() == Material.BEDROCK) {East.setType(Material.AIR);};
        if (South.getType() == Material.BEDROCK) {South.setType(Material.AIR);};
        if (West.getType() == Material.BEDROCK) {West.setType(Material.AIR);};
        if (Up.getType() == Material.BEDROCK) {Up.setType(Material.AIR);};
        if (Down.getType() == Material.BEDROCK) {Down.setType(Material.AIR);};

    }

}
