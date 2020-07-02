package com.jedi;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame("System zarządzania Jedi");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(false);
		window.add(new GUI());
		window.pack();
// ustawienie ramki, aby niezależnie od wymiarów monitora pojawiają się na środku
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int frameWidth = window.getSize().width;
		int frameHeight = window.getSize().height;
		window.setLocation((width - frameWidth)/2, (height - frameHeight)/2);
	}
}
