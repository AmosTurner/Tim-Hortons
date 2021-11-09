package ca.sheridancollege.turneamo.controllers;

import ca.sheridancollege.turneamo.beans.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This web application uses Spring framework to allow a user to order a Tim Hortons coffee
 * and outputs their order to them by means of images and in a tabular format
 *
 * @author Amos Turner
 * @since 2021-10-11
 */
@Controller
public class ProcessOrder {

    // stores a list of user orders
    List<Order> orderList = new CopyOnWriteArrayList<>();

    // stores a list of image representation of user order
    ArrayList<String> imageList = new ArrayList<>();

    // pathing of each image
    String cup = "../images/cup.jpg";
    String plus = "../images/plus.jpg";
    String cream = "../images/cream.jpg";
    String sugar = "../images/sugar.jpg";

    /**
     * Responds to HTTP GET requests
     *
     * @param model stores attributes for the controller back to the view
     * @return index dispatches request to index.html file
     */
    @GetMapping("/")
    public String getIndex(Model model) {

        model.addAttribute("order", new Order());
        model.addAttribute("orders", orderList);
        return "index";
    }

    /**
     * Responds to HTTP POST requests
     *
     * @return index dispatches request to output.html file
     */
    @PostMapping("/addOrder")
    public String addOrder(Model model, @ModelAttribute Order order) {

        orderList.add(order);
        model.addAttribute("order", new Order());
        model.addAttribute("orders", orderList);
        model.addAttribute("coffees", imageList);
        model.addAttribute("panels", order.getPanels());

        // adds elements to the panel arraylist according to the number of coffee orders the user makes
        for (int i = 0; i < order.getAmount(); i++) {
            order.getPanels().add(0);
        }

        // checks which coffee type the user chose
        switch (order.getCoffee()) {
            case "Regular":
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(cream);
                imageList.add(plus);
                imageList.add(sugar);
                break;
            case "Double Double":
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(cream);
                imageList.add(cream);
                imageList.add(plus);
                imageList.add(sugar);
                imageList.add(sugar);
                break;
            case "Triple Triple":
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(cream);
                imageList.add(cream);
                imageList.add(cream);
                imageList.add(plus);
                imageList.add(sugar);
                imageList.add(sugar);
                imageList.add(sugar);
                break;
            case "Black":
                imageList.add(cup);
                break;
            case "Black One Sugar":
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(sugar);
                break;
            case "Black Two Sugars":
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(sugar);
                imageList.add(sugar);
                break;
            default:
                imageList.add(cup);
                imageList.add(plus);
                imageList.add(sugar);
                imageList.add(sugar);
                imageList.add(sugar);
                break;
        }

        return "output";
    }

}
