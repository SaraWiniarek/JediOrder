package com.jedi;

import java.util.*;

public class OrderJedi {
	
	public static List<OrderJedi> orderList= new ArrayList<OrderJedi>();
	
	private String name;
	public List<KnightsJedi> knightsInOrderList = new ArrayList<KnightsJedi>();
	
	public OrderJedi(String name) {
		this.name = name;
		orderList.add(this);
	}
	
	public void addKnight(KnightsJedi k) {
		knightsInOrderList.add(k);
	}

	@Override
	public String toString() {
		return name;
	}
	

}
