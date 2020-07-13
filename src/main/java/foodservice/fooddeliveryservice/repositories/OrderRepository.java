package foodservice.fooddeliveryservice.repositories;


// static data -- putting in map

import foodservice.fooddeliveryservice.models.FoodItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class OrderRepository {

   private static Map<Integer, Map<Integer, List<FoodItem>>> orders = new HashMap<>();

   public int createOrder(int customerNumber, List<FoodItem> list) {
      int orderId = 1;
      if (null == orders.get(customerNumber)) {
         Map<Integer, List<FoodItem>> map = new HashMap<>();
         map.put(orderId, list);
         orders.put(customerNumber, map);
      } else {
         Map<Integer, List<FoodItem>> customerOrders = orders.get(customerNumber);
         orderId = customerOrders.size() + 1;
         customerOrders.put(orderId, list);
         orders.put(customerNumber, customerOrders);
      }
      return orderId;
   }

   public boolean updateOrder(int customerNumber, int orderId, List<FoodItem> list) {
      Map<Integer, List<FoodItem>> map = orders.get(customerNumber);
      map.put(orderId, list);
      orders.put(customerNumber, map);
      return true;
   }

   public void delete(int customerNumber, int orderId) {
      Map<Integer, List<FoodItem>> map = orders.get(customerNumber);
      map.remove(orderId);
      orders.put(customerNumber, map);
   }

   public List<FoodItem> getOrder(int customer, int order) {
      return orders.get(customer).get(order);
   }
}