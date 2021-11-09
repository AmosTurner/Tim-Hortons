package ca.sheridancollege.turneamo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author turneamo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * This class contains information about an order
     * such as the coffee type, amount of coffees, and size of the coffee
     */
    private String coffee;
    private int amount;
    private String size;
    private final String[] sizes = {"Small", "Medium", "Large"};
    private ArrayList<Integer> panels = new ArrayList<>();
}
