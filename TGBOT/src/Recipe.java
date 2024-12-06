public class Recipe {
    private int id;
    private String name;
    private String category;
    private String duration;
    private String preparation;

    public Recipe (int id, String name, String category, String duration, String preparation){
        this.id = id;
        this.name = name;
        this.category = category;
        this.duration = duration;
        this.preparation = preparation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", duration='" + duration + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
