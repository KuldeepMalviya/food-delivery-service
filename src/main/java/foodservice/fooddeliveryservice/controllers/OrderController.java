package foodservice.fooddeliveryservice.controllers;


import foodservice.fooddeliveryservice.models.FoodItem;
import foodservice.fooddeliveryservice.models.OrderSummary;
import foodservice.fooddeliveryservice.services.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order/customer")
public class OrderController {

   private final OrderService orderService;

   @ApiOperation("Create new order for a customer")
   @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
   })
   @PostMapping("/order/customer/{customerNumber}")
   public Integer createOrder(@PathVariable("customerNumber") Integer customerNumber, @RequestBody List<FoodItem> foodItems) {
      log.info("Received request create new order for customer={}, foodItem={}", customerNumber, foodItems);
      int orderId = orderService.createOrder(customerNumber, foodItems);
      log.info("Order created with orderId={}, customer={}", orderId, customerNumber);
      return orderId;
   }

   @ApiOperation("Update an order of a customer")
   @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
   })
   @PutMapping("/{customerNumber}/order/{orderId}")
   public boolean updateOrder(@PathVariable Integer customerNumber, @PathVariable Integer orderId, @RequestBody List<FoodItem> foodItems) {
      log.info("Received request to update order for customer={},orderId={}, foodItem={}", customerNumber, orderId, foodItems);
      boolean updateOrder = orderService.updateOrder(customerNumber, orderId, foodItems);
      log.info("Order updated={} for customer={}, orderId={},", updateOrder, customerNumber, orderId);
      return updateOrder;
   }


   @ApiOperation("Delete an order of a customer")
   @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
   })
   @DeleteMapping("/{customerNumber}/order/{orderId}")
   public void deleteOrder(@PathVariable Integer customerNumber, @PathVariable Integer orderId) {
      log.info("Received request to delete order customer={}, orderId={}", orderId, customerNumber);
      orderService.delete(customerNumber, orderId);
   }


   @ApiOperation("Fetch order summary, by customer number and order id")
   @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success")
   })
   @GetMapping("/{customerNumber}/order/{orderId}/summary")
   public OrderSummary getOrderSummary(@PathVariable Integer customerNumber, @PathVariable Integer orderId) {
      log.info("Received request to fetch Order details,customer={}, orderId={}", customerNumber, orderId);
      OrderSummary orderSummary = orderService.getOrderSummary(customerNumber, orderId);
      log.info("Received request to fetch Order details,customer={}, orderId={}", customerNumber, orderId);
      return orderSummary;
   }

}
