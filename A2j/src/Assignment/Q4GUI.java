package Assignment;


import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * this gui is for ADA assignment 2
 * Question 4 GUI
 * @author Luo Zeting ID:16938158
 *
 */
public class Q4GUI {

	private JFrame frmAdaassignmentqgui;
	private JTextField URLinput;
	private JTextField keywordinputarea;
	private JTextField maxNumberSearch;
	private JTextField DeepArea;
	private JTextField IteartionTimes;
	private JComboBox httpSelect; 
	private JList ResultList;
	private JTextPane MatrixArea;
	private JTextPane rankArea;
	private JButton btnRunPagerank;
	private JTextPane vector;

	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint entry point for gui designer
	 */
	public void initialize() {
		frmAdaassignmentqgui = new JFrame();
		frmAdaassignmentqgui.setAlwaysOnTop( true );
		frmAdaassignmentqgui.setTitle("ADA-Assignment2-Q4-GUI");
		frmAdaassignmentqgui.setType(Type.UTILITY);
		frmAdaassignmentqgui.setBounds(100, 100, 1024, 768);
		frmAdaassignmentqgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdaassignmentqgui.getContentPane().setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(21, 21, 46, 29);
		frmAdaassignmentqgui.getContentPane().add(lblUrl);
		
		URLinput = new JTextField();
		URLinput.setBounds(194, 18, 290, 35);
		frmAdaassignmentqgui.getContentPane().add(URLinput);
		URLinput.setColumns(10);
		
		JLabel lblKeyWord = new JLabel("Key Word");
		lblKeyWord.setBounds(485, 21, 108, 29);
		frmAdaassignmentqgui.getContentPane().add(lblKeyWord);
		
		keywordinputarea = new JTextField();
		keywordinputarea.setBounds(614, 18, 327, 35);
		frmAdaassignmentqgui.getContentPane().add(keywordinputarea);
		keywordinputarea.setColumns(10);
		
		JLabel lblIfNoKey = new JLabel("If no key word, will show all result");
		lblIfNoKey.setBounds(485, 68, 456, 29);
		frmAdaassignmentqgui.getContentPane().add(lblIfNoKey);
		
		JLabel lblMaxNumberOf = new JLabel("Max number of website to search");
		lblMaxNumberOf.setBounds(21, 68, 372, 29);
		frmAdaassignmentqgui.getContentPane().add(lblMaxNumberOf);
		
		maxNumberSearch = new JTextField();
		maxNumberSearch.setBounds(396, 65, 88, 35);
		frmAdaassignmentqgui.getContentPane().add(maxNumberSearch);
		maxNumberSearch.setColumns(10);
		
		JLabel lblIfNoKey_1 = new JLabel("please input max number to search, it is no way to run infinty website");
		lblIfNoKey_1.setBounds(21, 98, 847, 29);
		frmAdaassignmentqgui.getContentPane().add(lblIfNoKey_1);
		
		JLabel lblDeep = new JLabel("BFS Depth ");
		lblDeep.setBounds(21, 136, 126, 29);
		frmAdaassignmentqgui.getContentPane().add(lblDeep);
		
		DeepArea = new JTextField();
		DeepArea.setBounds(150, 133, 96, 35);
		frmAdaassignmentqgui.getContentPane().add(DeepArea);
		DeepArea.setColumns(10);
		
		JLabel lblIterationTimes = new JLabel("Iteration times");
		lblIterationTimes.setBounds(267, 136, 194, 29);
		frmAdaassignmentqgui.getContentPane().add(lblIterationTimes);
		
		JLabel lblLuoZeting = new JLabel("Luo Zeting 16938158");
		lblLuoZeting.setBounds(0, 668, 244, 29);
		frmAdaassignmentqgui.getContentPane().add(lblLuoZeting);
		
		IteartionTimes = new JTextField();
		IteartionTimes.setBounds(452, 133, 126, 35);
		frmAdaassignmentqgui.getContentPane().add(IteartionTimes);
		IteartionTimes.setColumns(10);
		
		JLabel lblMatrix = new JLabel("Matrix");
		lblMatrix.setBounds(462, 180, 108, 29);
		frmAdaassignmentqgui.getContentPane().add(lblMatrix);
		
		MatrixArea = new JTextPane();
		MatrixArea.setBounds(462, 208, 383, 429);
		frmAdaassignmentqgui.getContentPane().add(MatrixArea);
		
		 vector = new JTextPane();
		vector.setBounds(882, 208, 59, 429);
		frmAdaassignmentqgui.getContentPane().add(vector);
		
		JLabel lblVector = new JLabel("Final Vector");
		lblVector.setBounds(783, 180, 194, 29);
		frmAdaassignmentqgui.getContentPane().add(lblVector);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(21, 180, 108, 29);
		frmAdaassignmentqgui.getContentPane().add(lblResult);
		
		ResultList = new JList();
		ResultList.setBounds(21, 208, 336, 429);
		frmAdaassignmentqgui.getContentPane().add(ResultList);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setBounds(369, 318, 59, 29);
		frmAdaassignmentqgui.getContentPane().add(lblRank);
		
		rankArea = new JTextPane();
		rankArea.setBounds(369, 348, 64, 40);
		frmAdaassignmentqgui.getContentPane().add(rankArea);
		
		btnRunPagerank = new JButton("Run PageRank");
		btnRunPagerank.setBounds(669, 129, 224, 37);
		frmAdaassignmentqgui.getContentPane().add(btnRunPagerank);
		
		httpSelect = new JComboBox();
		httpSelect.setBounds(76, 18, 96, 35);
		httpSelect.addItem("http");
		httpSelect.addItem("https");
		frmAdaassignmentqgui.getContentPane().add(httpSelect);
	}


