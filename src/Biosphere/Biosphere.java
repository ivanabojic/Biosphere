
package Biosphere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Ivana
 */
public class Biosphere {

    public Biosphere() {
    }
    
    /*
    * Return array of pairs organism and number or resources needed for the organism to survive given number of days
    */ 
    public HashMap<String, Integer> getResources(ArrayList<Organism> organisms, int numDays){
        String day = (Math.abs(numDays)>1) ? " days:" : " day:";
        System.out.println("Required resources for " + numDays + day );
        System.out.println();
        if (numDays<1){
            System.out.println();
            return null;
        }
        HashMap<String, Integer> resources = new HashMap<>();
        // loop through all organisms
        for (Organism org : organisms) {
            // add all resources for this orgnaism for given nuber of days            
            for(String key : org.getResources().keySet()){
                if (resources.containsKey(key)){
                    resources.put(key, resources.get(key) + org.getResources().get(key)* numDays);
                }else{
                    resources.put(key,org.getResources().get(key)* numDays);
                }
            }       
        }
        for(String key : resources.keySet()){
            System.out.println(key + " x " + resources.get(key));
        }
        System.out.println();
        return resources;
    }
    
    /*
    * Output to the console the organisms still alive at the end of each day
    */
    public void runSimulation(ArrayList<Organism>  organisms, HashMap<String, Integer> resources, int numDays){
        if( organisms == null || organisms.isEmpty() || resources == null||  resources.isEmpty() ){
            return;
        }
        for (int ii=0; ii<numDays; ii++){
            System.out.println();
            System.out.print("Day " + (ii+1) + " - ");
            String prefix = "";
            Iterator<Organism> iterator  = organisms.iterator();
            while(iterator.hasNext()){
                boolean survive = true;
                Organism org = iterator.next();
                for(String key : org.getResources().keySet()){
                    if(resources.containsKey(key)){
                       int remainResource = resources.get(key) - org.getResources().get(key);
                       if (remainResource<0){
                           survive = false; 
                           resources.put(key, 0);
                       }else{
                           resources.put(key, remainResource);
                       }
                    }else{
                       // if the resource does not exist the organism will die
                       survive = false;  
                    }                    
                }
                if(survive){
                   System.out.print(prefix + org);
                   prefix = ", ";
                }else{
                   // delete the organism that did not survive the day
                   iterator.remove(); 
                }
            }                      
        }
        System.out.println();
    }
    
    
}
