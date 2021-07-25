package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Main {

    public static void main(String[] argv) throws LoginException {
        System.out.println("Lancement");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(argv[0]);
        builder.addEventListeners(new message());
//        builder.setActivity(Activity.playing("tyrolium.fr | Prefix = t! | En Developpement"));
        builder.setActivity(Activity.playing("Dev le bot"));

        builder.build();

        System.out.println("Le bot est bien lance");

        while(){

        }
    }


//    public static String prefix = "t!";
    public static String prefix = "p!";

}
