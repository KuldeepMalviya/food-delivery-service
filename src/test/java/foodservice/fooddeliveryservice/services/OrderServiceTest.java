package foodservice.fooddeliveryservice.services;
import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceTest {


   private OrderRepository orderRepository = mock(OrderRepository.class);
   private OrderService orderService = new OrderService(orderRepository);


   @BeforeEach
   public void setup() {
      when(orderRepository.createOrder(anyInt(), anyList())).thenReturn(1);
   }

   @Test
   public void shouldCreateOrder() {
      int orderId = orderService.createOrder(123, Arrays.asList(new FoodItem("Paneer", "", 150d)));
      assertEquals(1, orderId);
      //first order for a customer
   }


}