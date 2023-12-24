import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeManager implements Serializable {
    private static ArrayList<Recipe> recipes = new ArrayList<>();
    private static final String filePath = "Recipes.ser";

    public RecipeManager() {
        
    }

    public static ArrayList getRecipes(){
        loadRecipes();
        return recipes;
    }

    public static void addRecipe(Recipe recipe) {
        loadRecipes();
        recipes.add(recipe);
        saveRecipe(recipe);
    }

    public static Recipe searchRecipeByName(String name) {
        Recipe foundRecipe = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try{
                Recipe recipe = (Recipe) ois.readObject();
                
                if (recipe != null && recipe.getName().trim().equalsIgnoreCase(name.trim())) {
                    foundRecipe = recipe;
                    break;
                }
            }catch(EOFException e){
                break;
            }
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return foundRecipe;
    }


    public static List<Recipe> searchRecipesByChef(String chefName) {
        List<Recipe> chefRecipes = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try{
                Recipe recipe = (Recipe) ois.readObject();
                if (recipe != null && recipe.getChef().getName().equalsIgnoreCase(chefName)) {
                    chefRecipes.add(recipe);
                }
            }catch(EOFException e){
                break;
            }
        }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return chefRecipes;
    }

    public static List<Recipe> searchRecipesByCategory(String category) {
        List<Recipe> categoryRecipes = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try{
                Recipe recipe = (Recipe) ois.readObject();
                if (recipe != null && recipe.getRecipeType().equalsIgnoreCase(category)) {
                    categoryRecipes.add(recipe);
                }
            }catch(EOFException e){
                break;
            }
        }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return categoryRecipes;
    }

    // public static boolean deleteRecipe(String recipeName) {
    //     loadRecipes(); // Load recipes from the file
        
    //     Recipe recipeToRemove = null;
    //     for (Recipe recipe : recipes) {
    //         if (recipe.getName().equalsIgnoreCase(recipeName)) {
    //             recipeToRemove = recipe;
    //             break;
    //         }
    //     }
        
    //     if (recipeToRemove != null) {
    //         recipes.remove(recipeToRemove); // Remove the recipe from the list
            
    //         File file = new File(filePath);
    //         if (file.exists()) {
    //             file.delete(); // Delete the file entirely
    //         }
            
    //         if(!recipes.isEmpty())
    //             saveRecipes(); // Save the updated recipes (which creates a new file)
    //         return true; // Deletion successful
    //     }
        
    //     return false; // Recipe not found for deletion
    // }
    
    // private static void saveRecipes(){
    //     try{
    //         for( Recipe recipe : recipes){
    //             ObjectOutputStream oos;
    //             File file = new File(filePath);
    //             if(file.exists() && file.length()>0){
    //                 oos = new ObjectOutputStream(new FileOutputStream(file,true)){
    //                     protected void writeStreamHeader() throws IOException {

    //                     }
    //                 };
    //             }else{
    //                 oos = new ObjectOutputStream(new FileOutputStream(file));
    //             }
    //             oos.writeObject(recipe);
    //         } 
    //     }catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    public static boolean deleteRecipe(String recipeName) {
        loadRecipes(); // Load recipes from the file
        
        Recipe recipeToRemove = null;
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                recipeToRemove = recipe;
                break;
            }
        }
        
        if (recipeToRemove != null) {
            recipes.remove(recipeToRemove); // Remove the recipe from the list
            saveRecipes(); // Save the updated recipes (which overwrites the existing file)
            return true; // Deletion successful
        }
        
        return false; // Recipe not found for deletion
    }
    
    private static void saveRecipes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Recipe recipe : recipes) {
                oos.writeObject(recipe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static void saveRecipe(Recipe recipe) {
        
        try {
            ObjectOutputStream oos;
            File file = new File(filePath);
            if(file.exists() && file.length()>0){
                oos = new ObjectOutputStream(new FileOutputStream(file,true)){
                    protected void writeStreamHeader() throws IOException {

                    }
                };
            }else{
                oos = new ObjectOutputStream(new FileOutputStream(file));
            }
            oos.writeObject(recipe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadRecipes() {
        recipes.clear();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Recipe recipe = (Recipe) ois.readObject();
                    if (recipe != null) {
                        recipes.add(recipe);
                    } else {
                        break; // Exit loop when no more recipes
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (EOFException ignored) {
            // Reached end of file, no more objects to read
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
