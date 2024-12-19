import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {
    private static String BASE_url;
    private static String CATEGORY_url;

    public WebScraper(){
        BASE_url = "https://www.giallozafferano.it";
        CATEGORY_url = "/ricette-cat/page";
    }

    public List<Recipe> scrape() throws IOException{
        List<Recipe> allRecipes = new ArrayList<>();
        int page = 1;
        int id = 1;
        String pageurl = BASE_url + "/ricette-cat/";

        Document doc = Jsoup.connect(pageurl).get();
        Elements recipelinks = doc.select(".gz-title a");

        for (Element link : recipelinks){
            String url = BASE_url + link.attr("href");
            Recipe recipe = scrapeRecipeDetails(url);
            if(recipe != null)
                allRecipes.add(recipe);
        }

        return allRecipes;
    }

    private Recipe scrapeRecipeDetails(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();

        String name = doc.select("gz.title-recipe").text();
        if (name.isEmpty())
            name = "Titolo non disponibile";

        Elements elements = doc.select("gz-breadcrumb span");
        String category = elements.isEmpty() ? "Categoria non disponibile" :
    }

    private static Recipe recipeDetails(int id, String url) throws IOException{
        Document doc = Jsoup.connect(BASE_url).get();

        String name = doc.select(".gz-title-recipe").text();
        String category = doc.select(".gz-breadcrumb span").last().text();
        String duration = doc.select(".gz-time").text();
        String preparation = doc.select(".gz-content-recipe").text();

        return new Recipe(id, name, category, duration, preparation);
    }

}
