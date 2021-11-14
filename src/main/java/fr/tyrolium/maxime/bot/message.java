package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.annotation.Nonnull;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class message extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        Message eventMsg = event.getMessage();
        MessageChannel eventChannel = event.getChannel();
        Guild eventGuild = event.getGuild();
        User eventUser = event.getAuthor();
        String eventDate = new SimpleDateFormat("dd/MM HH:mm").format(Calendar.getInstance().getTime());
        String prefix = null;
        String path = null;
        if (Main.APP_ENV == "PROD"){
            prefix = stock.prefix;
            path = stock.path;
        }else if (Main.APP_ENV == "DEV"){
            prefix = stock.prefixDev;
            path = stock.pathDev;
        }

        Boolean isCmd = app.System(eventDate, eventGuild.getName(), eventChannel, eventUser.getAsTag(), eventMsg.getContentRaw(), event, prefix);
        if (isCmd) { command.init(eventMsg.getContentRaw().toLowerCase().substring(2), eventChannel, eventUser, eventGuild, eventMsg, event, eventDate); }
        else { notprefix.init(eventMsg.getContentRaw().toLowerCase(), eventChannel, eventUser, eventGuild, event); }
    }

}
