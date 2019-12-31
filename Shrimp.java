package uoft.csc207.fishtank;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * A shrimp.
 */
public class Shrimp extends Fishes {

    /**
     * How this fish appears on the screen.
     */
    private String appearance;

    /**
     * Indicates whether this fish is moving right.
     */


    private Paint paintText = new Paint();

    /**
     * Constructs a new fish.
     */
    public Shrimp() {
        paintText.setTextSize(50);
        paintText.setColor(Color.CYAN);
        paintText.setTypeface(Typeface.DEFAULT_BOLD);
        goingRight = true;
        appearance = "j=>";
    }

    public void turnAround() {
        goingRight = !goingRight;
        appearance = reverseAppearance(appearance);
    }

    /**
     * Draws the given string in the given graphics context at
     * at the given cursor location.
     *
     * @param canvas the canvas on which to draw this item.
     * @param s      the string to draw.
     * @param x      the x-coordinate of the string's cursor location.
     * @param y      the y-coordinate of the string's cursor location.
     */
    void drawString(Canvas canvas, String s, int x, int y) {
        canvas.drawText(s, x * FishTankView.charWidth, y * FishTankView.charHeight, paintText);
    }

    /**
     * Draws this fish tank item.
     *
     * @param canvas the canvas on which to draw this item.
     */
    public void draw(Canvas canvas) {
        drawString(canvas, appearance, this.getWidth(), this.getHeight());
    }
}