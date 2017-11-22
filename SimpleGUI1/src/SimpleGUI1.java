import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGUI1 implements ActionListener {
	
	static JButton button;
	
	public static void main(String[] args) {
		SimpleGUI1 gui1 = new SimpleGUI1();
		gui1.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		
//		button = new JButton("click me");
//		button.addActionListener(this);
//		
//		frame.getContentPane().add(button);
		
		MyDrawPanel draw = new MyDrawPanel();
		frame.getContentPane().add(draw);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(300, 300);
		
		frame.setVisible(true);
	}
	
	public void changeText() {
		button.setText("I have been clicked");
	}
	
	public void actionPerformed(ActionEvent event) {
		changeText();
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
