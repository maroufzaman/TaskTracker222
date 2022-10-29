package com.rmrfroot.tasktracker222.entities;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Store list of Drills</h1>
 *<p> Allow the users to add drill to the drillCollection</p>
 * @author Brian Frey
 */
public class DrillCollection {
    private List<Drill> drillCollection;
    private int index;
/**
 *Class Constructor create an ArrayList called drillCollection 
 *@see DrillCollection()
*/
    public DrillCollection() {
        drillCollection = new ArrayList<>();
        index = 0;
    }
/**
 * This method add a new drill to the drillCollection
 * @param  drill 
 * @see add(Drill drill)
 */
    public void add(Drill drill) {
        drillCollection.add(drill);
        index++;
    }
/**
 * This method check whether the drillCollection is empty
 * @return 0 or 1 . If return value is 0 mean drillCollection is empty or return value is 1 means drillCollection is not empty
 * @see isEmpty()
 */
    public int isEmpty() {
        if(drillCollection.size() == 0)
            return 0;
        return 1;
    }
/**
 * This method check how many number of drills is in the drillCollection
 * @return size of the drillCollection
 * @see getSize()
 */
    public int getSize() {
        return drillCollection.size();
    }
    /**
     * This method is used to get the Drill from the drillCollection 
     * @return the latest Drill in the drillCollection
     * @see getDrill()
     */

    public Drill getDrill(){
        drillCollection.get(index);
    }

/**
 * This method is used to remove a drill from the drillCollection
 * @param drill
 * @see removeDrill(Drill drill)
 */
    public void removeDrill(Drill drill){
           if (drillCollection.contains(drill)){
          int i =  drillCollection.indexOf(drill);
            drillCollection.remove(i);
           }
    }
}