package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDlg extends JDialog {

	private final JPanel pnlCenter = new JPanel();
	
	private JLabel lblstartPointX;
	private JLabel lblstartPointY;
	private JLabel lblendPointX;
	private JLabel lblendPointY;
	
	private JTextField textStartPointX;
	private JTextField textStartPointY;
	private JTextField textEndPointX;
	private JTextField textEndPointY;
	
	private JButton okButton;
	private JButton closeButton;
	private JButton colorButton;
	private Color color = null;
	private Line line = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LineDlg dialog = new LineDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LineDlg() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 454, 327);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		{
			lblstartPointX = new JLabel("Starting point's X coordinate: ");
		}
		{
			lblstartPointY = new JLabel("Starting point's Y coordinate: ");
		}
		{
			lblendPointX = new JLabel("Ending point's X coordinate: ");
		}
		{
			lblendPointY = new JLabel("Ending point's Y coordinate: ");
		}
		textStartPointX = new JTextField();
		textStartPointX.setColumns(10);
		textStartPointY = new JTextField();
		textStartPointY.setColumns(10);
		textEndPointX = new JTextField();
		textEndPointX.setColumns(10);
		textEndPointY = new JTextField();
		textEndPointY.setColumns(10);
		JButton colorButton = new JButton("Color");
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				color = JColorChooser.showDialog(null, "Pick a color: ", color);
				
				if(color==null) {
					color = color.black;
				}
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblstartPointY)
								.addComponent(lblstartPointX)
								.addComponent(lblendPointX)
								.addComponent(lblendPointY))
							.addGap(33)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textEndPointY)
								.addComponent(textEndPointX)
								.addComponent(textStartPointY)
								.addComponent(textStartPointX, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(163)
							.addComponent(colorButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblstartPointX)
						.addComponent(textStartPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblstartPointY)
						.addComponent(textStartPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblendPointX)
						.addComponent(textEndPointX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblendPointY)
						.addComponent(textEndPointY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(colorButton)
					.addContainerGap(19, Short.MAX_VALUE))
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
							int startPointX = Integer.parseInt(textStartPointX.getText());
							int startPointY = Integer.parseInt(textStartPointY.getText());
							int endPointX = Integer.parseInt(textEndPointX.getText());
							int endPointY = Integer.parseInt(textEndPointY.getText());
							
							/*
							if(startPointX<0 || startPointY<0 || endPointX<0 || endPointY<0) {
								JOptionPane.showMessageDialog(null, "Incorrect values!", "Error", JOptionPane.ERROR_MESSAGE);
								return;
							}
							*/
							line = new Line(new Point(startPointX, startPointY), new Point(endPointX, endPointY), false, color);
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
						.addGap(112)
						.addComponent(okButton)
						.addGap(96)
						.addComponent(closeButton)
						.addGap(108))
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
	
	public void setColors(Color edgecolor) {
		this.color = color;
		}
	
	public Line getLine() {
		return line;
	}
	
	public void setStartPoint(Point point) {
		textStartPointX.setText("" + point.getX());
		textStartPointY.setText("" + point.getY());
	}
	
	public void setEndPoint(Point point) {
		textEndPointX.setText("" + point.getX());
		textEndPointY.setText("" + point.getY());
	}
	
	public void setLine(Line line) {
		textStartPointX.setText("" + line.getStartPoint().getX());
		textStartPointY.setText("" + line.getStartPoint().getY());
		textEndPointX.setText("" + line.getEndPoint().getX());
		textEndPointY.setText("" + line.getEndPoint().getY());
		color = line.getColor();
	}
	

}
