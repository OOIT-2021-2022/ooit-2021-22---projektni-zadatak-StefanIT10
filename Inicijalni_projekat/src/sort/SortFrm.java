package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortFrm extends JFrame {

	private JPanel contentPane;
	private JList sortList = new JList();
	private ArrayList<Circle> arrayLst = new ArrayList<Circle>();
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
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
	public SortFrm() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup().addGap(24)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(86, Short.MAX_VALUE)));
		gl_pnlCentar.setVerticalGroup(gl_pnlCentar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCentar.createSequentialGroup().addContainerGap(47, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addGap(42)));

		JList sortList = new JList();
		scrollPane.setViewportView(sortList);
		sortList.setModel(dlm);
		pnlCentar.setLayout(gl_pnlCentar);

		JPanel pnlEast = new JPanel();
		contentPane.add(pnlEast, BorderLayout.EAST);

		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SortDlg dlgSort = new SortDlg();
				dlgSort.setVisible(true);

				if (dlgSort.getCircle() != null)
					arrayLst.add(dlgSort.getCircle());

				arrayLst.sort(null);
				sortList.setModel(sort());

			}
		});

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		GroupLayout gl_pnlEast = new GroupLayout(pnlEast);
		gl_pnlEast.setHorizontalGroup(gl_pnlEast.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlEast
				.createSequentialGroup().addContainerGap(28, Short.MAX_VALUE)
				.addGroup(gl_pnlEast.createParallelGroup(Alignment.LEADING, false)
						.addComponent(exitButton, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(addButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
				.addGap(20)));
		gl_pnlEast.setVerticalGroup(gl_pnlEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEast.createSequentialGroup().addGap(76).addComponent(addButton).addGap(43)
						.addComponent(exitButton).addContainerGap(86, Short.MAX_VALUE)));
		pnlEast.setLayout(gl_pnlEast);
	}

	public DefaultListModel<Circle> sort() {
		Iterator<Circle> it = arrayLst.iterator();
		DefaultListModel<Circle> dlm2 = new DefaultListModel<Circle>();

		while (it.hasNext()) {
			Circle ci = it.next();
			dlm2.addElement(ci);
		}

		return dlm2;

	}
}
