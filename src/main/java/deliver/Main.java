package deliver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double deliveryfee = 0.0;
        Map<String, Double> cart = new HashMap<>();
        Scanner userInput = new Scanner(System.in);

        boolean moreStuff = true;

        while(moreStuff){
            System.out.println("Enter desired product");
            String $res1 = userInput.next();



            switch ($res1.toLowerCase()){
                case "pizza":
                    var p = ProductFactory.configureProduct("Pizza");
                    System.out.println("Enter Quantity");
                    int qty = userInput.nextInt();
                    p.setQty(qty);
                    cart.put( p.getName(),p.getPrice() * qty);
                    break;
                case "rice":
                    var r =ProductFactory.configureProduct("Rice");
                    System.out.println("Enter Quantity");
                     qty = userInput.nextInt();
                     r.setQty(qty);
                    cart.put( r.getName(), r.getPrice() * qty);
                    break;
                case "wings":
                    var w = ProductFactory.configureProduct("Wings");
                    System.out.println("Enter Quantity");
                     qty = userInput.nextInt();
                        w.setQty(qty);
                    cart.put(w.getName(), w.getPrice() * qty);
                    break;
                case "sprite":
                    var s = ProductFactory.configureProduct("Sprite");
                    System.out.println("Enter Quantity");
                    qty = userInput.nextInt();
                    s.setQty(qty);
                    cart.put(s.getName(),s.getPrice() * qty);
                    break;
                default:
                    System.out.println("Product is not supported");
            }




            System.out.println("Would you like something else? y/n");
            String $yon = userInput.next();

            if($yon.equalsIgnoreCase("n")){
                moreStuff = false;
            }

        }
        double totalCost = 0.0;
        for (Double cost: cart.values()) {
            totalCost += cost;
        }

        System.out.println("How many miles away are you?");
        int $miles = userInput.nextInt();

        if($miles <= 5){
            deliveryfee += 2;
        } else if ($miles > 5 && $miles <= 15) {
            deliveryfee  += 5;
        } else if ($miles > 15 && $miles <= 25) {
            deliveryfee += 10;
        } else if ($miles > 25 && $miles <= 50) {
            deliveryfee += 15;
        } else if ($miles > 50) {
            deliveryfee += 20;
        }

        for (String product: cart.keySet()) {
            double price =  cart.get(product);
            price += deliveryfee;
            cart.put(product, price);

        }

        System.out.println();
    }
}
