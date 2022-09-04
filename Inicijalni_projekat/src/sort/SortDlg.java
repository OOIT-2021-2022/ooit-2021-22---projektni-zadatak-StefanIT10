package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SortDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Circle circle = null;
	private JTextField textX;
	private JTextField textY;
	private JTextField textRadius;
	private JButton okButton;
	private JButton cancelButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SortDlg dialog = new SortDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SortDlg() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel lblX = new JLabel("X coordinate: ");
		
		JLabel lblY = new JLabel("Y coordinate: ");
		
		JLabel lblRadius = new JLabel("Radius: ");
		
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(75)
							.addComponent(lblRadius))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblX)
									.addGap(18)
									.addComponent(textX, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblY)
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textRadius, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
										.addComponent(textY))))))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						int x = Integer.parseInt(textX.getText());
						int y = Integer.parseInt(textY.getText());
						int radius = Integer.parseInt(textRadius.getText());
						
						circle = new Circle(new Point(x, y), radius);
						dispose();
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
		return circle ;
	}
	
	public void setCircle(Circle circle) {
		textX.setText("" + circle.getCenter().getX());
		textY.setText("" + circle.getCenter().getY());
		textRadius.setText("" + circle.getRadius());
	}
}
