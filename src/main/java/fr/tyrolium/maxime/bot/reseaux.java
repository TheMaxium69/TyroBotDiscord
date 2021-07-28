package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.entities.MessageChannel;

public class reseaux {
    public static void Github(String eventMsg, MessageChannel channel){
            try {
                String result = eventMsg.substring(7);
                String message = null;

                String userPapaA = "<@!" + stock.userPapa + ">";
                if (userPapaA.equals(result)) {
                    message = "https://github.com/TheMaxium69";
                }

                String userRayquaA = "<@!" + stock.userRayqua + ">";
                if (userRayquaA.equals(result)) {
                    message = "https://github.com/Rayquamusium";
                }

                String userChristopheA = "<@!" + stock.userChristophe + ">";
                if (userChristopheA.equals(result)) {
                    message = "https://github.com/christophe-mabilon";
                }

                String userJessicaA = "<@!" + stock.userJessica + ">";
                if (userJessicaA.equals(result)) {
                    message = "https://github.com/JessicaVF";
                }

                String userDelphineA = "<@!" + stock.userDelphine + ">";
                if (userDelphineA.equals(result)) {
                    message = "https://github.com/delphine38";
                }

                String userPeterA = "<@!" + stock.userPeter + ">";
                if (userPeterA.equals(result)) {
                    message = "https://github.com/johndrake31";
                }

                if ("tyrolium".equals(result) || "tyro".equals(result)) {
                    message = "https://github.com/tyrolium";
                }
                app.send(channel, stock.emojiGithub+ " " +message);
            } catch (StringIndexOutOfBoundsException e) {
                String message = "https://github.com/tyrolium";
                app.send(channel, stock.emojiGithub+ " " +message);
            }
    }

}
