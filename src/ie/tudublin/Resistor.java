package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Resistor extends PApplet

{
    public int value;
    public int ones;
    public int tens;
    public int hundreds;

    public void setValues(int v) 
    {
        value = v;
        
        ones = value - ((hundreds * 100)  + (tens * 10));
        tens = (value - (hundreds * 100)) / 10;
        hundreds =(value / 100);
    }


}
