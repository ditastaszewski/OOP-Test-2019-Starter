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

    public void setValues(int v, int o, int t, int h) 
    {
        value = v;
        ones = o;
        tens = t;
        hundreds = h;
    }
    

}
