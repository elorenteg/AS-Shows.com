package showscom.presentationLayer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import showscom.domainLayer.domainModel.TuplaSeient;

public class MyCanvas extends Canvas {
	private static final long serialVersionUID = 1L;

	private int amplada;
	private int altura;
	private int maxFila;
	private int maxColumna;
	private List<TuplaSeient> seientsLliures;
	private List<TuplaSeient> seientsAssignats;

	private int wSeient = 15;
	private int hSeient = 15;
	private int sep = 5;

	public MyCanvas(int width, int height, int maxFila, int maxColumna, List<TuplaSeient> seients) {
		this.maxFila = maxFila;
		this.maxColumna = maxColumna;
		this.seientsLliures = seients;
		this.seientsAssignats = new ArrayList<>();

		int marginX = 200;
		int marginY = 130;

		this.amplada = width - 2 * marginX;
		this.altura = 350;

		setBounds(marginX, marginY, amplada, altura);
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, amplada - 1, 0);
		g.drawLine(0, 0, 0, altura - 1);
		g.drawLine(amplada - 1, 0, amplada - 1, altura - 1);
		g.drawLine(0, altura - 1, amplada - 1, altura - 1);

		int ySeient = (altura - (hSeient * maxFila + sep * (maxFila - 1))) / 2;
		for (int f = 1; f <= maxFila; ++f) {
			int xSeient = (amplada - (wSeient * maxColumna + sep * (maxColumna - 1))) / 2;
			for (int c = 1; c <= maxColumna; ++c) {
				TuplaSeient seient = new TuplaSeient(f, c);

				Color color = Color.GREEN;
				if (seientsAssignats.contains(seient))
					color = Color.YELLOW;
				else if (!seientsLliures.contains(seient))
					color = Color.LIGHT_GRAY;
				g.setColor(color);

				g.fillRoundRect(xSeient, ySeient, hSeient, wSeient, 3, 3);
				xSeient += wSeient + sep;
			}
			ySeient += hSeient + sep;
		}

		int yLab = (altura - (hSeient * maxFila + sep * (maxFila - 1))) / 2 + 12;
		int xLab = (amplada - (wSeient * maxColumna + sep * (maxColumna - 1))) / 2 - 17;
		for (int f = 1; f <= maxFila; ++f) {
			int aux = 0;
			if (f <= 9)
				aux = 6;
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(f), xLab + aux, yLab);
			yLab += hSeient + sep;
		}

		yLab = (altura - (hSeient * maxFila + sep * (maxFila - 1))) / 2 - 4;
		xLab = (amplada - (wSeient * maxColumna + sep * (maxColumna - 1))) / 2;
		for (int c = 1; c <= maxColumna; ++c) {
			int aux = 0;
			if (c <= 9)
				aux = 4;
			g.setColor(Color.BLACK);
			g.drawString(Integer.toString(c), xLab + aux, yLab);
			xLab += wSeient + sep;
		}

		int wPantalla = 220;
		int hPantalla = 20;
		int xPantalla = (amplada - wPantalla) / 2;
		int yPantalla = 10;
		g.setColor(Color.GRAY);
		g.fillRect(xPantalla, yPantalla, wPantalla, hPantalla);

		g.setColor(Color.WHITE);
		g.drawString("ESCENARI", xPantalla + (wPantalla - 50) / 2, yPantalla + (hPantalla + 8) / 2);

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
		int yMin = (altura - (hSeient * maxFila + sep * (maxFila - 1))) / 2;
		int xMin = (amplada - (wSeient * maxColumna + sep * (maxColumna - 1))) / 2;
		if (yClicked >= yMin && yClicked < altura - yMin && xClicked >= xMin && xClicked < amplada - xMin) {

			double ff = (double) (yClicked - yMin) / (hSeient + sep);
			double cc = (double) (xClicked - xMin) / (wSeient + sep);

			double decF = ff - Math.floor(ff);
			double decC = cc - Math.floor(cc);
			double decFdins = (double) wSeient / (wSeient + sep);
			double decCdins = (double) hSeient / (hSeient + sep);

			if (decF <= decFdins && decC <= decCdins) {
				int f = (yClicked - yMin) / (hSeient + sep) + 1;
				int c = (xClicked - xMin) / (wSeient + sep) + 1;

				TuplaSeient seient = new TuplaSeient(f, c);
				if (seientsLliures.contains(seient)) {
					if (!seientsAssignats.contains(seient)) {
						seientsAssignats.add(seient);
						System.out.println("S'assigna el seient " + f + " " + c);
					} else {
						System.out.println("Es desassigna el seient " + f + " " + c);
						seientsAssignats.remove(seient);
					}
					paint(this.getGraphics());
				}

			}
		}
	}

	public List<TuplaSeient> getSeientsAssignats() {
		return seientsAssignats;
	}
}