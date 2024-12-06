import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebScraper ws = new WebScraper();
        try{
            List<Recipe> recipes = ws.scrape();
            recipes.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
