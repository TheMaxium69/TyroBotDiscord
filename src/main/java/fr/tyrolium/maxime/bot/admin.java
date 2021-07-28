package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class admin {
    public static void Admin(MessageChannel channel, String userTag){
        String message = "tu a bien les perms pour cette commande ``" + userTag + "``";
        app.send(channel, message);
    }

    public static void Console(MessageChannel channel, Message messageRaw, MessageReceivedEvent event){
        channel.deleteMessageById(messageRaw.getId()).queue();

        System.out.println("Tape ton message :");
        String resultMsg = stock.scanner.nextLine();

        System.out.println("Met l'id du tchat :");
        String resultId = stock.scanner.nextLine();

        TextChannel txtChannel = event.getJDA().getTextChannelById(resultId);

        if (txtChannel.canTalk()) {
            app.send(txtChannel, resultMsg);
        }
    }
}
