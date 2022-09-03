package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StackDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Circle circle = null;
	private JTextField textX;
	private JTextField textY;
	private JTextField textRadius;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRadius;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StackDlg dialog = new StackDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StackDlg() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		{
			 lblX = new JLabel("X coordinate: ");
		}
		{
			textX = new JTextField();
			textX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					
					if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			textX.setColumns(10);
		}
		{
			 lblY = new JLabel("Y coordinate: ");
		}
		{
			textY = new JTextField();
			textY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					
					if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			textY.setColumns(10);
		}
		{
			 lblRadius = new JLabel("Radius: ");
		}
		{
			textRadius = new JTextField();
			textRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					
					if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			textRadius.setColumns(10);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(35)
									.addComponent(lblY))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(31)
									.addComponent(lblX)))
							.addGap(18))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblRadius)
							.addGap(33)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textX)
						.addComponent(textRadius)
						.addComponent(textY, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
					.addGap(117))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 okButton = new JButton("OK");
				 okButton.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent arg0) {
				 		
//				 		try {
				 			int x = Integer.parseInt(textX.getText());
				 			int y = Integer.parseInt(textY.getText());
				 			int radius = Integer.parseInt(textRadius.getText());
				            
//				 			if((x<0) || (y<0) || (radius<1)) {
//				 				JOptionPane.showMessageDialog(null, "Wrong input!", "Error", JOptionPane.ERROR_MESSAGE);
//				 				return;
//				 			}
				 			
				 			circle = new Circle(new Point(x,y), radius);
				 			dispose();
//				 		}
//				 		catch(Exception e) {
//				 			JOptionPane.showMessageDialog(null, "Wrong input!", "Error", JOptionPane.ERROR_MESSAGE);
//				 		}
				 		 
				 		  
				 	}
				 });
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				 cancelButton = new JButton("Cancel");
				 cancelButton.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		
				 		dispose();
				 	}
				 });
				 
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Circle getCircle() {
		// TODO Auto-generated method stub
		return circle;
	}

	public void setCircle(Circle circle) {
		textX.setText("" + circle.getCenter().getX());
		textY.setText("" + circle.getCenter().getY());
		textRadius.setText("" + circle.getRadius());
	}

}
