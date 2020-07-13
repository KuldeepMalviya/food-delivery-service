package foodservice.fooddeliveryservice.controllers;

import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.services.OrderService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OderControllerTest {
   private OrderService orderService = mock(OrderService.class);
   private OrderController orderController = new OrderController(orderService);

   @Test
   public void shouldCreateOrder() {
      when(orderService.createOrder(anyInt(), anyList())).thenReturn(1);
      int orderId = orderController.createOrder(123, Arrays.asList(new FoodItem("Paneer", "", 150d)));
      assertEquals(1, orderId);
   }

   @Test
   public void shouldUpdateOrder() {
      when(orderService.updateOrder(anyInt(), anyInt(), anyList())).thenReturn(true);
      assertTrue(orderController.updateOrder(123, 1, Arrays.asList(new FoodItem("Paneer", "", 150d))));
   }

   @Test
   public void shouldDeleteOrder() {
      orderService.delete(123, 1);
      verify(orderController).deleteOrder(123, 1);
   }
}