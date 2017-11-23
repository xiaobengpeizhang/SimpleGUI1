import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGUI1 {
	
	JFrame frame;
	JLabel label;
	
	public static void main(String[] args) {
		SimpleGUI1 gui1 = new SimpleGUI1();
		gui1.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton labelButton = new JButton("Change Label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		MyDrawPanel draw = new MyDrawPanel();
		label = new JLabel("I am a label");
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		frame.getContentPane().add(BorderLayout.CENTER, draw);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
		}
	}
	
	class ColorListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}

class MyDrawPanel extends JPanel {
	
	public void paintComponent(Graphics g) {
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
//		
		Color startColor = new Color(red, green, blue);
		
		red = (int)(Math.random() * 255);
		green = (int)(Math.random() * 255);
		blue = (int)(Math.random() * 255);
		
		Color endColor = new Color(red, green, blue);
		
//		g.setColor(randomColor);
//		g.fillOval(70, 70, 100, 100);
	
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
}
