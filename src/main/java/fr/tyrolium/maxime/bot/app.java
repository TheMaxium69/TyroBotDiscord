package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.io.*;

public class app {

    public static Boolean System(String date, String guildName, String channelName, String userTag, String msgRaw){
        String Line = date + " | " + guildName + " / " + channelName;
        String Linelog = " / " + userTag + " ----> " + msgRaw;

        Log(Line + Linelog);
        File(Line + Linelog, stock.path + stock.pathLog);
        Boolean isCmd = MessagePrefix(Line + " <Requette Effectuez>", Line + Linelog, msgRaw);
        return isCmd;
    }

    public static void Log(String Linelog){
        System.out.println(Linelog);
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

    public static boolean MessagePrefix(String LineRequest, String LineLog, String msgRaw){
        try {
            String cmd = msgRaw.substring(0, 2);

            if (cmd.toLowerCase().equals(stock.prefix)){
                System.out.println(LineRequest);
                File(LineLog, stock.path + stock.pathResquest);
                File(LineRequest, stock.path + stock.pathResquest);
                return true;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return false;
    }

    public static void send(MessageChannel channel, String message){
        channel.sendMessage(message).queue();
        File("return : " + message, stock.path + stock.pathResquest);
    }

    public static void sendEmbed(MessageChannel channel, MessageEmbed message){
        channel.sendMessage(message).queue();
        File("return : <EMBED>", stock.path + stock.pathResquest);
    }

    public static void sendPing(MessageChannel channel, Long time){
        channel.sendMessage(stock.emojiLoading).queue(response -> { response.editMessageFormat("Votre ping est de : %d ms", System.currentTimeMillis() - time).queue(); });
        File("return : <PING>", stock.path + stock.pathResquest);

    }
}
