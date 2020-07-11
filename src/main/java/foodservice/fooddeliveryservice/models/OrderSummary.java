package foodservice.fooddeliveryservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OrderSummary {
   private List<String> foodItems;
   private double totalBilAmount;
}
