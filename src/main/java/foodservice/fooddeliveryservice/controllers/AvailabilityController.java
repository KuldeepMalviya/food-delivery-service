package foodservice.fooddeliveryservice.controllers;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.services.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AvailabilityController {

   private final AvailabilityService availabilityService;

   @GetMapping("/restaurant/{restaurant}/area/{yourLocation}")
   public List<FoodItem> getAvailableFoodItem(@PathVariable String restaurant, @PathVariable String yourLocation) {

      return availabilityService.getFoodItems(restaurant, yourLocation);


   }


}
