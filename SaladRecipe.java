public class SaladRecipe extends Recipe {
    private String recipeType;
    private String duration;
    private String regionalSignificance;

    public SaladRecipe(String name, String ingredients, String instructions, String recipeType,String duration,String rS,Chef chef) {
        super(name, ingredients, instructions,chef);
        this.recipeType = recipeType;
        this.duration = duration;
        this.regionalSignificance = rS;
    }
    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        return super.toString() +"\nRecipe Type: "+ recipeType+  "\nCook Time: " + getDuration() + "\nRegional Significance: " + getRegionalSignificance();
    }
}
