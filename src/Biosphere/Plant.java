
package Biosphere;

/**
 *
 * @author Ivana
 */
public class Plant extends Organism{
    private String name;
    
    public Plant(int water, int oxygen, String name) {
        super(water, oxygen);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }   
    
}
