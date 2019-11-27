package dk.hoggins.healthgraph.listeners;

import dk.hoggins.healthgraph.HealthGraph;
import dk.hoggins.healthgraph.runnables.HealthCheckRunnable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class DamageListener implements Listener {


    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){
        System.out.println("[HealthGraph]: Entity damage event");

        //If the entity is not a player, just return.
        if(!(event.getEntity() instanceof Player)){
            return;
        }
        Player p = (Player) event.getEntity();
        String healthString = String.valueOf(p.getHealth());
        p.sendMessage(healthString);
        BukkitTask task = new HealthCheckRunnable(p).runTaskLater(HealthGraph.plugin, 20);
        if(p.getHealth() <= 10){
            p.setHealth(20);
            p.sendMessage("You have been healed");
        }
    }
}
