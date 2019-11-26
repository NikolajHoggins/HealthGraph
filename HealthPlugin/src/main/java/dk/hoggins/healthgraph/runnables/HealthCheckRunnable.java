package dk.hoggins.healthgraph.runnables;

import com.google.common.net.HttpHeaders;
import dk.hoggins.healthgraph.HealthGraph;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HealthCheckRunnable extends BukkitRunnable {
    @Override
    public void run() {
        Plugin plugin = HealthGraph.plugin;
        Player[] players = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        for (Player player : players)
        {
            player.sendMessage(player.getName()+": "+player.getHealth()+"HP");
        }

        plugin.getServer().broadcastMessage("Yolo Bitch");
    }


    public static String sendGet(String urlString) {
        String stuff = null;
        try {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = in.readLine();
            in.close();
            if (str != null) {
                stuff = str;
            }
        }
        catch (java.io.IOException e1) {
            stuff = e1.getMessage();
        }
        return stuff;
    }
}
