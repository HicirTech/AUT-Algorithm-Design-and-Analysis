package Assignment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
/**
 * this class is GUI for ADA-assignment 2
 * Question 3
 * @author Luo Zeting ID:16938158
 *
 */
public class Q3GUI {

	public JFrame frmAdaassignmentquestionagui;
	public JTextField URLInput;
	public JTextField BFSinput;
	public JTextField KeyWordInput;
	public JList ResultSet; 
	public JComboBox httpBox;
	public JButton runButton;
	public JTextPane KeyWordTextArea;
	public JTextPane DescTextArea;
	public JTextField MaxPageInput;
	
	

	/**
	 * Create the application.
	 */
	public Q3GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmAdaassignmentquestionagui = new JFrame();
		frmAdaassignmentquestionagui.setType(Type.UTILITY);
		frmAdaassignmentquestionagui.setAlwaysOnTop(true);
		frmAdaassignmentquestionagui.setTitle("ADA-Assignment2-Question3-GUI");
		frmAdaassignmentquestionagui.setBounds(100, 100, 1024, 768);
		frmAdaassignmentquestionagui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel httpLable = new JLabel("Http/Https");
		
		JLabel URLlable = new JLabel("URL:");
		
		URLInput = new JTextField();
		URLInput.setColumns(10);
		
		httpBox = new JComboBox() ;
		httpBox.addItem("http");
		httpBox.addItem("https");
		
		runButton = new JButton("Run BFS");
		
		JLabel BfsDeepLable = new JLabel("BFS Depth");
		
		BFSinput = new JTextField();
		BFSinput.setColumns(10);
		
		JLabel lblKeyWord = new JLabel("Key word ");
		
		KeyWordInput = new JTextField();
		KeyWordInput.setColumns(10);
		
		JLabel lblLuoZeting = new JLabel("Luo Zeting 16938158");
		
		ResultSet = new JList(); 
		ResultSet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane set= new JScrollPane(ResultSet,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JLabel lblResualt = new JLabel("Resualt");
		
		JLabel lblKeyWord_1 = new JLabel("Key Words:");
		
		JLabel lblNewLabel_1 = new JLabel("Desctiption");
		
		KeyWordTextArea = new JTextPane();
		KeyWordTextArea.setText("This will show when you select from url from left side,if key input is empty, will show all result\r\n");
		
		DescTextArea = new JTextPane();
		DescTextArea.setText("This will show when you select from url from left side,if key input is empty, will show all result\r\n");
		
		JLabel lblMaxSubPage = new JLabel("Max page number to search\r\n");
		
		MaxPageInput = new JTextField();
		MaxPageInput.setColumns(10);
		
		JLabel lblPleaseInput = new JLabel("\u2190 Please input, it is no way to run infinity website");
		lblPleaseInput.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lblIfNoKey = new JLabel("If no key word input, all result will be showed");
		
		GroupLayout groupLayout = new GroupLayout(frmAdaassignmentquestionagui.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblResualt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
										.addComponent(set, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(DescTextArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
										.addComponent(KeyWordTextArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
										.addComponent(lblKeyWord_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BfsDeepLable)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(BFSinput, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIfNoKey)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblKeyWord)
											.addGap(4)
											.addComponent(KeyWordInput, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(runButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLuoZeting, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(httpBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(URLInput, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(httpLable, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(21)
									.addComponent(URLlable, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(MaxPageInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPleaseInput))
								.addComponent(lblMaxSubPage))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(httpLable)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(URLlable)
							.addComponent(lblMaxSubPage)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(httpBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(URLInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(MaxPageInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPleaseInput))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIfNoKey)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BfsDeepLable)
						.addComponent(BFSinput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKeyWord)
						.addComponent(KeyWordInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(runButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblResualt)
							.addGap(1)
							.addComponent(set, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLuoZeting)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKeyWord_1)
							.addGap(7)
							.addComponent(KeyWordTextArea, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DescTextArea, GroupLayout.PREFERRED_SIZE, 215, Short.MAX_VALUE)
							.addContainerGap())))
		);
		frmAdaassignmentquestionagui.getContentPane().setLayout(groupLayout);
	}
}
