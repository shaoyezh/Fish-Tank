package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;

/**
 * A bubble.
 */
public class Bubble extends Item{

    /**
     * How this bubble appears on the screen.
     */
    private String appearance;

    /**
     * This bubble's first coordinate.
     */

    /**
     * This bubble's second coordinate.
     */

    private Paint paintText = new Paint();

    /**
     * Constructs a new bubble at the specified cursor location (x, y).
     */
    public Bubble() {
        // Get a nice-looking grey for the bubble
        paintText.setTextSize(36);
        paintText.setColor(Color.LTGRAY);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        // start off with . as the appearance
        appearance = ".";
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas the graphics context in which to draw the string.
     * @param s      the string to draw.
     * @param x      the x-coordinate of the string's cursor location.
     * @param y      the y-coordinate of the string's cursor location.
     */
    private void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }


    /**
     * Draws this fish tank item.
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, appearance, this.getWidth(), this.getHeight());
    }



    public void move(int gridHeight, int gridWidth, ArrayList<Item> myLittleFishies){
        double d = Math.random();
        this.setHeight(this.getHeight() - 1);
        if (d < 0.33){}
        else if (d < 0.66){this.setWidth(this.getWidth() + 1);}
        else this.setWidth(this.getWidth() - 1);
        if (this.getHeight() == 0){}
        changeBubble();
    }

    public void changeBubble(){
        double t = Math.random();
        if(t < 0.05) {
            // If the appearance is a ., change it to an o
            if (appearance.equals(".")) appearance = "o";
                // If the appearance is an o, change it to a O
            else if (appearance.equals("o")) appearance = "O";
        }
    }
}
