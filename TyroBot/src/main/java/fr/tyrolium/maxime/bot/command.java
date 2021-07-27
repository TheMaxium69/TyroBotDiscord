package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;

public class command {
    public static void init(String request, MessageChannel channel, User user, Guild guild, Message messageRaw, MessageReceivedEvent event){

        /*help*/
        if (request.contains("help")){ Help(channel, guild); }

        /*ping*/
        if (request.contains("ping")){ Ping(channel); }



        /*debug*/
        if (request.contains("debug")){ debug.Debug(channel, guild.getName() ,user.getAsTag()); }

        /*moi*/
        if (request.contains("moi")){ debug.Moi(channel, user.getAsTag()); }

        /*chan*/
        if (request.contains("chan")){ debug.Channel(channel); }

        /*serv*/
        if (request.contains("serv")){ debug.Serv(channel, guild, false); }

        /*countserv*/
        if (request.contains("count")){ debug.Serv(channel, guild, true); }



        /*github*/
        if (request.contains("github") && guild.getId().equals(stock.guildTyro) || guild.getId().equals(stock.guildTeamsDev)){ reseaux.Github(request, channel); }

        /*admin*/
        if (request.contains("admin") && user.getId().equals(stock.userPapa)){ admin.Admin(channel, user.getAsTag()); }

        /*console*/
        if (request.contains("console") && user.getId().equals(stock.userPapa)){ admin.Console(channel, messageRaw, event); }
    }

    public static void Help(MessageChannel channel, Guild guild){

        String description = "-Classique\n" + "\n" + "[t!] help = cette commande \n" + "[t!] ping = la commade pour connaître son ping\n" + "[t!] countserv = la commade pour savoir le nombre de personne dans le serveur que tu est\n" + "\n" + "-Debug\n" + "\n" + "[t!] moi = (debug)la commade pour savoir qui tu est\n" + "[t!] chan = (debug)la commade pour savoir dans qu'elle channel tu est\n" + "[t!] serv = (debug)la commade pour savoir dans qu'elle serveur tu est\n" + "[t!] debug = (debug)pour voir le debug\n";

        if (guild.getId().equals(stock.guildTyro)){
            description = description + "\n" + "-Unique à " + guild.getName() + "\n" + "[t!] github = donne le github de tyro ou du staff\n";
        }
        if (guild.getId().equals(stock.guildTeamsDev)){
            description = description + "\n" + "-Unique à " + guild.getName() + "\n" + "[t!] github = donne le github des membre de " + guild.getName() + "\n";
        }

        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(8191);
        embed.setTitle("Commande Help");
        embed.setDescription(description);
        app.sendEmbed(channel ,embed.build());
    }


    public static void Ping(MessageChannel channel){
        long time = System.currentTimeMillis();
        app.sendPing(channel, time);
    }
}
