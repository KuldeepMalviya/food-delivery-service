package foodservice.fooddeliveryservice.controllers;

import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.services.AvailabilityService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AvailabilityControllerTest {
   private AvailabilityService availabilityService = mock(AvailabilityService.class);
   private AvailabilityController availabilityController = new AvailabilityController(availabilityService);

   @Test
   public void shouldReturnAvailableFoodItems() {
      when(availabilityService.getFoodItems(any(), any())).thenReturn(Arrays.asList(new FoodItem("name", "dec", 150d)));
      List<FoodItem> availableFoodItem = availabilityController.getAvailableFoodItem("rajdhani", "indirananga");
      assertFalse(availableFoodItem.isEmpty());
   }

}