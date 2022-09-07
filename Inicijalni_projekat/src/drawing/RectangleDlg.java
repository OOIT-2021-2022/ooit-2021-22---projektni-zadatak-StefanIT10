package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RectangleDlg extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	private JButton okButton;
	private JButton closeButton;
	private JTextField textX;
	private JTextField textY;
	private JTextField textHeight;
	private JTextField textWidth;
	
	private Color innerColor = null;
	private Color outerColor = null;
	private Rectangle rectangle = null;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RectangleDlg dialog = new RectangleDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RectangleDlg() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 457, 346);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel lblX = new JLabel("UpperLeftPoint's X coordinate: ");
		JLabel lblY = new JLabel("UpperLeftPoint's Y coordinate: ");
		JLabel lblHeight = new JLabel("Height: ");
		JLabel lblWidth = new JLabel("Width: ");
		textX = new JTextField();
		textX.setColumns(10);
		textY = new JTextField();
		textY.setColumns(10);
		textHeight = new JTextField();
		textHeight.setColumns(10);
		textWidth = new JTextField();
		textWidth.setColumns(10);
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
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGap(37)
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
										.addComponent(lblX)
										.addComponent(lblY)))
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGap(87)
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblWidth)
										.addComponent(lblHeight))))
							.addGap(29)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(textHeight, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(textY, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(textWidth, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(textX, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(84)
							.addComponent(outerColorButton)
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addComponent(innerColorButton)
							.addGap(34)))
					.addGap(68))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX))
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWidth)))
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHeight)))
					.addGap(35)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(outerColorButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(innerColorButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(38))
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
							int Width = Integer.parseInt(textWidth.getText());
							int Height = Integer.parseInt(textHeight.getText());
							
							if(X<0 || Y<0 || Width<1 || Height<1) {
								JOptionPane.showMessageDialog(null, "Incorrect values!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							rectangle = new Rectangle(new Point(X, Y), Width, Height, false, outerColor, innerColor);
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
						.addGap(107)
						.addComponent(okButton)
						.addGap(118)
						.addComponent(closeButton)
						.addGap(120))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(closeButton)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public void setPoint(Point point) {
		textX.setText("" + point.getX());
		textY.setText("" + point.getY());
	}
	
	public void setColors(Color outerColor, Color innerColor) {
		this.outerColor=outerColor;
		this.innerColor=innerColor;
	}
	
	public void setRectangle(Rectangle rectan) {
		textX.setText("" + rectan.getUpperLeftPoint().getX());
		textY.setText("" + rectan.getUpperLeftPoint().getY());
		textWidth.setText("" + rectan.getWidth());
		textHeight.setText("" + rectan.getHeight());
		outerColor = rectan.getColor();
		innerColor = rectan.getInnerColor();
	}

}
