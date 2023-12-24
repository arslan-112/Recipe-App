public class AppetizerRecipe extends Recipe {
    private String recipeType;
    private String cookTime;
    private String regionalSignificance;

    public AppetizerRecipe(String name, String ingredients, String instructions, String recipeType,String cookTime,String rS,Chef chef) {
        super(name, ingredients, instructions,chef);
        this.recipeType = recipeType;
        this.cookTime = cookTime;
        this.regionalSignificance = rS;
    }

    public void setRegSignificance(String rS){
        this.regionalSignificance = rS;
    }
    public String getRegSignificance(){
        return this.regionalSignificance;
    }

    public String getcookTime(){
        return this.cookTime;
    }

    public void setCookTime(String cookTime){
        this.cookTime = cookTime;
    }
    
    public String getRecipeType(){
        return recipeType;
    }

    @Override
    public String toString() {
        return super.toString() +"\nRecipe Type: "+ recipeType+  "\nCook Time: " + getcookTime() + "\nRegional Significance: " + getRegSignificance();
    }
}
