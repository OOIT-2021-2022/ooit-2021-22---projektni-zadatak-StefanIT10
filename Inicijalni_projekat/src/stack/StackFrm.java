package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StackFrm extends JFrame {

	private JPanel contentPane;
	JList stackList = new JList();
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrm frame = new StackFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrm() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		pnlCentar.setLayout(gl_pnlCentar);
		
		JPanel pnlEast = new JPanel();
		contentPane.add(pnlEast, BorderLayout.EAST);
		
		JButton addButton = new JButton("Add");
		
		JButton deleteButton = new JButton("Delete");
		GroupLayout gl_pnlEast = new GroupLayout(pnlEast);
		gl_pnlEast.setHorizontalGroup(
			gl_pnlEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEast.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_pnlEast.createParallelGroup(Alignment.LEADING)
						.addComponent(addButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
						.addComponent(deleteButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_pnlEast.setVerticalGroup(
			gl_pnlEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEast.createSequentialGroup()
					.addGap(70)
					.addComponent(addButton)
					.addGap(40)
					.addComponent(deleteButton)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		pnlEast.setLayout(gl_pnlEast);
	}
}
