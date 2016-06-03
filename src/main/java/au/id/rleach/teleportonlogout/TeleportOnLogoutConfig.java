package au.id.rleach.teleportonlogout;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class TeleportOnLogoutConfig {

    public static final TypeToken<TeleportOnLogoutConfig> TYPE = TypeToken.of(TeleportOnLogoutConfig.class);
}
