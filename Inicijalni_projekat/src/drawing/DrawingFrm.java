package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class DrawingFrm extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupDrawOrSelect = new ButtonGroup();
	private final ButtonGroup buttonGroupShape = new ButtonGroup();
	
	private PnlDrawing pnlDrawing = new PnlDrawing();
	
	private final int OPERATION_DRAWING = 1;
	private final int OPERATION_EDIT_DELETE = 0;
	private int activeOperation = OPERATION_DRAWING;
	
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	private JButton btnDelete;
	private JButton btnModify;
	private JButton btnOuterColor = new JButton("Outer color");
	private JButton btnInnerColor = new JButton("Inner color");
	
	boolean lineWaitingForEndPoint = false;
    private Point startPoint;
    
    private Color outerColor = Color.black;
    private Color innerColor = Color.white;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrm frame = new DrawingFrm();
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
	public DrawingFrm() {
		setTitle("Stefan Cvetkovic IT10/2021");
		setResizable(false);
		//setMinimumSize(new Dimension(1200, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		//JPanel pnlDrawing = new JPanel();
		pnlDrawing.addMouseListener(pnlDrawingClickListener());
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel pnlTool = new JPanel();
		contentPane.add(pnlTool, BorderLayout.NORTH);
		
		JPanel pnlNorthWest = new JPanel();
	
		
		JToggleButton tglbtnDrawing = new JToggleButton("Drawing");
		tglbtnDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setOperationDrawing();
			}
		});
		
		buttonGroupDrawOrSelect.add(tglbtnDrawing);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setOperationEditDelete();
			}
		});
		buttonGroupDrawOrSelect.add(tglbtnSelect);
		GroupLayout gl_pnlNorthWest = new GroupLayout(pnlNorthWest);
		gl_pnlNorthWest.setHorizontalGroup(
			gl_pnlNorthWest.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlNorthWest.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_pnlNorthWest.createParallelGroup(Alignment.TRAILING)
						.addComponent(tglbtnSelect, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addComponent(tglbtnDrawing, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35))
		);
		gl_pnlNorthWest.setVerticalGroup(
			gl_pnlNorthWest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorthWest.createSequentialGroup()
					.addContainerGap()
					.addComponent(tglbtnDrawing)
					.addGap(18)
					.addComponent(tglbtnSelect)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		pnlNorthWest.setLayout(gl_pnlNorthWest);
		
		JPanel pnlNorthTop = new JPanel();
		
		JPanel pnlNorthEast = new JPanel();
		GroupLayout gl_pnlTool = new GroupLayout(pnlTool);
		gl_pnlTool.setHorizontalGroup(
			gl_pnlTool.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTool.createSequentialGroup()
					.addComponent(pnlNorthWest, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlNorthTop, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlNorthEast, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE))
		);
		gl_pnlTool.setVerticalGroup(
			gl_pnlTool.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlNorthTop, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
				.addComponent(pnlNorthWest, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
				.addComponent(pnlNorthEast, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
		);
		
		 tglbtnPoint = new JToggleButton("Point");
		buttonGroupShape.add(tglbtnPoint);
		
		 tglbtnLine = new JToggleButton("Line");
		buttonGroupShape.add(tglbtnLine);
		
		 tglbtnRectangle = new JToggleButton("Rectangle");
		buttonGroupShape.add(tglbtnRectangle);
		
		 tglbtnCircle = new JToggleButton("Circle");
		buttonGroupShape.add(tglbtnCircle);
		
		 tglbtnDonut = new JToggleButton("Donut");
		buttonGroupShape.add(tglbtnDonut);
		GroupLayout gl_pnlNorthEast = new GroupLayout(pnlNorthEast);
		gl_pnlNorthEast.setHorizontalGroup(
			gl_pnlNorthEast.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlNorthEast.createSequentialGroup()
					.addGap(72)
					.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(99))
		);
		gl_pnlNorthEast.setVerticalGroup(
			gl_pnlNorthEast.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorthEast.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_pnlNorthEast.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPoint, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnLine, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnCircle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnDonut, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tglbtnRectangle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		pnlNorthEast.setLayout(gl_pnlNorthEast);
		
		 btnModify = new JButton("Modify");
		btnModify.addActionListener(btnModifyClickListener());
		
		 btnDelete = new JButton("Delete");
		btnDelete.addActionListener(btnDeleteClickListener());
		GroupLayout gl_pnlNorthTop = new GroupLayout(pnlNorthTop);
		gl_pnlNorthTop.setHorizontalGroup(
			gl_pnlNorthTop.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlNorthTop.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addGroup(gl_pnlNorthTop.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnModify, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(34))
		);
		gl_pnlNorthTop.setVerticalGroup(
			gl_pnlNorthTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNorthTop.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnModify)
					.addGap(18)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		pnlNorthTop.setLayout(gl_pnlNorthTop);
		pnlTool.setLayout(gl_pnlTool);
		
		tglbtnDrawing.setSelected(true);
		setOperationDrawing();
	}

	private MouseAdapter pnlDrawingClickListener() {
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Point mouseClick = new Point(e.getX(), e.getY());
				pnlDrawing.deselect();
				
				if(activeOperation == OPERATION_EDIT_DELETE) {
					pnlDrawing.select(mouseClick);
					return;
				}
				
				if(tglbtnPoint.isSelected()) {
					PointDlg pointDlg = new PointDlg();
					pointDlg.setPoint(mouseClick);
					pointDlg.setColors(outerColor);
					pointDlg.setVisible(true);
					
					if(pointDlg.getPoint()!=null)
						pnlDrawing.addShape(pointDlg.getPoint());
					return;
				}
				
				else if(tglbtnLine.isSelected()) {
					if(lineWaitingForEndPoint) {
						
						LineDlg lineDlg = new LineDlg();
						Line line = new Line(startPoint, mouseClick);
						lineDlg.setLine(line);
						lineDlg.setColors(outerColor);
						lineDlg.setVisible(true);
						
						if(lineDlg.getLine()!=null) 
							pnlDrawing.addShape(lineDlg.getLine());
							lineWaitingForEndPoint = false;
							return;
						}
						startPoint=mouseClick;
						lineWaitingForEndPoint = true;
						return;
						
					}
					
					else if(tglbtnRectangle.isSelected()) {
						RectangleDlg rectangleDlg = new RectangleDlg();
						rectangleDlg.setPoint(mouseClick);
						rectangleDlg.setColors(outerColor, innerColor);
						rectangleDlg.setVisible(true);
						
						if(rectangleDlg.getRectangle()!=null)
							pnlDrawing.addShape(rectangleDlg.getRectangle());
						return;
					}
					else if (tglbtnCircle.isSelected()) {
						CircleDlg circleDlg = new CircleDlg();
						circleDlg.setPoint(mouseClick);
						circleDlg.setColors(outerColor, innerColor);
						circleDlg.setVisible(true);
						
						if (circleDlg.getCircle() != null)
							pnlDrawing.addShape(circleDlg.getCircle());
						return;
				}
					else if (tglbtnDonut.isSelected()) {
						DonutDlg donutDlg = new DonutDlg();
						donutDlg.setPoint(mouseClick);
						donutDlg.setColors(outerColor, innerColor);
						donutDlg.setVisible(true);

						if (donutDlg.getDonut() != null)
							pnlDrawing.addShape(donutDlg.getDonut());
						return;
				 
			    }
			}
		};
	}
		private ActionListener btnModifyClickListener() {
			return new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = pnlDrawing.getSelected();
					if(i == -1)
						return;
					
					Shape shape = pnlDrawing.getShape(i);
					
					if (shape instanceof Point) {
						PointDlg pointDlg = new PointDlg();
						pointDlg.setPoint((Point) shape);
						pointDlg.setVisible(true);

						if (pointDlg.getPoint() != null) {
							pnlDrawing.setShape(i, pointDlg.getPoint());
							pnlDrawing.repaint();
						}
					} else if (shape instanceof Line) {
						LineDlg lineDlg = new LineDlg();
						lineDlg.setLine((Line) shape);
						lineDlg.setVisible(true);

						if (lineDlg.getLine() != null) {
							pnlDrawing.setShape(i, lineDlg.getLine());
							pnlDrawing.repaint();
						}
					} else if (shape instanceof Rectangle) {
						RectangleDlg rectangleDlg = new RectangleDlg();
						rectangleDlg.setRectangle((Rectangle) shape);
						rectangleDlg.setVisible(true);

						if (rectangleDlg.getRectangle() != null) {
							pnlDrawing.setShape(i, rectangleDlg.getRectangle());
							pnlDrawing.repaint();
						}

					} else if (shape instanceof Donut) {
						DonutDlg donutDlg = new DonutDlg();
						donutDlg.setDonut((Donut) shape);
						donutDlg.setVisible(true);

						if (donutDlg.getDonut() != null) {
							pnlDrawing.setShape(i, donutDlg.getDonut());
							pnlDrawing.repaint();
						}
					} else if (shape instanceof Circle) {
						CircleDlg circleDlg = new CircleDlg();
						circleDlg.setCircle((Circle) shape);
						circleDlg.setVisible(true);

						if (circleDlg.getCircle() != null) {
							pnlDrawing.setShape(i, circleDlg.getCircle());
							pnlDrawing.repaint();
					}
				}
			}
		};
	}
	
		private ActionListener btnDeleteClickListener() {
			return new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if (pnlDrawing.isEmpty())
						return;
					if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete selected shape?", "Question",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
						pnlDrawing.removeSelected();
				}
			};
		}
		
		private void setOperationDrawing() {
			activeOperation = OPERATION_DRAWING;

			pnlDrawing.deselect();

			btnModify.setEnabled(false);
			btnDelete.setEnabled(false);

			tglbtnPoint.setEnabled(true);
			tglbtnLine.setEnabled(true);
			tglbtnRectangle.setEnabled(true);
			tglbtnCircle.setEnabled(true);
			tglbtnDonut.setEnabled(true);

			btnOuterColor.setEnabled(true);
			btnInnerColor.setEnabled(true);
		}

		private void setOperationEditDelete() {
			activeOperation = OPERATION_EDIT_DELETE;

			btnModify.setEnabled(true);
			btnDelete.setEnabled(true);

			tglbtnPoint.setEnabled(false);
			tglbtnLine.setEnabled(false);
			tglbtnRectangle.setEnabled(false);
			tglbtnCircle.setEnabled(false);
			tglbtnDonut.setEnabled(false);

			btnOuterColor.setEnabled(false);
			btnInnerColor.setEnabled(false);
		}
	}
			
			

