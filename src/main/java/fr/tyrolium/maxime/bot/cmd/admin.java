package fr.tyrolium.maxime.bot.cmd;

import fr.tyrolium.maxime.bot.app;
import fr.tyrolium.maxime.bot.stock;
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

            app.send(channel, resultMsg);
    }
}
