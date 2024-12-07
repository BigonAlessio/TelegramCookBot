import java.util.ArrayList;
import java.util.List;

public class User {
    public String username;
    private String password;
    public List<Recipe> favourites;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.favourites = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Recipe> favourites) {
        this.favourites = favourites;
    }
}
