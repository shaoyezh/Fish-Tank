package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.util.ArrayList;

public class Seaweed extends Item{
    private Paint paintText = new Paint();


    /**
     * The number of weed segments.
     */
    private int l;

    /**
     * Indicates whether the bottom segment is leaning right.
     */
    private boolean lR;


    /**
     * Constructs a new seaweed item at the specified cursor
     * location (x,y),l segments tall.
     * @param l the number of segments this seaweed is tall.
     */
    public Seaweed(int l) {
        this.l = l;
        paintText.setTextSize(36);
        paintText.setColor(Color.GREEN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
    }


    /**
     * Draws this fish tank item.  Looks lovely waving in the current, doesn't
     * it?
     *
     * @param canvas the graphics context in which to draw this item.
     */
    public void draw(Canvas canvas) {

        int height = this.getHeight();
        int width = this.getWidth();

        //boolean lR = leanRight;

        for (int i = 0; i < l; i++)
        { // Draw a "/" seaweed segment: even numbered and leaning to the right.
            if (i % 2 == 0){
                if (lR){
                    // Draw the string
                    drawString(canvas, "/", -i+height, width);
                }
                else{
                    drawString(canvas, "\\",  -i+height, width);
                }
            }
            else{
                if (lR)
                    // Draw the string
                    drawString(canvas, "\\", -i + height,width);
                else{
                    drawString(canvas, "/", -i + height, width);
                }
            }
        }
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas where to draw the string.
     * @param s      the string to draw.
     * @param x      the x-coordinate of the string's cursor location.
     * @param y      the y-coordinate of the string's cursor location.
     */
    private void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s,y * FishTankView.charHeight,x * FishTankView.charWidth, paintText);
    }



    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */
    public void move(int gridHeight, int gridWidth, ArrayList<Item> myLittleFishies) {
        lR = !lR;
    }




}