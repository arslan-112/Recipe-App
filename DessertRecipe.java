public class DessertRecipe extends Recipe {
    private String recipeType;
    private String cookTime;
    private String regionalSignificance;

    public DessertRecipe(String name, String ingredients, String instructions,String type, String TimeMinutes,String rS, Chef chef) {
        super(name, ingredients, instructions,chef);
        this.cookTime = TimeMinutes;
        this.recipeType = type;
        this.regionalSignificance = rS;
    }
    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public String getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getRegionalSignificance() {
        return this.regionalSignificance;
    }

    public void setRegionalSignificance(String regionalSignificance) {
        this.regionalSignificance = regionalSignificance;
    }

    
    public String getRecipeType(){
        return recipeType;
    }

    @Override
    public String toString() {
        return super.toString() +"\nRecipe Type: "+ recipeType+  "\nCook Time: " + getCookTime() + "\nRegional Significance: " + getRegionalSignificance();
    }
}

