package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class debug {
    public static void Moi(MessageChannel event, User userTab){
        event.sendMessage("tu est ``" + userTab.getAsTag() + "``").queue();
        System.out.println("FUNCTION");
    }
}
