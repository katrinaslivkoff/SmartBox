package smartbox;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.*;

import mvc.*;

public class ContainerPanel extends AppPanel {
	java.awt.List components;
	public ContainerPanel(AppFactory factory) {
		super(factory);
		Container container = (Container)model;

		this.setLayout(new GridLayout(1, 2));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 1));

		JPanel p = new JPanel();
		JButton button = new JButton("Add");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);

		p = new JPanel();
		button = new JButton("Rem");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);

		p = new JPanel();
		button = new JButton("Run");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);

		add(buttonPanel);

		p = new JPanel();
		components = new java.awt.List(10);
		p.add(components);
		add(p);
	}

	public void propertyChange(PropertyChangeEvent arg0) {
		Container container = (Container)model;
		components.removeAll(); // deprecated
		for(Component c: container.getComponents()) {
			components.add(c.toString());
		}
		super.propertyChange(arg0);
	}

	public static void main(String[] args) {
		AppPanel panel = new ContainerPanel(new ContainerFactory());
		panel.display();
	}
}