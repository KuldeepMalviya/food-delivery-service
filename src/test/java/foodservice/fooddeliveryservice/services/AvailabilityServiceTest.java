package foodservice.fooddeliveryservice.services;

import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.repositories.FoodItemRepository;
import foodservice.fooddeliveryservice.repositories.RestaurantRepsitory;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AvailabilityServiceTest {

   @Mock
   private FoodItemRepository foodItemRepository = mock(FoodItemRepository.class);
   @Mock
   private RestaurantRepsitory restaurantRepsitory = mock(RestaurantRepsitory.class);
   @InjectMocks
   private AvailabilityService availabilityService = new AvailabilityService(foodItemRepository, restaurantRepsitory);

   private FoodItem foodItem = new FoodItem("itemName", "description", 150d);

   @Test
   public void shouldReturnAvailableFoodItems() {
      when(restaurantRepsitory.getFoodItemsByResAndLocation(any(), any())).thenReturn(Arrays.asList("foodItem"));
      when(foodItemRepository.getFootItemDetails(any())).thenReturn(foodItem);
      List<FoodItem> foodItems = availabilityService.getFoodItems("RestaurantName", "location");
      assertEquals(foodItems.get(0).getName(), foodItem.getName());
      assertEquals(foodItems.get(0).getDescription(), foodItem.getDescription());
      assertEquals(foodItems.get(0).getPrice(), foodItem.getPrice());
   }
}