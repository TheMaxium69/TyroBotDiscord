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

        Boolean isCmd = app.System(eventDate, eventGuild.getName(), eventChannel.getName(), eventUser.getAsTag(), eventMsg.getContentRaw());
        if (isCmd) { command.init(eventMsg.getContentRaw().toLowerCase().substring(2), eventChannel, eventUser, eventGuild, eventMsg, event); }
        else { notprefix.init(eventMsg.getContentRaw().toLowerCase(), eventChannel, eventUser, eventGuild); }

        if (event.getMessage().getContentRaw().toLowerCase().contains(stock.prefix + "get")) {
            String link = eventMsg.getContentRaw().toLowerCase().substring(6);
            System.out.println(link);
            String result = null;
            try {
                result = Main.get(link);
            } catch (IOException e) {
                e.printStackTrace();
            }
            eventChannel.sendMessage(result).queue();
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(stock.prefix + "hist") && eventUser.getId().equals(stock.userPapa)) {

            System.out.println("L'id du tchat :");
            String resultTchatId = stock.scanner.nextLine();

            System.out.println("Le nombre de msg:");
            int resultMsgNb = stock.scanner.nextInt();

            TextChannel histChannel = event.getJDA().getTextChannelById(resultTchatId);

            MessageHistory history = new MessageHistory(histChannel);

            List<Message> msgHist;

            msgHist = history.retrievePast(resultMsgNb).complete();


            PrintWriter out = null;
            final String cheminHist = "/home/maxime/.bot/.robert";
            final File fichierHist = new File(cheminHist);
            try {

                try {

                    out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                    out.println("# " + histChannel.getName() + " - " + eventDate + " $" + histChannel.getId());
                    out.close();

                    int nbMsg = 0;
                    for( Message oneMsg : msgHist ) {
                        nbMsg = nbMsg + 1;
                        String msgStock = nbMsg + "|"+ oneMsg.getAuthor().getName() + " ----> " + oneMsg.getContentRaw();

                        out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                        out.println(msgStock);
                        out.close();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Impossible de creer le fichier");
            }
        }
    }

}
