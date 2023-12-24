public class BeverageRecipe extends Recipe{
    private String recipeType;
    private String regionalSignificance;
    private String cookTime;

    public BeverageRecipe(String a, String b,String c, String recipeType,String cookTime,String regSig,Chef chef) {
        super(a,b,c,chef);
        this.recipeType = recipeType;
        this.regionalSignificance = regSig;
        this.cookTime = cookTime;
    }

    public String getRecipeType() {
        return this.recipeType;
    }
    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public String getRegionalSignificance() {
        return this.regionalSignificance;
    }

    public void setRegionalSignificance(String regionalSignificance) {
        this.regionalSignificance = regionalSignificance;
    }

    public String getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    @Override
    public String toString() {
        return super.toString() +"\nRecipe Type: "+ recipeType+  "\nCook Time: " + getCookTime() + "\nRegional Significance: " + getRegionalSignificance();
    }

    

}
    

