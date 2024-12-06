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
        BASE_url = "www.giallozafferano.it";
        CATEGORY_url = "/ricette-cat/page";
    }

    public List<Recipe> scrape() throws IOException{
        List<Recipe> allRecipes = new ArrayList<>();
        int page = 1;
        int id = 1;
        String pageurl;

        while(true){
            if(page == 1)
                pageurl = BASE_url + "/ricette-cat/";
            else
                pageurl = BASE_url + CATEGORY_url + page + "/";

            List<Recipe> recipes = scrapeFromPage(pageurl, id);
            if(recipes.isEmpty())
                break;

            allRecipes.addAll(recipes);
            id += recipes.size();
            page++;
        }

        return allRecipes;
    }

    public List<Recipe> scrapeFromPage(String url, int sid) throws IOException {
        List<Recipe> result = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select(".gz-title a");

        int id = sid;
        for(Element link : links){
            String recipeurl = BASE_url + link.attr("href");
            result.add(recipeDetails(id++, recipeurl));
        }

        return result;
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
