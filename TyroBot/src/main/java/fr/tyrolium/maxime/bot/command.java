package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class command {
    public static void init(String request, MessageChannel channel, User user){

        /*p!moi*/
        if (request.contains(Main.prefix + "Moi")){ debug.Moi(channel, user.getAsTag()); }
        

    }
}
