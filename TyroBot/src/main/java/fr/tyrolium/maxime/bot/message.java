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

        String eventMsg = event.getMessage().getContentRaw();
        MessageChannel eventChannel = event.getChannel();
        Guild eventGuild = event.getGuild();
        User eventUser = event.getAuthor();
        String eventDate = new SimpleDateFormat("dd/MM HH:mm").format(Calendar.getInstance().getTime());

        Boolean isCmd = app.System(eventDate, eventGuild.getName(), eventChannel.getName(), eventUser.getAsTag(), eventMsg);
        if (isCmd) { command.init(eventMsg.toLowerCase().substring(2), eventChannel, eventUser, eventGuild); }
        else { notprefix.init(eventMsg.toLowerCase(), eventChannel, eventUser, eventGuild); }


        /*


        //Uniquement dans tyro
        if (guildEvent.equals(guildTyro)){
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "instagram")) {
                String cmd = event.getMessage().getContentRaw();
                try {
                    String result = cmd.substring(12);

                    String userPapaA = "<@!" + userPapa + ">";
                    if (userPapaA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/TheMaxium69").queue();
                    }

                    String userRayquaA = "<@!" + userRayqua + ">";
                    if (userRayquaA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/Rayquamusium").queue();
                    }

                    result = result.toLowerCase();

                    if ("tyrolium".equals(result) || "tyro".equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://www.instagram.com/tyroliumentertainment/").queue();
                    }

                } catch (StringIndexOutOfBoundsException e) {
                    event.getChannel().sendMessage(emojiGithub+"https://www.instagram.com/tyroliumentertainment/").queue();
                }
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "<@!" + userRayqua +">")||event.getMessage().getContentRaw().toLowerCase().contains(Prefix + " <@!" + userRayqua +">")) {
                event.getChannel().sendMessage("Un bon gars").queue();
            }
        }

        //Uniquement Moi
        if (userEvent.equals(userPapa)){
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "admin")) {
                event.getChannel().sendMessage("tu a bien les perms pour cette commande ``" + userTab.getAsTag() + "``").queue();
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "presente")) {
                event.getChannel().sendMessage("Bonjour, a tous je suis le TyroBot, et je suis pres a vous aidez sur votre serveur donc oui moi je suis public certain commande seront exclusif a ce serveur, bete si pouvez accedez a des commande de pub de tyro, et sinon j'ai un petit frere TyroServBot, je vais le laissez ce presenter").queue();
                event.getChannel().sendMessage("ts!presente").queue();
            }


            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "console")) {
                channelTab.deleteMessageById(msgEvent).queue();

                System.out.println("Tape ton message :");
                String resultMsg = saisieUtilisateur.nextLine();

                System.out.println("Met l'id du tchat :");
                String resultId = saisieUtilisateur.nextLine();

                TextChannel txtChannel = event.getJDA().getTextChannelById(resultId);

                if (txtChannel.canTalk()) {
                    txtChannel.sendMessage(resultMsg).queue();
                }
            }
        }

        //Uniquement TeamsDevelopper
        if(guildEvent.equals(guildTeamsDev)){

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "<@!" + userChristophe +">")||event.getMessage().getContentRaw().toLowerCase().contains(Prefix + " <@!" + userChristophe +">")) {
                event.getChannel().sendMessage("Un gars qui insulte les bots, je pense quil est botophobe").queue();
            }
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "<@!" + userJessica +">")||event.getMessage().getContentRaw().toLowerCase().contains(Prefix + " <@!" + userJessica +">")) {
                event.getChannel().sendMessage("Une gentille personne, mais elle essaye de prendre la premiere place de mon papa").queue();
            }
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "<@!" + userPeter +">")||event.getMessage().getContentRaw().toLowerCase().contains(Prefix + " <@!" + userPeter +">")) {
                event.getChannel().sendMessage("Une personne très sympatique, mais trop Americain et mon papa est nul en anglais").queue();
            }
        }












        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "test")) {

            System.out.println("L'id du tchat :");
            String resultTchatId = saisieUtilisateur.nextLine();

            System.out.println("Le nombre de msg:");
            int resultMsgNb = saisieUtilisateur.nextInt();

            TextChannel histChannel = event.getJDA().getTextChannelById(resultTchatId);

            MessageHistory history = new MessageHistory(histChannel);

            List<Message> msgHist;

            msgHist = history.retrievePast(resultMsgNb).complete();

            final String cheminHist = "/home/maxime/.bot/.robert";
            final File fichierHist = new File(cheminHist);
            try {

                try {

                    out = new PrintWriter(new BufferedWriter(new FileWriter(fichierHist, true)));
                    out.println("# " + histChannel.getName() + " - " + Date + " $" + histChannel.getId());
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
        }*/
    }

}
