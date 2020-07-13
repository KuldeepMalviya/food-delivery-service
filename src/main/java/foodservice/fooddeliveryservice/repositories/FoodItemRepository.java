package foodservice.fooddeliveryservice.repositories;

import foodservice.fooddeliveryservice.models.FoodItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class FoodItemRepository {

   private static Map<String, FoodItem> foodItems = new HashMap<>();

   static {
      foodItems.put("Biryani", new FoodItem("Biryani", "description", 200d));
      foodItems.put("Paneer", new FoodItem("Paneer", "description", 150d));
      foodItems.put("Chicken", new FoodItem("Chicken", "description", 300d));
   }


   public FoodItem getFootItemDetails(String name) {
      return foodItems.get(name);
   }
}
