package es.upm.dit.adsw.diccionarios.arrays.desordenado;

import java.awt.Color;
import java.awt.Point;

import es.upm.dit.adsw.diccionarios.arrays.interfaces.CV;

public class Pixel implements CV<Point, Color> {

	private Point key;
	private Color value;
	
	
	public Pixel(Point key, Color value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public Point getKey() {
		return key;
	}

	@Override
	public Color getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Pixel [key=" + key + ", value=" + value + "]";
	}

	
}
