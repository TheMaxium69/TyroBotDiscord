package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class debug
{
    public static void Debug(MessageChannel chanelEvent, String guildName, String userTag){
        String message = guildName + " / " + chanelEvent.getName() + " / " + userTag;
        app.send(chanelEvent, message);
    }

    public static void Moi(MessageChannel chanelEvent, String userTag){
        String message = "tu est ``" + userTag + "``";
        app.send(chanelEvent, message);
    }

    public static void Channel(MessageChannel chanelEvent){
        String message = "tu est dans le serveur  ``" + chanelEvent.getName() + "``";
        app.send(chanelEvent, message);
    }

    public static void Serv(MessageChannel chanelEvent, Guild guildEvent, Boolean isCount){
        String message = null;
        if (isCount){
            message = "il y a ``" + guildEvent.getMemberCount() + "`` personnes dans ``" + guildEvent.getName() + "``";
        }else {
            message = "tu est dans le serveur : ``" + guildEvent.getName() + "``";
        }
        app.send(chanelEvent, message);
    }
}
