package me.aklusa.apiplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

public final class APIPlugin {


    public void Enable(String apikey) throws SQLException {


        ConnectionsClass connectionsClass = new ConnectionsClass();
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(this.getClass());
        String licensekey = plugin.getConfig().getString("license-key");
        plugin.saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(getIP());


        if ((!connectionsClass.isActivated(apikey, licensekey))) {
            Bukkit.getConsoleSender().sendMessage("[" + plugin.getName() + "] Invalid License. Please edit the license-key field in the config.yml");
            plugin.getPluginLoader().disablePlugin(plugin);
            plugin.getServer().getPort();

        } else {

        }

    }
    public static String getIP() {
        try {
            return new BufferedReader(new InputStreamReader(new URL("http://checkip.amazonaws.com").openStream())).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
