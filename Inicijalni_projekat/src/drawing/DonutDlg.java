package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonutDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JButton closeButton;
	private JTextField textX;
	private JTextField textY;
	private JTextField textRadius;
	private JTextField textInnerRadius;
	private JButton outerColorButton;
	private JButton InnerColorButton;
	
	private Color outerColor = null;
	private Color innerColor = null;
	private Donut donut = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DonutDlg dialog = new DonutDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DonutDlg() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 419, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel lblX = new JLabel("X coordinate(center): ");
		JLabel lblY = new JLabel("Y coordinate(center): ");
		JLabel lblRadius = new JLabel("Radius: ");
		JLabel lblInnerRadius = new JLabel("Inner Radius: ");
		textX = new JTextField();
		textX.setColumns(10);
		textY = new JTextField();
		textY.setColumns(10);
		textRadius = new JTextField();
		textRadius.setColumns(10);
		textInnerRadius = new JTextField();
		textInnerRadius.setColumns(10);
		
		outerColorButton = new JButton("Outer Color");
		outerColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 outerColor = JColorChooser.showDialog(null, "Pick outer color: ", outerColor);
					
					if(outerColor == null) {
						outerColor = Color.black;
					}
			}
		});
		
		InnerColorButton = new JButton("Inner Color");
		InnerColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
               innerColor = JColorChooser.showDialog(null, "Pick inner color: ", innerColor);
				
				if(innerColor == null) {
					innerColor = Color.white;
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblX)
							.addGap(18)
							.addComponent(textX, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblY)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(38)
									.addComponent(lblRadius))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(outerColorButton)
										.addComponent(lblInnerRadius))))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(17)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textInnerRadius, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addComponent(textRadius, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addComponent(textY, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(InnerColorButton)))))
					.addGap(81))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInnerRadius))
					.addGap(37)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(outerColorButton)
						.addComponent(InnerColorButton))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
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
							int InnerRadius = Integer.parseInt(textInnerRadius.getText());
							
							if(X<0 || Y<0 || Radius<1 || InnerRadius<1 || InnerRadius>=Radius) {
								JOptionPane.showMessageDialog(null, "Incorrect values!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							donut = new Donut(new Point(X , Y), Radius, InnerRadius, false, outerColor, innerColor);
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
						.addGap(105)
						.addComponent(okButton)
						.addGap(108)
						.addComponent(closeButton)
						.addGap(91))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(closeButton)
							.addComponent(okButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	public Donut getDonut() {
		return donut;
	}
	
	public void setPoint(Point point) {
		textX.setText("" + point.getX());
		textY.setText("" + point.getY());
	}
	
	public void setColors(Color outerColor, Color innerColor) {
		this.outerColor=outerColor;
		this.innerColor=innerColor;
	}
	
	public void setDonut(Donut donut) {
		textX.setText("" + donut.getCenter().getX());
		textY.setText("" + donut.getCenter().getY());
		textRadius.setText("" + donut.getRadius());
		textInnerRadius.setText("" + donut.getInnerRadius());
		outerColor = donut.getColor();
		innerColor = donut.getInnerColor();
	}

}
