package showscom.presentationLayer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends Canvas {
	private int amplada;
	private int altura;
	private int maxFila;
	private int maxColumna;
	private List<Object> seientsLliures;
	private List<Object> seientsAssignats;

	private int wSeient = 15;
	private int hSeient = 15;
	private int sep = 5;

	public MyCanvas(int width, int height, int maxFila, int maxColumna, List<Object> seients) {
		this.maxFila = maxFila;
		this.maxColumna = maxColumna;
		this.seientsLliures = seients;
		this.seientsAssignats = new ArrayList<>();
		// setBackground(Color.GRAY);

		int marginX = 200;
		int marginY = 150;
		System.out.println("JPANEL: " + width + "x" + height);
		System.out.println("CANVAS-X: " + marginX + "x" + (width - 2 * marginX));
		System.out.println("CANVAS-Y: " + marginY + "x" + 2 * marginY);

		this.amplada = width - 2 * marginX;
		this.altura = 300;

		setBounds(marginX, 150, amplada, altura);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, amplada - 1, 0);
		g.drawLine(0, 0, 0, altura - 1);
		g.drawLine(amplada - 1, 0, amplada - 1, altura - 1);
		g.drawLine(0, altura - 1, amplada - 1, altura - 1);

		int xSeient = (amplada - (wSeient * maxFila + sep * (maxFila - 1))) / 2;
		for (int f = 0; f < maxFila; ++f) {
			int ySeient = (altura - (hSeient * maxColumna + sep * (maxColumna - 1))) / 2;
			for (int c = 0; c < maxColumna; ++c) {
				List<Integer> seient = new ArrayList<>();
				seient.add(f);
				seient.add(c);

				Color color = Color.GREEN;
				if (seientsAssignats.contains(seient))
					color = Color.YELLOW;
				else if (!seientsLliures.contains(seient))
					color = Color.LIGHT_GRAY;
				g.setColor(color);

				g.fillRoundRect(xSeient, ySeient, wSeient, hSeient, 3, 3);
				ySeient += hSeient + sep;
			}
			xSeient += wSeient + sep;
		}

		int wPantalla = 220;
		int hPantalla = 20;
		int xPantalla = (amplada - wPantalla) / 2;
		int yPantalla = 10;
		g.setColor(Color.GRAY);
		g.fillRect(xPantalla, yPantalla, wPantalla, hPantalla);

		g.setColor(Color.WHITE);
		g.drawString("PANTALLA", xPantalla + (wPantalla - 50) / 2, yPantalla + (hPantalla + 8) / 2);

		int xLlegenda = (amplada - (wSeient * 3 + sep * 2 + 3 * 100)) / 2;
		int yLlegenda = altura - 30;

		g.setColor(Color.GREEN);
		g.fillRoundRect(xLlegenda, yLlegenda, wSeient, hSeient, 3, 3);
		g.setColor(Color.BLACK);
		g.drawString("Disponible", xLlegenda + wSeient + 5, yLlegenda + hSeient - 3);
		xLlegenda += wSeient + sep + 100;

		g.setColor(Color.YELLOW);
		g.fillRoundRect(xLlegenda, yLlegenda, wSeient, hSeient, 3, 3);
		g.setColor(Color.BLACK);
		g.drawString("Assignat", xLlegenda + wSeient + 5, yLlegenda + hSeient - 3);
		xLlegenda += wSeient + sep + 100;

		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(xLlegenda, yLlegenda, wSeient, hSeient, 3, 3);
		g.setColor(Color.BLACK);
		g.drawString("No disponible", xLlegenda + wSeient + 5, yLlegenda + hSeient - 3);
	}

	void refresh(int xClicked, int yClicked) {
		int xMin = (amplada - (wSeient * maxFila + sep * (maxFila - 1))) / 2;
		int yMin = (altura - (hSeient * maxColumna + sep * (maxColumna - 1))) / 2;
		if (xClicked >= xMin && xClicked < amplada - xMin && yClicked >= yMin && yClicked < altura - yMin) {
			System.out.println("Area vàlida: " + xClicked + " " + yClicked);

			System.out.println((xClicked - xMin));
			System.out.println((wSeient + sep));
			int f = (xClicked - xMin)/(wSeient + sep);
			int c = (yClicked - yMin)/(hSeient + sep);
			System.out.println("Seient: " + f + " " + c);

			List<Integer> seient = new ArrayList<>();
			seient.add(f);
			seient.add(c);
			if (seientsLliures.contains(seient)) {
				if(!seientsAssignats.contains(seient)) {
					System.out.println("S'asigna el seient: " + f + " " + c);
					seientsAssignats.add(seient);
				}
				else {
					System.out.println("Es desasigna el seient: " + f + " " + c);
					//int index = seientsAssignats.indexOf(seient);
					seientsAssignats.remove(seient);
				}
				paint(this.getGraphics());
			} else {
				System.out.println("Seient NO disponible: " + f + " " + c);
			}
		}
		else {
			System.out.println("Àrea NO vàlida: " + xClicked + " " + yClicked);
		}

	}
}