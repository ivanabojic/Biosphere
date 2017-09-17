
package Biosphere;

/**
 *
 * @author Ivana
 */
public class Bird extends Animal{
    private String name;
    
    public Bird(int water, int oxygen, int food, String name) {
        super(water, oxygen, food);
        this.name = name;
    }    
    
    @Override
    public String toString() {
        return name;
    }   
}
