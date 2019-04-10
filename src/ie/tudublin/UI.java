package ie.tudublin;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet

{	
	ArrayList<Colour> colours = new ArrayList<Colour>();
	ArrayList<Resistor> resistors = new ArrayList<Resistor>();


	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	void loadColours()
    {
        Table table = loadTable("colours.csv", "header");
        for(TableRow tr:table.rows())
        {
			String colourName = tr.getString("colour");
			int r = tr.getInt("r");
			int g = tr.getInt("g");
			int b = tr.getInt("b");
			int value = tr.getInt("value");

			Colour c = new Colour();
			c.setValues(r, g, b, value, colourName);
            colours.add(c);
        }        
	}
	
	void loadResistors()
	{
		Table table = loadTable("resistors.csv");
        for(TableRow tr:table.rows())
        {
			int value = tr.getInt(0);
			Resistor r = new Resistor();
			r.setValues(value);
            resistors.add(r);
        }       
	}

	public void settings()
	{
		size(500, 800);
		
		separate(381);
		separate(1);
		separate(92);
	}

	public void printColours()
	{
		for (int i = 0 ; i < colours.size(); i ++)
		{
			println(colours.get(i).getColour());
		}
	}
	
	public Colour findColour(int value)
	{
		for (int i = 0 ; i < colours.size(); i ++)
		{
			if (colours.get(i).value == value)
			{
				return colours.get(i);
			}
		}	
		return colours.get(0);
	}

	public void drawResistors()
	{
		int size = 150;
		int x;
		int y;

		for (int i = 0 ; i < resistors.size(); i ++)
		{
			Resistor resistor = resistors.get(i);

			noFill();
			strokeWeight(2);
			x = width/2 - size/2;
			y = ((i + 1) * size/4) + (i * size);
			rect(x , y, size, size);

			line(x - size/2, y + size/2, x, y + size/2);
			line(x + size + size/2, y + size/2, x + size, y + size/2);

			fill(50);
			textSize(26);
			text(resistor.hundreds + "" + resistor.tens + "" + resistor.ones, width - size/2, y + size/2);
			colorMode(RGB);
			noStroke();

			for (int j = 0 ; j < 3 ; j ++)
			{
				Colour colour;
				if (j == 0)
				{
					colour = findColour(resistor.hundreds);
				}
				else if (j == 1)
				{
					colour = findColour(resistor.tens);
				}
				else
				{
					colour = findColour(resistor.ones);
				}

				println(colour.r);
				fill(colour.r, colour.g, colour.b);
				rect(x + j * size/6 + size/12, y, size/12, size);
			}
			stroke(0);
		}	
	}

	public void setup() 
	{
		loadColours();
		printColours();
		loadResistors();
	}
	
	public void draw()
	{			
		drawResistors();
	}
}
