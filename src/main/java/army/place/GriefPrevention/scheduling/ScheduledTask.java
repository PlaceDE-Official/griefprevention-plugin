package army.place.GriefPrevention.scheduling;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface ScheduledTask {
    void cancel();

    boolean isCancelled();

    @NotNull Plugin getOwningPlugin();

    boolean isCurrentlyRunning();

    boolean isRepeatingTask();

}