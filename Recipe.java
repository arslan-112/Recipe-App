import java.io.Serializable;

public abstract class Recipe implements Serializable{
    protected String name;
    protected String ingredients;
    protected String instructions;
    protected Chef chef;

    public Recipe(String name, String ingredients, String instructions,Chef chef) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.chef = chef;
        chef.setRecipe(this);
    }
    public abstract String getRecipeType();
    
    public String getName() {
        return this.name;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public Chef getChef(){
        return this.chef;
    }

    public String toString(){
        return "Recipe: " + name + "\nIngredients: " + ingredients+"\nInstructions: " + getInstructions()  +"\nChef: " + chef.getName();
    }
}
