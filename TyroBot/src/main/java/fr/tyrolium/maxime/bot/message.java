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

        //Prefix
        String Prefix = Main.prefix;

        //Info
        Message msgTab = event.getMessage();
        MessageChannel channelTab = event.getChannel();
        Guild guildTab = event.getGuild();
        User userTab = event.getAuthor();

        //Id
        String guildEvent = guildTab.getId();
        String userEvent = userTab.getId();
        String msgEvent = msgTab.getId();


        Message eventMsg = event.getMessage();
        MessageChannel eventChannel = event.getChannel();
        Guild eventGuild = event.getGuild();
        User eventUser = event.getAuthor();
        String eventDate = new SimpleDateFormat("dd/MM HH:mm").format(Calendar.getInstance().getTime());



        //log
        Boolean isCmd = app.System(eventDate, eventGuild.getName(), eventChannel.getName(), eventUser.getAsTag(), eventMsg.getContentRaw());

        if (isCmd) {
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "moi")) {
                debug.Moi(channelTab, userTab.getAsTag());
            }
            command.init(event.getMessage().getContentRaw().toLowerCase(), eventChannel, eventUser);
        }

        /*//Saison Console
        Scanner saisieUtilisateur = new Scanner(System.in);


        //Guild
        String guildTyro = "772171741782343690";
        String guildTeamsDev = "865160943498297356";

        //User
        String userPapa = "363366883652796416";
        String userRayqua = "384436295717617665";
        String userChristophe = "781509903718023208";
        String userJessica = "424805452115869697";
        String userDelphine = "686563121778917484";
        String userPeter = "775071990985523210";

        //Emote
        String emojiGithub = "<:L_Github:858435836118564888>";
        String emojiLoading = "<a:H_Loading:858733554719522816>";

        if (!guildEvent.equals(guildTyro) && !guildEvent.equals(guildTeamsDev)) {
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "help")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(8191);
                embed.setTitle("Commande Help");
                embed.setDescription(
                        "-Classique\n" +
                                "\n" +
                                "[t!] help = cette commande \n" +
                                "[t!] ping = la commade pour connaître son ping\n" +
                                "[t!] countserv = la commade pour savoir le nombre de personne dans le serveur que tu est\n" +
                                "\n" +
                        "-Debug\n" +
                                "\n" +
                                "[t!] moi = (debug)la commade pour savoir qui tu est\n" +
                                "[t!] chan = (debug)la commade pour savoir dans qu'elle channel tu est\n" +
                                "[t!] serv = (debug)la commade pour savoir dans qu'elle serveur tu est\n" +
                                "[t!] debug = (debug)pour voir le debug\n"
                );
                event.getChannel().sendMessage(embed.build()).queue();
            }
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "ping")) {
            long time = System.currentTimeMillis();
            event.getChannel().sendMessage(emojiLoading).queue(response -> { response.editMessageFormat("Votre ping est de : %d ms", System.currentTimeMillis() - time).queue(); });
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "chan")) {
            event.getChannel().sendMessage("tu est dans le channel ``" + channelTab.getName() + "``").queue();
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "serv")) {
            event.getChannel().sendMessage("tu est dans le serveur ``" + guildTab.getName() + "``").queue();
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "countserv")) {
            event.getChannel().sendMessage("il y a ``" + guildTab.getMemberCount() + "`` personnes dans ``" + guildTab.getName() + "``").queue();
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "debug")) {
            event.getChannel().sendMessage(guildTab + " / " + channelTab + " / " + userTab).queue();
        }

        //Uniquement dans tyro
        if (guildEvent.equals(guildTyro)){
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "help")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(8191);
                embed.setTitle("Commande Help");
                embed.setDescription(
                        "-Classique\n" +
                                "\n" +
                                "[t!] help = cette commande \n" +
                                "[t!] ping = la commade pour connaître son ping\n" +
                                "[t!] countserv = la commade pour savoir le nombre de personne dans le serveur que tu est\n" +
                                "\n" +
                        "-Debug\n" +
                                "\n" +
                                "[t!] moi = (debug)la commade pour savoir qui tu est\n" +
                                "[t!] chan = (debug)la commade pour savoir dans qu'elle channel tu est\n" +
                                "[t!] serv = (debug)la commade pour savoir dans qu'elle serveur tu est\n" +
                                "[t!] debug = (debug)pour voir le debug\n" +
                                "\n" +
                        "-Unique à " + guildTab.getName() + "\n" +
                                "[t!] github = donne le github de tyro ou du staff\n"
                );
                event.getChannel().sendMessage(embed.build()).queue();
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains("vive tyrolium")) {
                event.getChannel().sendMessage("TYROLIUM EST LA MEILLEURE ENTREPRISE, *c'est aussi mon papa*").queue();
            }
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
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "help")) {
                EmbedBuilder embed = new EmbedBuilder();
                embed.setColor(8191);
                embed.setTitle("Commande Help");
                embed.setDescription(
                        "-Classique\n" +
                                "\n" +
                                "[t!] help = cette commande \n" +
                                "[t!] ping = la commade pour connaître son ping\n" +
                                "[t!] countserv = la commade pour savoir le nombre de personne dans le serveur que tu est\n" +
                                "\n" +
                        "-Debug\n" +
                                "\n" +
                                "[t!] moi = (debug)la commade pour savoir qui tu est\n" +
                                "[t!] chan = (debug)la commade pour savoir dans qu'elle channel tu est\n" +
                                "[t!] serv = (debug)la commade pour savoir dans qu'elle serveur tu est\n" +
                                "[t!] debug = (debug)pour voir le debug\n" +
                                "\n" +
                        "-Unique à " + guildTab.getName() + "\n" +
                                "[t!] github = donne le github des membre de " + guildTab.getName() + "\n"
                );
                event.getChannel().sendMessage(embed.build()).queue();
            }
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


        //Uniquement sur le TeamsDevelopper ou Tyrolium
        if (guildEvent.equals(guildTyro) || guildEvent.equals(guildTeamsDev)) {

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "<@!" + userPapa +">")) {
                event.getChannel().sendMessage("C'est le fondateur supreme").queue();
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "github")) {
                String cmd = event.getMessage().getContentRaw();
                try {
                    String result = cmd.substring(9);

                    String userPapaA = "<@!" + userPapa + ">";
                    if (userPapaA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/TheMaxium69").queue();
                    }

                    String userRayquaA = "<@!" + userRayqua + ">";
                    if (userRayquaA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/Rayquamusium").queue();
                    }

                    String userChristopheA = "<@!" + userChristophe + ">";
                    if (userChristopheA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/christophe-mabilon").queue();
                    }

                    String userJessicaA = "<@!" + userJessica + ">";
                    if (userJessicaA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/JessicaVF").queue();
                    }

                    String userDelphineA = "<@!" + userDelphine + ">";
                    if (userDelphineA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/delphine38").queue();
                    }

                    String userPeterA = "<@!" + userPeter + ">";
                    if (userPeterA.equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/johndrake31").queue();
                    }

                    if ("Tyrolium".equals(result) || "tyrolium".equals(result) || "tyro".equals(result) || "Tyro".equals(result)) {
                        event.getChannel().sendMessage(emojiGithub+"https://github.com/tyrolium").queue();
                    }

                } catch (StringIndexOutOfBoundsException e) {
                    event.getChannel().sendMessage(emojiGithub+"https://github.com/tyrolium").queue();
                }
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
