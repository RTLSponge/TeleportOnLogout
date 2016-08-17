package au.id.rleach.teleportonlogout;

import com.google.inject.Inject;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandMapping;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.service.permission.PermissionService;
import org.spongepowered.api.world.storage.WorldProperties;

import java.nio.file.Path;
import java.util.Optional;

@Plugin( id = au.id.rleach.teleportonlogout.Plugin.ID,
         name = au.id.rleach.teleportonlogout.Plugin.NAME,
         version = au.id.rleach.teleportonlogout.Plugin.VERSION,
         description = au.id.rleach.teleportonlogout.Plugin.DESCRIPTION
)
public class TeleportOnLogout {
    @Listener
    public void teleportOnLogout(final ClientConnectionEvent.Disconnect disconnect) {
        final Player player = disconnect.getTargetEntity();
        final Server server = Sponge.getGame().getServer();
        final Optional<WorldProperties> defaultWorldOpt = server.getDefaultWorld();
        defaultWorldOpt.ifPresent(
                defaultWorld -> {
                    player.transferToWorld(defaultWorld.getUniqueId(), defaultWorld.getSpawnPosition().toDouble());
                }
        );
    }
}
