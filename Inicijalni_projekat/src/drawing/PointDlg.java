package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PointDlg extends JDialog {
	private JTextField textX;
	private JLabel lblX;
	private JLabel lblY;
	private JTextField textY;
	private JButton okButton;
	private JButton closeButton;
	private JButton colorButton;
	private Color color = null;
	private Color innerColor = null;
	private Point point = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDlg dialog = new PointDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDlg() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 354, 216);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		{
			JPanel pnlCenter = new JPanel();
			getContentPane().add(pnlCenter, BorderLayout.CENTER);
			{
				lblX = new JLabel("X coordinate: ");
			}
			{
				lblY = new JLabel("Y coordinate: ");
			}
			{
				textX = new JTextField();
				textX.setColumns(10);
			}
			textY = new JTextField();
			textY.setColumns(10);
			JButton colorButton = new JButton("Color");
			colorButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					color = JColorChooser.showDialog(null, "Pick a color: ", color);
					
					if(color == null)
						color = color.black;
				}
			});
			GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
			gl_pnlCenter.setHorizontalGroup(
				gl_pnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlCenter.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
							.addComponent(lblX)
							.addComponent(lblY))
						.addGap(38)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textY)
							.addComponent(textX, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGap(55))
					.addGroup(gl_pnlCenter.createSequentialGroup()
						.addGap(106)
						.addComponent(colorButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(121, Short.MAX_VALUE))
			);
			gl_pnlCenter.setVerticalGroup(
				gl_pnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlCenter.createSequentialGroup()
						.addGap(8)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblX))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblY))
						.addGap(26)
						.addComponent(colorButton)
						.addContainerGap(28, Short.MAX_VALUE))
			);
			pnlCenter.setLayout(gl_pnlCenter);
		}
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
							
							if((X<0)||(Y<0)) {
								JOptionPane.showMessageDialog(null, "Incorrect value!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							
							point = new Point(X, Y, false, color);
							dispose();
							
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Incorrect value!", "Error", JOptionPane.ERROR_MESSAGE);
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
						.addGap(66)
						.addComponent(okButton)
						.addGap(96)
						.addComponent(closeButton)
						.addGap(64))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(closeButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	public void setColors(Color edgecolor) {
		this.color = color;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public void setPoint(Point point) {
		textX.setText("" + point.getX());
		textY.setText("" + point.getY());
		color = point.getColor();
	}

}
