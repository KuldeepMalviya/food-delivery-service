package foodservice.fooddeliveryservice.controllers;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.services.AvailabilityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AvailabilityController {

   private final AvailabilityService availabilityService;

   @GetMapping("/restaurant/{restaurant}/area/{yourLocation}")
   public List<FoodItem> getAvailableFoodItem(@PathVariable String restaurant, @PathVariable String yourLocation) {
      log.info("Received request to fetch food items, restaurant={} location={}", restaurant, yourLocation);
      List<FoodItem> foodItems = availabilityService.getFoodItems(restaurant, yourLocation);
      log.info("Returning food for restaurant={} location={}, foodItems={}", restaurant, yourLocation, foodItems);
      return foodItems;
   }


}
