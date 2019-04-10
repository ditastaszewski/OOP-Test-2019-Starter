package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Colour extends PApplet

{
    public int r;
    public int g;
    public int b;
    public int value;
    private String colour;

    public void setValues(int red, int green, int blue, int iValue, String sColour) 
    {
        r = red;
        g = green;
        b = blue;
        value = iValue;
        colour = sColour;
    }

    /**
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * @param colour the colour to set
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

}
