package uoft.csc207.fishtank;
import java.util.ArrayList;

import android.graphics.Canvas;

public class FishTankManager {

    /**
     * All the locations where a fish can be.
     */
    private ArrayList<Item> myLittleFishies;
    /**
     * The width of myLittleFishes.
     */
    private int gridWidth;
    /**
     * The height of myLittleFishes.
     */
    private  int gridHeight;

    /**
     * The fish tank manager on a screen with height rows and width columns.
     */
    public FishTankManager(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        myLittleFishies = new ArrayList<>();
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i != myLittleFishies.size(); i++) {
            myLittleFishies.get(i).draw(canvas);
        }
    }
    /**
     * Set this bubble to null if this bubble float out of the FishTank.
     * Garbage collection.
     */
    public void update() {
        for (int i = 0; i != myLittleFishies.size(); i++) {
            Item item = myLittleFishies.get(i);
            item.move(gridHeight, gridWidth, myLittleFishies);
            // Bubble disappear when it touches the wall of FishTank, therefore we call the garbage
            // collector method.
            if (item instanceof Bubble){
                if (item.getHeight() == 0 || item.getWidth() == 0 || item.getWidth() == gridWidth){
                    item = null;
                    System.gc();
                }
            }
        }
    }
    public void createTankItems() {
        myLittleFishies.add(new Fish());
        ( myLittleFishies.get(0)).setLocation(1, 18);
        myLittleFishies.add(new Fish());
        ( myLittleFishies.get(1)).setLocation(1, 22);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(2)).setLocation(1, 14);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(3)).setLocation(1, 28);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(4)).setLocation(1, 36);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(5)).setLocation(16, 5);
        myLittleFishies.add( new Fish());
        (myLittleFishies.get(6)).setLocation(16, 12);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(7)).setLocation(16, 18);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(8)).setLocation(23, 18);
        myLittleFishies.add( new Fish());
        ( myLittleFishies.get(9)).setLocation(6, 12);
        myLittleFishies.add( new HungryFish());
        ( myLittleFishies.get(10)).setLocation(10, 20);
        myLittleFishies.add( new Seaweed(9));
        ( myLittleFishies.get(11)).setLocation(33, 4);
        myLittleFishies.add( new Seaweed(6));
        ( myLittleFishies.get(12)).setLocation(24, 13);
        myLittleFishies.add( new Seaweed(12));
        ( myLittleFishies.get(13)).setLocation(42, 15);
        myLittleFishies.add( new Seaweed(5));
        ( myLittleFishies.get(14)).setLocation(13, 20);
        myLittleFishies.add(new Shrimp());
        ( myLittleFishies.get(15)).setLocation(15, 10);
    }


}
