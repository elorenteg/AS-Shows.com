package showscom.presentationLayer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class MyCanvas extends Canvas {
	private int amplada;
	private int altura;
	private List<Object> seients;

	public MyCanvas(int width, int height, List<Object> seients) {
		this.seients = seients;
		setBackground(Color.GRAY);

		int marginX = 200;
		int marginY = 150;
		System.out.println("JPANEL: " + width + "x" + height);
		System.out.println("CANVAS-X: " + marginX + "x" + (width-2*marginX));
		System.out.println("CANVAS-Y: " + marginY + "x" + 2*marginY);
		
		setBounds(marginX, 150, width-2*marginX, 300);
	}

	public void paint(Graphics g) {
	}
}