	public JFrame getFrmAdaassignmentqgui() {
		return frmAdaassignmentqgui;
	}


	public void setFrmAdaassignmentqgui(JFrame frmAdaassignmentqgui) {
		this.frmAdaassignmentqgui = frmAdaassignmentqgui;
	}


	public JTextField getURLinput() {
		return URLinput;
	}


	public void setURLinput(JTextField uRLinput) {
		URLinput = uRLinput;
	}


	public JTextField getKeywordinputarea() {
		return keywordinputarea;
	}


	public void setKeywordinputarea(JTextField keywordinputarea) {
		this.keywordinputarea = keywordinputarea;
	}


	public JTextField getMaxNumberSearch() {
		return maxNumberSearch;
	}


	public void setMaxNumberSearch(JTextField maxNumberSearch) {
		this.maxNumberSearch = maxNumberSearch;
	}


	public JTextField getDeepArea() {
		return DeepArea;
	}


	public void setDeepArea(JTextField deepArea) {
		DeepArea = deepArea;
	}


	public JTextField getIteartionTimes() {
		return IteartionTimes;
	}


	public void setIteartionTimes(JTextField iteartionTimes) {
		IteartionTimes = iteartionTimes;
	}


	public JComboBox getHttpSelect() {
		return httpSelect;
	}


	public void setHttpSelect(JComboBox httpSelect) {
		this.httpSelect = httpSelect;
	}


	public JList getResultList() {
		return ResultList;
	}


	public void setResultList(JList resultList) {
		ResultList = resultList;
	}


	public JTextPane getMatrixArea() {
		return MatrixArea;
	}


	public void setMatrixArea(JTextPane matrixArea) {
		MatrixArea = matrixArea;
	}


	public JTextPane getRankArea() {
		return rankArea;
	}


	public void setRankArea(JTextPane rankArea) {
		this.rankArea = rankArea;
	}


	public JButton getBtnRunPagerank() {
		return btnRunPagerank;
	}


	public void setBtnRunPagerank(JButton btnRunPagerank) {
		this.btnRunPagerank = btnRunPagerank;
	}


	public JTextPane getVector() {
		return vector;
	}


	public void setVector(JTextPane vector) {
		this.vector = vector;
	}
	
	
	
	
	
}
