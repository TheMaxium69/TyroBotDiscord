package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;

public class admin {
    public static void Admin(MessageChannel channel, String userTag){
        String message = "tu a bien les perms pour cette commande ``" + userTag + "``";
        app.send(channel, message);
    }
}
