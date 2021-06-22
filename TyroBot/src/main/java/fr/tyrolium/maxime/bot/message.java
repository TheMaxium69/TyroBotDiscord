package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class message extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        User userTab = event.getAuthor();
        MessageChannel channelTab = event.getChannel();
        Guild guildTab = event.getGuild();
        System.out.println(guildTab.getName() + " / " + channelTab.getName() + " / " + userTab.getAsTag() + " ----> " + event.getMessage().getContentRaw());

        if (event.getMessage().getContentRaw().toLowerCase().contains("vive tyrolium")) {
            event.getChannel().sendMessage("TYROLIUM EST LA MEILLEUR ENTREPRISE *cest aussi mon papa*").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Main.Prefix + "help")) {
            event.getChannel().sendMessage("hum ya pas grand chose dans le bot pour linstant je suis en dev").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }


        if (event.getMessage().getContentRaw().toLowerCase().contains(Main.Prefix + "ping")) {
            event.getChannel().sendMessage("Pong ??? je suis en dev je sais pas encore faire").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

    }
}
