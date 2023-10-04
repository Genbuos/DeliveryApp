package deliver;

import deliver.food.Pizza;
import deliver.food.Rice;
import deliver.food.Sprite;
import deliver.food.Wings;

public abstract class ProductFactory  {

    public static Product configureProduct(String type){
        Product p = null;

        if(type.toLowerCase().equals("pizza")){

            p =  new Pizza(20);
            p.setName(type);
        } else if (type.toLowerCase().equals("wings")){
           p = new Wings(15);
           p.setName(type);
        }else if(type.toLowerCase().equals("rice")){
            p = new Rice(5);
        } else if (type.toLowerCase().equals("sprite")) {
           p = new Sprite(3.50);
        }
        return p;
    }
}
