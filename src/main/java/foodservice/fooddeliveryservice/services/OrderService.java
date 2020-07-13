package foodservice.fooddeliveryservice.services;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.models.OrderSummary;
import foodservice.fooddeliveryservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

   private final OrderRepository orderRepository;

   public int createOrder(int customerNumber, List<FoodItem> foodItems) {
      try {
         return orderRepository.createOrder(customerNumber, foodItems);
      } catch (Exception e) {
         log.warn("Failed to create new order for customer={}", customerNumber, e);
      }
      return 0;
   }

   public boolean updateOrder(int customerNumber, int orderId, List<FoodItem> foodItems) {
      try {
         return orderRepository.updateOrder(customerNumber, orderId, foodItems);
      } catch (Exception e) {
         log.warn("failed to update order for the customer={}, order={}", customerNumber, orderId, e);
      }
      return false;
   }

   public void delete(int customerNumber, int orderId) {
      try {
         orderRepository.delete(customerNumber, orderId);
      } catch (Exception ee) {
         log.warn("Failed to delete order={}", orderId, ee);
      }
   }

   public OrderSummary getOrderSummary(int customer, int order) {
      try {
         List<FoodItem> order1 = orderRepository.getOrder(customer, order);
         List<String> foodItems = new ArrayList<>();
         double billAmount = 0d;
         for (FoodItem item : order1) {
            foodItems.add(item.getName());
            billAmount += item.getPrice();
         }
         return OrderSummary.builder().foodItems(foodItems).totalBilAmount(billAmount).build();
      } catch (Exception ee) {
         log.warn("Failed to create order summary for order={}", order, ee);
         throw new RuntimeException("Order summary generation failed");
      }
   }
}
