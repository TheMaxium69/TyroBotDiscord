package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class notprefix {
    public static void init(String eventMsg, MessageChannel channel, User user, Guild guild){

        /*vive tyrolium*/
        if (eventMsg.equals("vive tyrolium") && guild.getId().equals(stock.guildTyro)){ vt(channel); }

    }

    public static void vt(MessageChannel channel){
        String message = "TYROLIUM EST LA MEILLEURE ENTREPRISE, *c'est aussi mon papa*";
        app.send(channel, message);
    }
}
