package fr.tyrolium.maxime.bot.cmd;

import fr.tyrolium.maxime.bot.Main;
import fr.tyrolium.maxime.bot.app;
import fr.tyrolium.maxime.bot.stock;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class admin {
    public static void Admin(MessageChannel channel, String userTag){
        String message = "tu a bien les perms pour cette commande ``" + userTag + "``";
        app.send(channel, message);
    }

    public static void Console(MessageChannel channel, Message messageRaw){
        channel.deleteMessageById(messageRaw.getId()).queue();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tape ton message :");
        String resultMsg = scanner.nextLine();

            app.send(channel, resultMsg);
    }

    public static void Sniff(MessageReceivedEvent event, String eventDate,MessageChannel messageChannel, Message messageRaw){
        messageChannel.deleteMessageById(messageRaw.getId()).queue();

        Scanner scanner = new Scanner(System.in);

        System.out.println("L'id du tchat :");
        String resultTchatId = scanner.nextLine();

        System.out.println("Le nombre de msg:");
        int resultMsgNb = scanner.nextInt();

        TextChannel histChannel = event.getJDA().getTextChannelById(resultTchatId);
        TextChannel chanLog = event.getJDA().getTextChannelById(stock.logChannel);

        MessageHistory history = new MessageHistory(histChannel);

        List<Message> msgHist;

        msgHist = history.retrievePast(resultMsgNb).complete();


        PrintWriter out = null;
        String path = null;
        if (Main.APP_ENV == "PROD"){
            path = stock.path;
        }else if (Main.APP_ENV == "DEV"){
            path = stock.pathDev;
        }
        final String cheminHist = path + "/channel/" + histChannel.getId() + ".log";
        final File fichierHist = new File(cheminHist);
        try {

            try {

                app.sendLog(chanLog, "##########################################################");
                app.sendLog(chanLog, "# " + histChannel.getGuild().getName() + " | " + histChannel.getName() + " - " + eventDate + " $" + histChannel.getId());
                out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                out.println("# " + histChannel.getGuild().getName() + " | " + histChannel.getName() + " - " + eventDate + " $" + histChannel.getId());
                out.close();

                int nbMsg = 0;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
                for( Message oneMsg : msgHist ) {
                    nbMsg = nbMsg + 1;
                    String msgStock = nbMsg + "| " + oneMsg.getTimeCreated().format(formatter) + " > " + oneMsg.getAuthor().getName() + " ----> " + oneMsg.getContentRaw();

                    app.sendLog(chanLog, "``" + nbMsg + "``| " + oneMsg.getTimeCreated().format(formatter) + " > **" + oneMsg.getAuthor().getName() + "** ----> *" + oneMsg.getContentRaw()+ "*");
                    out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                    out.println(msgStock);
                    out.close();

                }
                app.sendLog(chanLog, "##########################################################");
                out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                out.println("##########################################################");
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }


    }
}
