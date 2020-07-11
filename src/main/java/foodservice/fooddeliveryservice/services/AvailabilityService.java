package foodservice.fooddeliveryservice.services;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.repositories.FoodItemRepository;
import foodservice.fooddeliveryservice.repositories.RestaurantRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

   private final FoodItemRepository foodItemRepository;

   public List<FoodItem> getFoodItems(String restaurant, String customerLocation) {
      List<String> foodItemsByResAndLocation = RestaurantRepsitory.getFoodItemsByResAndLocation(restaurant, customerLocation);
      return foodItemsByResAndLocation.stream().map(foodItemRepository::getFootItemDetails).collect(Collectors.toList());
   }


}
