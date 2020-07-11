package foodservice.fooddeliveryservice.controllers;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.models.OrderSummary;
import foodservice.fooddeliveryservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OderController {

   private final OrderService orderService;

   @PostMapping("/order/customer/{customerNumber}")
   public Integer createOrder(@PathVariable("customerNumber") Integer customerNumber, List<FoodItem> foodItems) {
      return orderService.createOrder(customerNumber, foodItems);
   }

   @PutMapping("/order/customer/{customerNumber}/order/{orderId}")
   public boolean updateOrder(@PathVariable Integer customerNumber, @PathVariable Integer orderId, List<FoodItem> foodItems) {
      return orderService.updateOrder(customerNumber, orderId, foodItems);
   }

   @DeleteMapping("/order/customer/{customerNumber}/order/{orderId}")
   public void deleteOrder(@PathVariable Integer customerNumber, @PathVariable Integer orderId) {
      orderService.delete(customerNumber, orderId);
   }

   @GetMapping("/order/customer/{customerNumber}/order/{orderId}/summary")
   public OrderSummary getOrderSummary(@PathVariable Integer customerNumber, @PathVariable Integer orderId) {
      return orderService.getOrderSummary(customerNumber, orderId);
   }


   @GetMapping("hi")
   public String hi() {
      return "Hr There!";
   }

}
