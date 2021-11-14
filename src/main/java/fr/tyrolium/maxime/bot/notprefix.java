package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class notprefix {
    public static void init(String eventMsg, MessageChannel channel, User user, Guild guild, MessageReceivedEvent event){

        /*vive tyrolium*/
        if (eventMsg.equals("vive tyrolium") && guild.getId().equals(stock.guildTyro)){ vt(channel); }

        if (eventMsg.equals("je t'aime") && user.getId().equals(stock.userPapa)){ jtm(channel); }

        if (eventMsg.equals("``serveur offline``") && user.getId().equals(stock.userFrere)){ online(event); }

    }

    public static void vt(MessageChannel channel){
        String message = "TYROLIUM EST LA MEILLEURE ENTREPRISE, *c'est aussi mon papa*";
        app.send(channel, message);
    }

    public static void jtm(MessageChannel channel){
        String msg = ":heart:";
        app.send(channel, msg);
    }

    public static void online(MessageReceivedEvent event){
        String msg = "<@!363366883652796416> verifie le serveur s'il te plait";
        TextChannel chanAlert = event.getJDA().getTextChannelById(stock.alertChannel);

        app.send(chanAlert, msg);
    }
}
