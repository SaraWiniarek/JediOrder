package com.jedi;

import java.util.*;

public class KnightsJedi {
	
	public static List<KnightsJedi> knightsList = new ArrayList<KnightsJedi>();

	private String name;
	private String swordColor;
	private int force;
	private String forceSide;
	public List<OrderJedi> order = new ArrayList<OrderJedi>();
	
	public KnightsJedi(String name, String swordColor, int force, String forceSide) {
		this.name = name;
		this.swordColor = swordColor;
		this.force = force;
		this.forceSide = forceSide;
		knightsList.add(this);
	}
	
	public void addOrder(OrderJedi o) {
		order.add(o);
	}

	@Override
	public String toString() {
		return name + ", kolor miecza: " + swordColor + ", moc: " + force + ", strona mocy: "
				+ forceSide;
	}
}