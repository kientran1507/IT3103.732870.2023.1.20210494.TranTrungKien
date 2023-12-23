//TranTrungKien-20210494

package hust.soict.ite6.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame{
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;
	
	// Constructor to setup the GUI components and event handlers
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new JLabel("Enter an Integer: "));
		
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new JLabel("The Accumulated Sum is: "));
		
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("Swing Accumulator");
		setSize(350, 120);
		
		// Add a WindowListener to handle the close button
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose(); // Close the frame
            }
        });
        
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	
	public class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			try {
				int numberIn = Integer.parseInt(tfInput.getText());
				sum += numberIn;
				tfInput.setText("");
				tfOutput.setText(sum + "");
			} catch (NumberFormatException e){
				tfInput.setText("Invalid input");
			}
			
		}
	}
}