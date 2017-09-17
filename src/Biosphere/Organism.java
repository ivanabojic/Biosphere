
package Biosphere;

import java.util.HashMap;

/**
 *
 * @author Ivana
 */
public class Organism {
    private int water;
    private int oxygen;
    private int maxValue = 50;

    public Organism(int water, int oxygen) {
        this.water = Math.abs(water);
        this.water = (this.water>maxValue) ? maxValue : this.water;
        this.oxygen = Math.abs(oxygen);
        this.oxygen = (this.oxygen>maxValue) ? maxValue : this.oxygen;
    }

    public HashMap<String,Integer> getResources() {
        HashMap<String,Integer> resource = new HashMap<>();
        resource.put("water", water);
        resource.put("oxygen", oxygen);
        return resource;
    }

    public void setResources(int water, int oxygen) {
        this.water = water;
        this.oxygen = oxygen;
    }
  
}
