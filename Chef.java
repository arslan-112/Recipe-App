import java.io.Serializable;

public class Chef implements Serializable{
    private String name;
    private Recipe recipe;

    public Chef(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }
    public Recipe getRecipe(){
        return this.recipe;
    }

    @Override
    public String toString() {
        return "Chef Name = "+ name + "\nRecipe Details:"+
        recipe.toString();
    }
}
