package com.jedi;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;


public class GUI extends JPanel{
	
	public GUI() {
		setLayout(null);
		
		JLabel label1 = new JLabel("Zakony Jedi");
		label1.setBounds(150, 20, 100, 20);
		label1.setFont(new Font("Arial", 1, 14));
		add(label1);
		
		JLabel label2 = new JLabel("Jedi");
		label2.setBounds(580, 20, 100, 20);
		label2.setFont(new Font("Arial", 1, 14));
		add(label2);
		
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		separator.setBounds(400, 20, 10, 560);
		add(separator);
		
		final JTextArea orderArea = new JTextArea();
		orderArea.setBounds(10, 50, 380, 250);
		orderArea.setEditable(false);
		orderArea.setBackground(Color.white);
		add(orderArea);
		JScrollPane scroll1 = new JScrollPane(orderArea);
		scroll1.setBounds(10, 50, 380, 250);
		add(scroll1);
		
		final JTextArea jediArea = new JTextArea();
		jediArea.setBounds(410, 50, 380, 250);
		jediArea.setEditable(false);
		jediArea.setBackground(Color.white);
		add(jediArea);
		JScrollPane scroll2 = new JScrollPane(jediArea);
		scroll2.setBounds(410, 50, 380, 250);
		add(scroll2);
		
		JButton orderImport = new JButton("Import");
		orderImport.setBounds(15, 490, 90, 20);
		add(orderImport);
		orderImport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					OrderJedi.orderList.clear();
					ResultSet data = Executor.select("SELECT * FROM JEDI_ORDER");
					while(data.next())
						new OrderJedi(data.getString("ORDER_NAME"));
					for(OrderJedi oj: OrderJedi.orderList)
						orderArea.append(""+oj+"\n");
				}catch (Exception e2) {
					e2.printStackTrace();
				}	
			}
		});
		
		JButton jediImport = new JButton("Import");
		jediImport.setBounds(415, 490, 90, 20);
		add(jediImport);
		jediImport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					KnightsJedi.knightsList.clear();
					ResultSet data = Executor.select("SELECT * FROM JEDI_KNIGHTS");
					while(data.next())
						new KnightsJedi(data.getString("JEDI_NAME"), data.getString("SWORD_COLOR"), data.getInt("FORCE"), data.getString("FORCE_SIDE"));
					for(KnightsJedi kj: KnightsJedi.knightsList)
						jediArea.append(""+kj+"\n");
				}catch (Exception e2) {
					e2.printStackTrace();
				}	
			}
		});
		
		JLabel label3 = new JLabel("Rejestracja Zakonu Jedi");
		label3.setBounds(100, 310, 200, 20);
		label3.setFont(new Font("Arial", 1, 14));
		add(label3);
		
		JLabel label4 = new JLabel("Nazwa:");
		label4.setBounds(20, 340, 50, 20);
		label4.setFont(new Font("Arial", 0, 12));
		add(label4);
		
		JLabel label5 = new JLabel("Rejestracja Jedi");
		label5.setBounds(550, 310, 200, 20);
		label5.setFont(new Font("Arial", 1, 14));
		add(label5);
		
		JLabel label6 = new JLabel("Nazwa:");
		label6.setBounds(420, 340, 50, 20);
		label6.setFont(new Font("Arial", 0, 12));
		add(label6);
		
		final JTextField textField1 = new JTextField();
		textField1.setBounds(120, 340, 250, 20);
		add(textField1);
		
		final JTextField textField2 = new JTextField();
		textField2.setBounds(520, 340, 250, 20);
		add(textField2);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 370, 250, 130);
		textArea.setEditable(false);
		add(textArea);
		JScrollPane scroll3 = new JScrollPane(textArea);
		scroll3.setBounds(120, 370, 250, 130);
		add(scroll3);
		
		JLabel label7 = new JLabel("Kolor miecza:");
		label7.setBounds(420, 380, 100, 20);
		label7.setFont(new Font("Arial", 0, 12));
		add(label7);
		
		final JComboBox<String> colorBox = new JComboBox<String>();
		colorBox.setBackground(Color.white);
		colorBox.setBounds(520, 380, 250, 20);
		colorBox.addItem("");
		colorBox.addItem("niebieski");
		colorBox.addItem("zielony");
		colorBox.addItem("żółty");
		colorBox.addItem("czerwony");
		add(colorBox);
		
		JLabel label8 = new JLabel("Moc:");
		label8.setBounds(420, 420, 100, 20);
		label8.setFont(new Font("Arial", 0, 12));
		add(label8);
		
		final JSlider slider = new JSlider(0, 1000, 500);
		slider.setBounds(520, 420, 250, 40);
		slider.setMajorTickSpacing(1000);
		slider.setPaintLabels(true);
		add(slider);
		
		JLabel label9 = new JLabel("Strona mocy:");
		label9.setBounds(520, 470, 100, 20);
		label9.setFont(new Font("Arial", 0, 12));
		add(label9);
		
		final JRadioButton dark = new JRadioButton("ciemna");
		dark.setBounds(600, 470, 80, 20);
		dark.setFont(new Font("Arial", 0, 12));
		add(dark);
		
		final JRadioButton bright = new JRadioButton("jasna");
		bright.setBounds(680, 470, 80, 20);
		bright.setFont(new Font("Arial", 0, 12));
		add(bright);
		
		final ButtonGroup side = new ButtonGroup();
		side.add(dark);
		side.add(bright);
		
		JButton register1 = new JButton("Zarejestruj");
		register1.setBounds(150, 550, 100, 20);
		add(register1);
		register1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					Executor.query("INSERT INTO JEDI_ORDER (ORDER_NAME) VALUES ('" + textField1.getText() + "')");
					textField1.setText("");
			}
		});
		
		JButton register2 = new JButton("Zarejestruj");
		register2.setBounds(550, 550, 100, 20);
		add(register2);
		register2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object color = colorBox.getSelectedItem();
				String colorStr = color.toString();
				String sideStr = "";
				if(dark.isSelected() == true)
					sideStr += "ciemna";
				if(bright.isSelected() == true)
					sideStr += "jasna";
				Executor.query("INSERT INTO JEDI_KNIGHTS (JEDI_NAME, SWORD_COLOR, FORCE, FORCE_SIDE) VALUES ('" + textField2.getText() + "', '" + colorStr + "', " + slider.getValue() + ", '" + sideStr + "')");
				KnightsJedi knight = new KnightsJedi(textField2.getText(), colorStr, slider.getValue(), sideStr);
				textArea.append(""+knight + "\n");
				textField2.setText("");
				colorBox.setSelectedItem("");
				slider.setValue(500);
				side.clearSelection();
			}
		});
		
		JButton clear1 = new JButton("Wyczyść");
		clear1.setBounds(270, 550, 100, 20);
		add(clear1);
		clear1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					Executor.query("DELETE FROM JEDI_ORDER WHERE ORDER_NAME = '" + textField1.getText() + "'");
					orderArea.setText("");
					textField1.setText("");
					textArea.setText("");
			}
		});
		
		JButton clear2 = new JButton("Wyczyść");
		clear2.setBounds(670, 550, 100, 20);
		add(clear2);
		clear2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Executor.query("DELETE FROM JEDI_KNIGHTS WHERE JEDI_NAME = '" + textField2.getText() + "'");
				jediArea.setText("");
				textField2.setText("");
				colorBox.setSelectedItem("");
				slider.setValue(500);
				side.clearSelection();
			}
		});
		
		JTextField exportField1 = new JTextField("C:\\Users\\Sara\\Jedi\\orderjedi.txt");
		exportField1.setBounds(120, 510, 250, 20);
		exportField1.setEditable(false);
		add(exportField1);
		
		JButton export1 = new JButton("Eksport");
		export1.setBounds(15, 520, 90, 20);
		add(export1);
		export1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet data = Executor.select("SELECT * FROM JEDI_ORDER");
					while(data.next())
						new OrderJedi(data.getString("ORDER_NAME"));
					
					SaveFile.saveFile("C:\\Users\\Sara\\Jedi\\", "orderjedi.txt", OrderJedi.orderList);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}		
		});
		
		JTextField exportField2 = new JTextField("C:\\Users\\Sara\\Jedi\\knightsjedi.txt");
		exportField2.setBounds(520, 510, 250, 20);
		exportField2.setEditable(false);
		add(exportField2);
		
		JButton export2 = new JButton("Eksport");
		export2.setBounds(415, 520, 90, 20);
		add(export2);
		export2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet data = Executor.select("SELECT * FROM JEDI_KNIGHTS");
					while(data.next())
						new KnightsJedi(data.getString("JEDI_NAME"), data.getString("SWORD_COLOR"), data.getInt("FORCE"), data.getString("FORCE_SIDE"));
					
					SaveFile.saveFile("C:\\Users\\Sara\\Jedi\\", "knightsjedi.txt", KnightsJedi.knightsList);
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		JButton choose = new JButton("Wybierz");
		choose.setBounds(15, 370, 90, 20);
		add(choose);
		choose.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet dataK = Executor.select("SELECT * FROM JEDI_KNIGHTS");
					while(dataK.next())
						new KnightsJedi(dataK.getString("JEDI_NAME"), dataK.getString("SWORD_COLOR"), dataK.getInt("FORCE"), dataK.getString("FORCE_SIDE"));
					
					ResultSet dataO = Executor.select("SELECT * FROM JEDI_ORDER");
					while(dataO.next())
						new OrderJedi(dataO.getString("ORDER_NAME"));
					
					ResultSet data = Executor.select("SELECT * FROM ORDER_KNIGHTS");
					while(data.next()) {
						int orderID = data.getInt("ORDER_ID");
						int knightID = data.getInt("KNIGHT_ID");
						OrderJedi o = OrderJedi.orderList.get(orderID-1);
						KnightsJedi k = KnightsJedi.knightsList.get(knightID-1);
						o.addKnight(k);
						k.addOrder(o);
					}
					//ResultSet ID = Executor.select("SELECT ID_ORDER FROM JEDI_ORDER WHERE ORDER_NAME = '" + textField1 + "'");
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	
		

		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension (800, 600);
	}
}
