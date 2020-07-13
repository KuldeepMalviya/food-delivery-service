package foodservice.fooddeliveryservice.services;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.repositories.FoodItemRepository;
import foodservice.fooddeliveryservice.repositories.RestaurantRepsitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AvailabilityService {

   private final FoodItemRepository foodItemRepository;
   private final RestaurantRepsitory restaurantRepsitory;

   public List<FoodItem> getFoodItems(String restaurant, String customerLocation) {
      try {
         List<String> foodItemsByResAndLocation = restaurantRepsitory.getFoodItemsByResAndLocation(restaurant, customerLocation);
         return foodItemsByResAndLocation.stream().map(foodItemRepository::getFootItemDetails).collect(Collectors.toList());
      } catch (Exception e) {
         log.warn("Exception occurred while fetching food items", e);
      }
      return new ArrayList<>();
   }
}
