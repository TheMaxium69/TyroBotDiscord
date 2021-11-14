package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class Main {

    // PROD or DEV
    public static String APP_ENV = "PROD";

    public static void main(String[] argv) throws LoginException {
        System.out.println("BOT = Initialization");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(argv[0]);
        builder.addEventListeners(new message());
        if (APP_ENV == "PROD") {
            builder.setActivity(Activity.playing(stock.playing));
        } else if (APP_ENV == "DEV"){
            builder.setActivity(Activity.playing(stock.playingDev));
        }
        builder.build();
        System.out.println("BOT = Ready");
    }
}
