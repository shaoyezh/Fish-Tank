package uoft.csc207.fishtank;


import android.graphics.Canvas;

import java.util.ArrayList;

public abstract class Item{
    /** This item's first coordinate. */
    private int height;
    /** This item's second coordinate. */
    private int width;


    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

    /**
     * Set this item's location.
     *
     * @param a the first coordinate.
     * @param b the second coordinate.
     */

    public void setLocation(int a, int b) {
        // set height to a
        this.height = a;
        // set width to b
        this.width = b;
    }

    // change Bubble floatUp and Seaweed wave to move
    public abstract void move(int grid_Height, int grid_width, ArrayList<Item> myLittleFishes);

    public abstract void draw(Canvas canvas);

}
