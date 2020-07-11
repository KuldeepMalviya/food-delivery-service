package foodservice.fooddeliveryservice.models;


import lombok.Data;

@Data
public class FoodItem {
   private String name;
   private String description;
   private double price;

   public FoodItem(String name, String description, double price) {
      this.name = name;
      this.description = description;
      this.price = price;
   }
}
