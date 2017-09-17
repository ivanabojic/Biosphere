
package Biosphere;

import java.util.HashMap;

/**
 *
 * @author Ivana
 */
public class Animal extends Organism{

    private int food;
    private int maxValue = 50;

    public Animal(int water, int oxygen, int food) {
        super(water, oxygen);
        this.food = Math.abs(food);
        this.food = (this.food>maxValue) ? maxValue : this.food;
    }
    
    @Override
    public HashMap<String,Integer> getResources() {
        HashMap<String,Integer> resource = new HashMap<>();
        for(String key : super.getResources().keySet()){
            resource.put(key, super.getResources().get(key));
        }
        resource.put("food", food);
        return resource;
    }

    public void setResources(int food) {
        this.food = food;
    }    
}
