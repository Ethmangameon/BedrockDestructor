package com.chownnick.bedrockDestructor;

import org.bukkit.plugin.java.JavaPlugin;
import com.chownnick.bedrockDestructor.Listener.TNTListener;

public final class BedrockDestructor extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new TNTListener(), this);

        getLogger().info("BedrockDestructor has been successfully enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BedrockDestructor has been disabled!");
    }
}
