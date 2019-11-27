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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HealthCheckRunnable extends BukkitRunnable {
    static Player p;
    public HealthCheckRunnable(Player p) {
        this.p = p;
    }

    @Override
    public void run() {
        Plugin plugin = HealthGraph.plugin;
        p.sendMessage(p.getName()+": "+p.getHealth()+"HP");
        String[] response = sendGet("https://jsonplaceholder.typicode.com/posts/1");
        for (String reponseLine: response) {
            plugin.getServer().broadcastMessage(reponseLine);
        }
        plugin.getServer().broadcastMessage("Yolo Bitch");
    }


    public static String[] sendGet(String urlString) {

        String[] arr = {};
        List<String> arrlist = new ArrayList<String>(Arrays.asList(arr));

        // Add the new element


        try {
            URL url = new URL(urlString);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            int i = 0;
            while ((line = buffer.readLine()) != null) {
                arrlist.add(line);
            }
            buffer.close();

        }
        catch (java.io.IOException e1) {
            arrlist.add(e1.getMessage());
        }

        // Convert the Arraylist to array
        arr = arrlist.toArray(arr);

        // return the array
        return arr;
    }
}
