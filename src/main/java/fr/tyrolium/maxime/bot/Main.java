package fr.tyrolium.maxime.bot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] argv) throws LoginException {
        System.out.println("BOT = Initialization");
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(argv[0]);
        builder.addEventListeners(new message());
        builder.setActivity(Activity.playing(stock.playing));
        builder.build();
        System.out.println("BOT = Ready");
    }

    public static String get(String url) throws IOException {
        String source ="";
        URL oracle = new URL(url);
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            source +=inputLine;
        in.close();
        return source;
    }
}
