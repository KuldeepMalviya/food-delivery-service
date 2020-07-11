package foodservice.fooddeliveryservice.services;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.models.OrderSummary;
import foodservice.fooddeliveryservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

   private final OrderRepository orderRepository;

   public int createOrder(int customerNumber, List<FoodItem> foodItems) {
      return orderRepository.createOrder(customerNumber, foodItems);
   }

   public boolean updateOrder(int customerNumber, int orderId, List<FoodItem> foodItems) {
      return orderRepository.updateOrder(customerNumber, orderId, foodItems);
   }

   public void delete(int customerNumber, int orderId) {
      orderRepository.delete(customerNumber, orderId);
   }

   public OrderSummary getOrderSummary(int customer, int order) {
      List<FoodItem> order1 = orderRepository.getOrder(customer, order);
      List<String> foodItems = new ArrayList<>();
      double billAmount = 0d;
      for (FoodItem item : order1) {
         foodItems.add(item.getName());
         billAmount += item.getPrice();
      }
      return OrderSummary.builder().foodItems(foodItems).totalBilAmount(billAmount).build();
   }
}
