import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Recipe App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Color bgColor = new Color(54, 54, 54);
        JPanel rightPanel = createRightPanel(Color.PINK);
        JPanel topPanel = createTopPanel();
        JPanel leftPanel = createLeftPanel(Color.PINK,rightPanel);
        
        
        JPanel middlePanel = createMiddlePanel(Color.PINK,rightPanel);

        JLabel defaultright = createDefaultRecipeLabel();
        rightPanel.add(defaultright);
        
        UIManager.put("OptionPane.background", Color.decode("#AFEEEE"));
        UIManager.put("Panel.background", Color.decode("#AFEEEE"));
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        
        

        // Adding panels to the frame
        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.decode("#004953"));
        topPanel.setPreferredSize(new Dimension(900, 80));

        JLabel headerLabel = new JLabel("The Recipe App");
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setVerticalAlignment(SwingConstants.CENTER);
        topPanel.add(headerLabel);

        return topPanel;
    }

    private static JPanel createLeftPanel(Color bgColor,JPanel rightPanel) {
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#008b8b"));
        leftPanel.setPreferredSize(new Dimension(200, 500));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setPreferredSize(new Dimension(200,460));
        buttonPanel.setBackground(Color.decode("#008b8b"));
    
        JButton addButton = createStyledButton("Add Recipe");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddRecipeDialog();
            }
        });
        JButton searchButton = createStyledButton("Search Recipe");
        searchButton.addActionListener(e -> displaySearchRecipeDialog(rightPanel));
        JButton deleteButton = createStyledButton("Delete Recipe");
        deleteButton.addActionListener(e -> displayDeleteRecipeDialog());

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createHorizontalGlue());
        horizontalBox.add(addButton);
        horizontalBox.add(Box.createHorizontalGlue());
    
        //vertical struts to space the buttons
        buttonPanel.add(Box.createVerticalStrut(100)); 
        buttonPanel.add(horizontalBox);
        buttonPanel.add(Box.createVerticalStrut(60)); 
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createHorizontalGlue());
        horizontalBox.add(searchButton);
        horizontalBox.add(Box.createHorizontalGlue());

        buttonPanel.add(horizontalBox);

        buttonPanel.add(Box.createVerticalStrut(60)); 
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createHorizontalGlue());
        horizontalBox.add(deleteButton);
        horizontalBox.add(Box.createHorizontalGlue());

        buttonPanel.add(horizontalBox);
        
    
        // Add the button panel to the left panel
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(buttonPanel);
        leftPanel.add(Box.createVerticalGlue());
    
        return leftPanel;
    }

    private static void displayAddRecipeDialog() {
        JFrame dialogFrame = new JFrame("Add Recipe");
        dialogFrame.setSize(600, 400);
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogFrame.setResizable(false);
        dialogFrame.getContentPane().setBackground(Color.decode("#AFEEEE"));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#AFEEEE"));

        JPanel recipeTypePanel = new JPanel();
        recipeTypePanel.setBackground(Color.decode("#AFEEEE"));
        JLabel recipeTypeLabel = new JLabel("Select Recipe Type: ");
        recipeTypeLabel.setBackground(Color.decode("#AFEEEE"));
        recipeTypePanel.add(recipeTypeLabel);

        JPanel radioButtonsPanel = new JPanel(new GridLayout(0, 3));
        radioButtonsPanel.setBackground(Color.decode("#AFEEEE"));
        recipeTypeLabel.setPreferredSize(new Dimension(500,50));

        // Add radio buttons for different recipe types
        JRadioButton dessertRadioButton = new JRadioButton("Desserts");
        JRadioButton mainCourseRadioButton = new JRadioButton("Main Courses");
        JRadioButton saladsRadioButton = new JRadioButton("Salads");
        JRadioButton fishRadioButton = new JRadioButton("Sea Food");
        JRadioButton beverageRadioButton = new JRadioButton("Drinks");
        JRadioButton AppetizerRadioButton = new JRadioButton("Appetizers");

        Color radioButtonColor = Color.decode("#AFEEEE");
        dessertRadioButton.setBackground(radioButtonColor);
        mainCourseRadioButton.setBackground(radioButtonColor);
        saladsRadioButton.setBackground(radioButtonColor);
        fishRadioButton.setBackground(radioButtonColor);
        beverageRadioButton.setBackground(radioButtonColor);
        AppetizerRadioButton.setBackground(radioButtonColor);

        Color radioTextColor = Color.BLACK;
        dessertRadioButton.setForeground(radioTextColor);
        mainCourseRadioButton.setForeground(radioTextColor);
        saladsRadioButton.setForeground(radioTextColor);
        fishRadioButton.setForeground(radioTextColor);
        beverageRadioButton.setForeground(radioTextColor);
        AppetizerRadioButton.setForeground(radioTextColor);

        
        radioButtonsPanel.add(dessertRadioButton);
        radioButtonsPanel.add(mainCourseRadioButton);
        radioButtonsPanel.add(saladsRadioButton);
        radioButtonsPanel.add(fishRadioButton);
        radioButtonsPanel.add(beverageRadioButton);
        radioButtonsPanel.add(AppetizerRadioButton);

        recipeTypePanel.add(radioButtonsPanel);
        

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(dessertRadioButton);
        buttonGroup.add(mainCourseRadioButton);
        buttonGroup.add(saladsRadioButton);
        buttonGroup.add(fishRadioButton);
        buttonGroup.add(beverageRadioButton);
        buttonGroup.add(AppetizerRadioButton);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.setBackground(Color.decode("#AFEEEE"));
        inputPanel.setPreferredSize(new Dimension(500,150));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        JLabel ingredientsLabel = new JLabel("Ingredients:");
        JTextField ingredientsTextField = new JTextField();
        JLabel instructionsLabel = new JLabel("Instructions:");
        JTextField instructionsTextField = new JTextField();
        JLabel cookTimeLabel = new JLabel("Cook Time:");
        JTextField cookTimeTextField = new JTextField();
        JLabel regionalSignificanceLabel = new JLabel("Regional Significance:");
        JTextField regionalSignificanceTextField = new JTextField();
        JLabel chefNameLabel = new JLabel("Chef Name:");
        JTextField chefNameTextField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(ingredientsLabel);
        inputPanel.add(ingredientsTextField);
        inputPanel.add(instructionsLabel);
        inputPanel.add(instructionsTextField);
        inputPanel.add(cookTimeLabel);
        inputPanel.add(cookTimeTextField);
        inputPanel.add(regionalSignificanceLabel);
        inputPanel.add(regionalSignificanceTextField);
        inputPanel.add(chefNameLabel);
        inputPanel.add(chefNameTextField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Geting the selected recipe type and input values
                String name = nameTextField.getText();
                String ingredients = ingredientsTextField.getText();
                String instructions = instructionsTextField.getText();
                String cookTime = cookTimeTextField.getText();
                String regionalSignificance = regionalSignificanceTextField.getText();
                String chefName = chefNameTextField.getText();
                Chef chef = new Chef(chefName);

                Recipe recipe = null;

                String selectedType = "";
                if (dessertRadioButton.isSelected()) {
                    selectedType = dessertRadioButton.getText();
                    recipe = new DessertRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                } else if (mainCourseRadioButton.isSelected()) {
                    selectedType = mainCourseRadioButton.getText();
                    recipe = new MainCourseRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                } else if (saladsRadioButton.isSelected()) {
                    selectedType = saladsRadioButton.getText();
                    recipe = new SaladRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                } else if(fishRadioButton.isSelected()){
                    selectedType = fishRadioButton.getText();
                    recipe = new FishRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                } else if(beverageRadioButton.isSelected()){
                    selectedType = beverageRadioButton.getText();
                    recipe = new BeverageRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                } else if(AppetizerRadioButton.isSelected()){
                    selectedType = AppetizerRadioButton.getText();
                    recipe = new AppetizerRecipe(name, ingredients, instructions, selectedType, cookTime, regionalSignificance, chef);
                }
                
                
                // Add the new recipe to the RecipeManager
                if(recipe!=null)
                    RecipeManager.addRecipe(recipe);

                dialogFrame.dispose();
            }
        });

        mainPanel.add(recipeTypePanel);
        mainPanel.add(inputPanel);
        mainPanel.add(addButton);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - dialogFrame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - dialogFrame.getHeight()) / 2);

        //Seting location of the dialog
        dialogFrame.setLocation(centerX, centerY);

        dialogFrame.add(mainPanel);
        dialogFrame.setVisible(true);
    }


    private static JPanel createMiddlePanel(Color bgColor, JPanel rightPanel) {
        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(Color.decode("#367588"));
        middlePanel.setPreferredSize(new Dimension(400, 500));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
    
        JLabel categoriesTitleLabel = new JLabel("Categories");
        categoriesTitleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        categoriesTitleLabel.setForeground(Color.BLACK);
        categoriesTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //Align the label to the center horizontally
        middlePanel.add(categoriesTitleLabel);
        middlePanel.add(Box.createVerticalStrut(20)); //Adding some space
    
        JPanel buttonLabel = new JPanel();
        buttonLabel.setLayout(new BoxLayout(buttonLabel, BoxLayout.Y_AXIS));
        buttonLabel.setBackground(Color.decode("#367588"));
        buttonLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        List<String> categories = List.of("Desserts", "Main Courses", "Salads", "Appetizers", "Drinks", "Sea Food");
        for (String category : categories) {
            RoundedButton categoryButton = createCategoryButton(category, Color.decode("#367588"), rightPanel); // Update Color to your preference
            categoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            categoryButton.setPreferredSize(new Dimension(400, 50)); 
    
            JPanel categoryButtonPanel = new JPanel();
            categoryButtonPanel.setBackground(Color.decode("#367588"));
            categoryButtonPanel.add(categoryButton);
    
            buttonLabel.add(categoryButtonPanel);
            buttonLabel.add(Box.createVerticalStrut(10));
        }
    
        middlePanel.add(buttonLabel);
        return middlePanel;
    }
    private static void displayDeleteRecipeDialog() {
        JFrame dialogFrame = new JFrame("Delete Recipe");
        dialogFrame.setSize(300, 150);
        dialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogFrame.setResizable(false);
        dialogFrame.getContentPane().setBackground(Color.decode("#AFEEEE"));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.decode("#AFEEEE"));

        JLabel nameLabel = new JLabel("Enter Recipe Name:");
        JTextField nameTextField = new JTextField();

        mainPanel.add(Box.createVerticalStrut(20)); 
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            String recipeName = nameTextField.getText();
            boolean deleted = RecipeManager.deleteRecipe(recipeName);
            if (deleted) {
                JOptionPane.showMessageDialog(dialogFrame, "Recipe deleted successfully");
            } else {
                JOptionPane.showMessageDialog(dialogFrame, "No such recipe. Please try again.");
            }
            dialogFrame.dispose();
        });

        mainPanel.add(Box.createVerticalStrut(20)); 
        mainPanel.add(deleteButton);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - dialogFrame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - dialogFrame.getHeight()) / 2);

       
        dialogFrame.setLocation(centerX, centerY);
        dialogFrame.add(mainPanel);
        dialogFrame.setVisible(true);
    }

    private static JPanel createRightPanel(Color bgColor) {
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#0a7e8c"));
        rightPanel.setPreferredSize(new Dimension(500, 500));
        return rightPanel;
    }

    private static RoundedButton createStyledButton(String text) {
        RoundedButton button = new RoundedButton(text);
        button.setBackground(Color.decode("#88d8c0"));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        button.setBorderColor(Color.decode("#004953"));
        button.setButtonSize(180, 60);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    private static RoundedButton createCategoryButton(String categoryName, Color bgColor, JPanel rightPanel) {
        RoundedButton categoryButton = new RoundedButton(categoryName);
        categoryButton.setForeground(Color.BLACK);
        categoryButton.setBackground(Color.decode("#48d1cc")); 
        categoryButton.setBorderColor(Color.decode("#004953"));
        categoryButton.setFocusPainted(false);
        categoryButton.setContentAreaFilled(false);
        categoryButton.setButtonSize(200, 40);
        categoryButton.addActionListener(e -> {
            RoundedButton clickedButton = (RoundedButton) e.getSource();
            updateRightPanelWithRecipes(rightPanel, clickedButton.getText());
        });
        return categoryButton;
    }

    private static void updateRightPanelWithRecipes(JPanel rightPanel, String selectedCategory) {
        rightPanel.removeAll();
    
        List<Recipe> recipes = RecipeManager.searchRecipesByCategory(selectedCategory);
    
        DefaultListModel<String> recipesListModel = new DefaultListModel<>();
    
        for (Recipe recipe : recipes) {
            recipesListModel.addElement(recipe.getName());
        }
    
        JList<String> recipesList = new JList<>(recipesListModel);
        recipesList.setBackground(Color.decode("#43b3ae"));
        recipesList.setForeground(Color.BLACK);
        recipesList.setBorder(null);
        recipesList.setPreferredSize(new Dimension(300, 300));
        recipesList.setFont(new Font("Tahoma", Font.BOLD, 18));
        recipesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRecipe = recipesList.getSelectedValue();
                if (selectedRecipe != null) {
                    displayRecipeDetails(rightPanel, selectedCategory, selectedRecipe, recipes);
                }
            }
        });
    
        rightPanel.add(new JScrollPane(recipesList));
        rightPanel.revalidate();
        rightPanel.repaint();
    }

    private static void displayRecipeDetails(JPanel rightPanel, String selectedCategory, String selectedRecipeName, List<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            if (recipe.getRecipeType().equals(selectedCategory) && recipe.getName().equals(selectedRecipeName)) {
                JTextArea recipeDetails = new JTextArea(recipe.toString());
                recipeDetails.setEditable(false);
                recipeDetails.setFont(new Font("Tahoma",Font.BOLD,18));
                recipeDetails.setForeground(Color.BLACK);
                recipeDetails.setBackground(Color.decode("#43b3ae"));
                recipeDetails.setLineWrap(true);
                recipeDetails.setWrapStyleWord(true);
                recipeDetails.setPreferredSize(new Dimension(400, 400));
                
                rightPanel.removeAll();
                rightPanel.add(new JScrollPane(recipeDetails));
                rightPanel.revalidate();
                rightPanel.repaint();
                break;
            }
        }
    }

    //Code for right panel using search button!!!
    private static void displaySearchRecipeDialog(JPanel rightPanel) {
        Object[] options = {"Search by Recipe Name", "Search by Chef"};
        int choice = JOptionPane.showOptionDialog(null, "Choose search method:", "Search Recipe",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // Search by Recipe Name
            String recipeName = JOptionPane.showInputDialog(null, "Enter Recipe Name:");
            if (recipeName != null && !recipeName.isEmpty()) {
                Recipe foundRecipe = RecipeManager.searchRecipeByName(recipeName);
                if (foundRecipe != null) {
                    displayRecipeDetails2(rightPanel, foundRecipe);
                } else {
                    JOptionPane.showMessageDialog(null, "Recipe not found. Try again.", "Search Recipe", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid recipe name.", "Search Recipe", JOptionPane.ERROR_MESSAGE);
            }
        } else if (choice == 1) { // Search by Chef
            String chefName = JOptionPane.showInputDialog(null, "Enter Chef Name:");
            if (chefName != null && !chefName.isEmpty()) {
                List<Recipe> recipesByChef = RecipeManager.searchRecipesByChef(chefName);
                if (!recipesByChef.isEmpty()) {
                    displayRecipesByChef(rightPanel, recipesByChef);
                } else {
                    JOptionPane.showMessageDialog(null, "No recipes found for the chef. Try again.", "Search Recipe", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid chef name.", "Search Recipe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void displayRecipesByChef(JPanel rightPanel, List<Recipe> chefRecipes) {
        rightPanel.removeAll();
    
        DefaultListModel<String> recipesListModel = new DefaultListModel<>();
        JList<String> recipesList = new JList<>(recipesListModel);
    
        for (Recipe recipe : chefRecipes) {
            recipesListModel.addElement(recipe.getName());
        }
    
        recipesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        recipesList.setBackground(Color.decode("#43b3ae"));
        recipesList.setForeground(Color.BLACK);
        recipesList.setBorder(null);
        recipesList.setPreferredSize(new Dimension(300, 300));
        recipesList.setFont(new Font("Tahoma", Font.BOLD, 18));
        recipesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedRecipeName = recipesList.getSelectedValue();
                if (selectedRecipeName != null) {
                    for (Recipe recipe : chefRecipes) {
                        if (recipe.getName().equals(selectedRecipeName)) {
                            displayRecipeDetails2(rightPanel, recipe);
                            break;
                        }
                    }
                }
            }
        });
    
        JScrollPane scrollPane = new JScrollPane(recipesList);
        rightPanel.add(scrollPane);
        rightPanel.revalidate();
        rightPanel.repaint();
    }

        private static void displayRecipeDetails2(JPanel rightPanel, Recipe recipe) {
            rightPanel.removeAll();

            JTextArea recipeDetails = new JTextArea(recipe.toString());
                recipeDetails.setEditable(false);
                recipeDetails.setFont(new Font("Tahoma",Font.BOLD,18));
                recipeDetails.setForeground(Color.BLACK);
                recipeDetails.setBackground(Color.decode("#43b3ae"));
                recipeDetails.setLineWrap(true);
                recipeDetails.setWrapStyleWord(true);
                recipeDetails.setPreferredSize(new Dimension(400, 400));
                
                rightPanel.removeAll();
                rightPanel.add(new JScrollPane(recipeDetails));
                rightPanel.revalidate();
                rightPanel.repaint();
        }
    
    
    

    private static JLabel createDefaultRecipeLabel() {
        JLabel label = new JLabel("Select a category to view recipes");
        label.setForeground(Color.BLACK);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(400, 400));
        label.setOpaque(true);
        label.setBackground(Color.decode("#0a7e8c"));
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        return label;
    }
}

    

