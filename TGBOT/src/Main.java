import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //String botToken = "7584434037:AAFk0dJk79a5R8Unqn42x1zeG9LD5qh0Aus";
        //try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
        //    botsApplication.registerBot(botToken, new TGAPI(botToken));
        //    System.out.println("YellowCookBot successfully started!");
        //    Thread.currentThread().join();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        WebScraper ws = new WebScraper();
        List<Recipe> list = ws.scrape();
        for (Recipe r : list) {
            System.out.println(r.toString());
        }
    }
}
