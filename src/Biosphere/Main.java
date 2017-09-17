
package Biosphere;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Ivana
 */
public class Main {
    public static void main(String[] args) {
        Biosphere bioSphere = new Biosphere();
        
        ArrayList<Organism> organisms = new ArrayList<>();
        Organism parrot = new Bird(2, 18, 3, "Parrot");
        Organism pigeon = new Bird(3, 15, 4, "Pigeon");
        Organism salmon = new Fish(4, 6, 1, "Salmon");
        Organism trout = new Fish(6, 3, 2, "Trout");
        Organism rose = new Plant(1,2, "Rose");
        Organism pine = new Plant(10,8, "Pine");
        
        organisms.add(parrot);
        organisms.add(pigeon);
        organisms.add(salmon);
        organisms.add(trout);
        organisms.add(rose);
        organisms.add(pine);
        
        bioSphere.getResources(organisms, 1);
        bioSphere.getResources(organisms, -5);
        bioSphere.getResources(organisms, 5);
        
        HashMap<String, Integer> resources = new HashMap<>();
        resources.put("water", 300);
        resources.put("oxygen", 300);
        resources.put("food", 300);
        
        bioSphere.runSimulation(organisms, resources, 3);
        System.out.println();
        System.out.println("Remaining resources after 3 days ...");
        printResources(resources);
        bioSphere.runSimulation(null, resources, 3);
        bioSphere.runSimulation(organisms, null, 3);
        bioSphere.runSimulation(organisms, resources, -10);        
    }
    
    public static void printResources(HashMap<String, Integer> resources){
        System.out.println();
        for (String key : resources.keySet()){
            System.out.println(key + " x " + resources.get(key));
        }
    }
}
