package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;

public class debug
{
    public static void Moi(MessageChannel chanelEvent, String userTag){
        String message = "tu est ``" + userTag + "``";
        app.send(chanelEvent, message);
    }
}
