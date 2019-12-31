package uoft.csc207.fishtank;

import java.util.ArrayList;

public abstract class Fishes extends Item {


    protected boolean goingRight;

    public abstract void turnAround();

    public String reverseAppearance(String appear) {
        System.out.println("Turning around" + appear);
        String reverse = "";
        for (int i = appear.length() - 1; i >= 0; i--) {
            switch (appear.charAt(i)) {
                case ')':
                    reverse += '(';
                    break;
                case '(':
                    reverse += ')';
                    break;
                case '>':
                    reverse += '<';
                    break;
                case '<':
                    reverse += '>';
                    break;
                case '}':
                    reverse += '{';
                    break;
                case '{':
                    reverse += '}';
                    break;
                case '[':
                    reverse += ']';
                    break;
                case ']':
                    reverse += '[';
                    break;
                default:
                    reverse += appear.charAt(i);
                    break;
            }
        }
        System.out.println("Turned around" + appear);
        return reverse;
    }


    /**
     * Causes this item to take its turn in the fish-tank simulation.
     */

    public void move(int gridHeight, int gridWidth, ArrayList<Item> myLittleFishies) {
        double d;
        int width = this.getWidth();
        int height = this.getHeight();
        // Move one spot to the right or left.
        // When Fishes touches wall, they turnaround and swim ahead one spot.
        if (goingRight) {
            this.setWidth(width + 1);
            if (this.getWidth() == gridWidth) {
                turnAround();
                this.setWidth(this.getWidth() - 1);
            }
        } else {
            this.setWidth(this.getWidth() - 1);
            if (this.getWidth() == 0) {
                turnAround();
                this.setWidth(this.getWidth() + 1);
            }
        }
        //Figure out whether Fishes blow bubble
        d = Math.random();
        if (d < 0.1) {
            Bubble b = new Bubble();
            b.setLocation(this.getHeight(), this.getWidth());
            System.out.println(this.getHeight() + " " + this.getWidth());
            myLittleFishies.add(b);
        }
            // Figure out whether Fishes turn around.
        d = Math.random();
            // If it's less than 10%, turn around
        if (d < 0.1) {
            turnAround();
        }
            // Figure out whether to move up or down, or neither.
        d = Math.random();
            // If it's less than 10%, move up
        if (d < 0.1 && height > 1) {
            // Fishes can not swim at the surface of FishTank
            this.setHeight(this.getHeight() - 1);
        } else if (d < 0.2 && height < gridHeight - 1) {
            // Fishes can not swim at the bottom of the FishTank
            this.setHeight(this.getHeight() + 1);
        }
        }
    }

