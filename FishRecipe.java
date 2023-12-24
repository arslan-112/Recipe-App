public class FishRecipe extends Recipe {
    private String recipeType;
    private String duration;
    private String regionalSignificance;

    public FishRecipe(String a, String b,String c, String recipeType, String duration,String regSig,Chef chef) {
        super(a,b,c,chef);
        this.recipeType = recipeType;
        this.duration = duration;
        this.regionalSignificance = regSig;
    }


    public String getRecipeType() {
        return this.recipeType;
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

    public void setRegionalSignificance(String sig){
        this.regionalSignificance = sig;
    }
    public String getRegionalSignificance(){
        return this.regionalSignificance;
    }


    @Override
    public String toString() {
        return super.toString() +"\nRecipe Type: "+ recipeType+  "\nCook Time: " + getDuration() + "\nRegional Significance: " + getRegionalSignificance();
    }
}

    


