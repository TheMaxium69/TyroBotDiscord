package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.xml.soap.Text;
import java.io.*;

public class app {

    public static Boolean System(String date, String guildName, MessageChannel channel, String userTag, String msgRaw, MessageReceivedEvent event, String prefix){
        String Line = date + " | " + guildName + " / " + channel.getName();
        String Linelog = " / " + userTag + " ----> " + msgRaw;
        String LineChan = date + " | __" + guildName + "__ / " + channel.getName() + " / **" + userTag + "** ----> *" + msgRaw + "*";

        Boolean isLog = false;
        TextChannel logChannel = event.getJDA().getTextChannelById(stock.logChannel);
        if (channel == logChannel){
            isLog = true;
        }

        if (!isLog) {
            Log(Line + Linelog, LineChan, logChannel);
            if (Main.APP_ENV == "PROD") {
                File(Line + Linelog, stock.path + stock.pathLog);
            } else if (Main.APP_ENV == "DEV") {
                File(Line + Linelog, stock.pathDev + stock.pathLog);
            }
        }
        Boolean isCmd = MessagePrefix(Line + " <Requette Effectuez>", Line + Linelog, msgRaw, prefix, isLog);
        return isCmd;
    }

    public static void Log(String Linelog, String LineChan, TextChannel logChannel){
        System.out.println(Linelog);
        sendLog(logChannel, LineChan);
    }

    public static void File(String Log, String path){
        PrintWriter out = null;
        final File file = new File(path);

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(Log);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean MessagePrefix(String LineRequest, String LineLog, String msgRaw, String prefix, Boolean islog){
        try {
            String cmd = msgRaw.substring(0, 2);

            if (cmd.toLowerCase().equals(prefix)){
                System.out.println(LineRequest);
                if (Main.APP_ENV == "PROD") {
                    File(LineLog, stock.path + stock.pathResquest);
                    File(LineRequest, stock.path + stock.pathResquest);
                } else if (Main.APP_ENV == "DEV") {
                    File(LineLog, stock.pathDev + stock.pathResquest);
                    File(LineRequest, stock.pathDev + stock.pathResquest);
                }
                return true;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return false;
    }

    public static void send(MessageChannel channel, String message){
        channel.sendMessage(message).queue();
        if (Main.APP_ENV == "PROD"){
            File("return : " + message, stock.path + stock.pathResquest);
        }else if (Main.APP_ENV == "DEV"){
            File("return : " + message, stock.pathDev + stock.pathResquest);
        }
    }
    public static void sendLog(MessageChannel channel, String message){
        channel.sendMessage(message).queue();
    }

    public static void sendEmbed(MessageChannel channel, MessageEmbed message){
        channel.sendMessage(message).queue();
        if (Main.APP_ENV == "PROD"){
            File("return : <EMBED>", stock.path + stock.pathResquest);
        }else if (Main.APP_ENV == "DEV"){
            File("return : <EMBED>", stock.pathDev + stock.pathResquest);
        }
    }

    public static void sendPing(MessageChannel channel, Long time){
        channel.sendMessage(stock.emojiLoading).queue(response -> { response.editMessageFormat("Votre ping est de : %d ms", System.currentTimeMillis() - time).queue(); });
        if (Main.APP_ENV == "PROD"){
            File("return : <PING>", stock.path + stock.pathResquest);
        }else if (Main.APP_ENV == "DEV"){
            File("return : <PING>", stock.pathDev + stock.pathResquest);
        }

    }
}
