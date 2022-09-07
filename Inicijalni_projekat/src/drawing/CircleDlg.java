package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircleDlg extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton okButton;
	private JButton closeButton;
	private JTextField textX;
	private JTextField textY;
	private JTextField textRadius;
	
	private Color outerColor = null;
	private Color innerColor = null;
	private Circle circle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CircleDlg dialog = new CircleDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CircleDlg() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 465, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel lblX = new JLabel("X coordinate(Center): ");
		JLabel lblY = new JLabel("Y coordinate(Center): ");
		JLabel lblRadius = new JLabel("Radius: ");
		textX = new JTextField();
		textX.setColumns(10);
		textY = new JTextField();
		textY.setColumns(10);
		textRadius = new JTextField();
		textRadius.setColumns(10);
		JButton outerColorButton = new JButton("Outer color");
		outerColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                outerColor = JColorChooser.showDialog(null, "Pick outer color: ", outerColor);
				
				if(outerColor == null) {
					outerColor = Color.black;
				}
			}
		});
		JButton innerColorButton = new JButton("Inner color");
		innerColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              innerColor = JColorChooser.showDialog(null, "Pick inner color: ", innerColor);
				
				if(innerColor == null) {
					innerColor = Color.white;
				}
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(47)
							.addComponent(outerColorButton)
							.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
							.addComponent(innerColorButton)
							.addGap(29))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addComponent(lblX)
							.addGap(18)
							.addComponent(textX, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblY)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGap(31)
									.addComponent(lblRadius)))
							.addGap(18)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(textRadius, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
								.addComponent(textY, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
					.addGap(59))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(outerColorButton)
						.addComponent(innerColorButton))
					.addContainerGap())
		);
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							int X = Integer.parseInt(textX.getText());
							int Y = Integer.parseInt(textY.getText());
							int Radius = Integer.parseInt(textRadius.getText());
							
							
							if(X<0 || Y<0 || Radius<1) {
								JOptionPane.showMessageDialog(null, "Incorrect values!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							circle = new Circle(new Point(X, Y), Radius, false, outerColor, innerColor);
							dispose();
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Incorrect values!", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				closeButton = new JButton("Close");
				closeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				closeButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(115)
						.addComponent(okButton)
						.addGap(119)
						.addComponent(closeButton)
						.addGap(109))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(closeButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public void setPoint(Point point) {
			textX.setText("" + point.getX());
			textY.setText("" + point.getY());
		
	}
	
	public void setColors(Color outerColor, Color innerColor) {
		this.outerColor=outerColor;
		this.innerColor=innerColor;
	}
	
	public void setCircle(Circle circle) {
		textX.setText("" + circle.getCenter().getX());
		textY.setText("" + circle.getCenter().getY());
		textRadius.setText("" + circle.getRadius());
		outerColor = circle.getColor();
		innerColor = circle.getInnerColor();
	}

}
