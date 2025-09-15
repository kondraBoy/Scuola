package com.example.mylistviewadvanced;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblExc;

    @FXML
    private Label lblTitle;

    @FXML
    private ListView<Food> listFoods;

    @FXML
    private Pane root;

    @FXML
    private TextField txtFood;

    @FXML
    private TextField txtPrice; // TextField for food price

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listFoods.getItems().addAll(
                new Food("Pizza", 12.99),
                new Food("Pasta", 10.99),
                new Food("Sushi", 15.99),
                new Food("Lasagna", 13.49),
                new Food("Cannelloni", 11.99)
        );
    }

    public void selectedItem() {
        Food selectedFood = listFoods.getSelectionModel().getSelectedItem();
        if (selectedFood != null) {
            lblTitle.setText("Selected: " + selectedFood.getName() + " - $" + selectedFood.getPrice());
        }
    }

    public void onBtnAddClick() {
        String newFoodName = txtFood.getText();
        String priceText = txtPrice.getText();
        if (newFoodName.isEmpty() || priceText.isEmpty()) {
            lblExc.setText("Please fill in both name and price.");
            return;
        }
        try {
            double newFoodPrice = Double.parseDouble(priceText);
            for (Food food : listFoods.getItems()) {
                if (food.getName().equalsIgnoreCase(newFoodName)) {
                    lblExc.setText("Food already in the list.");
                    return;
                }
            }
            Food newFood = new Food(newFoodName, newFoodPrice);
            listFoods.getItems().add(newFood);
            txtFood.clear();
            txtPrice.clear();
            lblExc.setText("");
        } catch (NumberFormatException e) {
            lblExc.setText("Please enter a valid price.");
        }
    }

    public void onBtnRemoveClick(){
        String food = txtFood.getText();
        boolean found = false;
        if (food == null) {
            lblExc.setText("No food selected to remove");
        }else {
            for (int i = 0; i < listFoods.getItems().size() && !found; i++) {
                if (listFoods.getItems().get(i).getName().equalsIgnoreCase(food)) {
                    listFoods.getItems().remove(i);
                    lblExc.setText("");
                    txtFood.clear();
                    found = true;
                }
            }
        }
        if(!found){
            lblExc.setText("Not found the food to remove");
        }
    }
}










