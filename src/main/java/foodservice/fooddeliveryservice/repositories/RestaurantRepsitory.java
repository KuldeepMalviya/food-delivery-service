package foodservice.fooddeliveryservice.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RestaurantRepsitory {

   private static Map<String, List<String>> restSrviceAreas = new HashMap<>();
   private static Map<String, List<String>> restFootItems = new HashMap<>();

   static {
      restSrviceAreas.put("BhartiJalpan", Arrays.asList("IndiraNagar", "domlur", "kormangala"));
      restSrviceAreas.put("Rajdhani", Arrays.asList("IndiraNagar", "domlur", "kormangala"));
      restSrviceAreas.put("Ngarjuna", Arrays.asList("IndiraNagar", "domlur", "kormangala"));

      restFootItems.put("BhartiJalpan", Arrays.asList("Biryani", "Paneer", "Chicken"));
      restFootItems.put("Rajdhani", Arrays.asList("Biryani", "Paneer", "Chicken"));
      restFootItems.put("Ngarjuna", Arrays.asList("Biryani", "Paneer", "Chicken"));
   }

   public static List<String> getFoodItemsByResAndLocation(String restaurant, String Location) {
      if (restSrviceAreas.keySet().contains(restaurant) && restSrviceAreas.get(restaurant).contains(Location)) {
         return restFootItems.get(restaurant);
      }

      return new ArrayList<>();
   }

}


