package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.concurrent.ExecutionException;

public class message extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        //Prefix
        String Prefix = Main.prefix;

        //Info
        User userTab = event.getAuthor();
        MessageChannel channelTab = event.getChannel();
        Guild guildTab = event.getGuild();

        //Id
        String guildEvent = guildTab.getId();
        String userEvent = userTab.getId();

        //log
        System.out.println(guildTab.getName() + " / " + channelTab.getName() + " / " + userTab.getAsTag() + " ----> " + event.getMessage().getContentRaw());

        //Unique
        String guildTyro = "772171741782343690";
        String guildTeamsDev = "865160943498297356";
        String userPapa = "363366883652796416";
        String userRayqua = "384436295717617665";
        String userChristophe = "781509903718023208";
        String userJessica = "424805452115869697";
        String userDelphine = "686563121778917484";
        String userPeter = "775071990985523210";

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
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "ping")) {
            event.getChannel().sendMessage("Pong ??? je suis en dev, je sais pas encore faire").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "moi")) {
            event.getChannel().sendMessage("tu est ``" + userTab.getAsTag() + "``").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "chan")) {
            event.getChannel().sendMessage("tu est dans le channel ``" + channelTab.getName() + "``").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "serv")) {
            event.getChannel().sendMessage("tu est dans le serveur ``" + guildTab.getName() + "``").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "countserv")) {
            event.getChannel().sendMessage("il y a ``" + guildTab.getMemberCount() + "`` personnes dans ``" + guildTab.getName() + "``").queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "debug")) {
            event.getChannel().sendMessage(guildTab + " / " + channelTab + " / " + userTab).queue();
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
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
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains("vive tyrolium")) {
                event.getChannel().sendMessage("TYROLIUM EST LA MEILLEURE ENTREPRISE, *c'est aussi mon papa*").queue();
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }
        }

        //Uniquement Moi
        if (userEvent.equals(userPapa)){
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "admin")) {
                event.getChannel().sendMessage("tu a bien les perms pour cette commande ``" + userTab.getAsTag() + "``").queue();
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }

            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "presente")) {
                event.getChannel().sendMessage("Bonjour, a tous je suis le TyroBot, et je suis pres a vous aidez sur votre serveur donc oui moi je suis public certain commande seront exclusif a ce serveur, bete si pouvez accedez a des commande de pub de tyro, et sinon j'ai un petit frere TyroServBot, je vais le laissez ce presenter").queue();
                event.getChannel().sendMessage("ts!presente").queue();
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
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
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }
        }


        //Uniquement sur le TeamsDevelopper ou Tyrolium
        if (guildEvent.equals(guildTyro) || guildEvent.equals(guildTeamsDev)) {
            if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "github")) {
                String cmd = event.getMessage().getContentRaw();
                try {
                    String result = cmd.substring(9);

                    String userPapaA = "<@!" + userPapa + ">";
                    if (userPapaA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/TheMaxium69").queue();
                    }

                    String userRayquaA = "<@!" + userRayqua + ">";
                    if (userRayquaA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/Rayquamusium").queue();
                    }

                    String userChristopheA = "<@!" + userChristophe + ">";
                    if (userChristopheA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/christophe-mabilon").queue();
                    }

                    String userJessicaA = "<@!" + userJessica + ">";
                    if (userJessicaA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/JessicaVF").queue();
                    }

                    String userDelphineA = "<@!" + userDelphine + ">";
                    if (userDelphineA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/delphine38").queue();
                    }

                    String userPeterA = "<@!" + userPeter + ">";
                    if (userPeterA.equals(result)) {
                        event.getChannel().sendMessage("https://github.com/johndrake31").queue();
                    }

                    if ("Tyrolium".equals(result) || "tyrolium".equals(result) || "tyro".equals(result) || "Tyro".equals(result)) {
                        event.getChannel().sendMessage("https://github.com/tyrolium").queue();
                    }

                } catch (StringIndexOutOfBoundsException e) {
                    event.getChannel().sendMessage("https://github.com/tyrolium").queue();
                }
                System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
            }
        }







        //Test
        if (event.getMessage().getContentRaw().toLowerCase().contains(Prefix + "embed")) {
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
            System.out.println(guildTab.getName() + " / " + channelTab.getName() + " <Requette Effectuez>");
        }

    }
}
