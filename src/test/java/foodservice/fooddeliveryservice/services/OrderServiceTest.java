package foodservice.fooddeliveryservice.services;

import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.repositories.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {
   private OrderRepository orderRepository = mock(OrderRepository.class);
   private OrderService orderService = new OrderService(orderRepository);

   @Test
   public void shouldCreateOrder() {
      when(orderRepository.createOrder(anyInt(), anyList())).thenReturn(1);
      int orderId = orderService.createOrder(123, Arrays.asList(new FoodItem("Paneer", "", 150d)));
      assertEquals(1, orderId);
   }

   @Test
   public void shouldUpdateOrder() {
      when(orderRepository.updateOrder(anyInt(), anyInt(), anyList())).thenReturn(true);
      assertTrue(orderService.updateOrder(123, 1, Arrays.asList(new FoodItem("Paneer", "", 150d))));
   }

   @Test
   public void shouldDeleteOrder() {
      orderService.delete(123, 1);
      verify(orderRepository).delete(123, 1);
   }

}