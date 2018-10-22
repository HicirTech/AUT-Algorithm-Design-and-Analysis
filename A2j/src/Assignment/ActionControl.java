package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * this class is used to control gui for Q3 Q4
 * this will give program MVC
 * @author Luo Zeting ID:16938158
 *
 */
public class ActionControl {
	Q3GUI Q3GUI;
	Spider Q3spider;
	Set<Node> Q3result;
	Q4GUI Q4GUI;
	PageRank Q4pg;
	Set<Node> Q4result;
	ArrayList<Node> Q4Sorted;
	ActionControl(Q3GUI Q3gui, Spider spider,Q4GUI Q4gui,PageRank pg)
	{
		this.Q3GUI=Q3gui;
		this.Q3spider=spider;
		this.Q4GUI = Q4gui;
		this.Q4pg=pg;
	}
	/**
	 * create a Q4 gui frame and add all action listener to Q4 gui
	 */
	public void Q4Begin()
	{
		this.Q4GUI.initialize();
		this.Q4GUI.getFrmAdaassignmentqgui().setVisible(true);
		
		this.Q4GUI.getBtnRunPagerank().addActionListener(new ActionListener()
			{
			
				public void actionPerformed(ActionEvent e) 
				{
					String URL = Q4GUI.getURLinput().getText();
					int deep = Integer.parseInt(Q4GUI.getDeepArea().getText());
					int maxSite = Integer.parseInt(Q4GUI.getMaxNumberSearch().getText());
					int iteration = Integer.parseInt(Q4GUI.getIteartionTimes().getText());
					String keyword = Q4GUI.getKeywordinputarea().getText();
					
					if(Q4GUI.getHttpSelect().getSelectedItem().toString().equalsIgnoreCase("https"))
					{
						URL="https://"+URL;
					}
					else
					{
						URL="http://"+URL;
					}
					
					Q4pg.setup(URL, deep, iteration,maxSite);
					
					if(keyword.length()!=0)
					{
						Q4pg.setKeyWord(keyword);
					}
					
					Q4pg.completeNodes();
					Q4pg.runPageRank();
					Q4GUI.getMatrixArea().setText(Q4pg.printMaxtrix());
					Q4GUI.getMatrixArea().repaint();
					Q4GUI.getVector().setText(Q4pg.printVector());
					Q4GUI.getVector().repaint();
					
					ArrayList<String> SrcSet = new ArrayList<>();
					ArrayList<Node> sortList = new ArrayList<>();
					
					for(Node node : Q4pg.nodes)
					{
						sortList.add(node);
					}
					Collections.sort(sortList);
					Collections.reverse(sortList);
					Q4Sorted = sortList;
					for(Node node : sortList)
					{
						SrcSet.add(node.getUrl());
					}
					
					Q4GUI.getResultList().setListData(SrcSet.toArray());
					Q4GUI.getResultList().repaint();
				}
			});
		
		this.Q4GUI.getResultList().addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				String looking = Q4GUI.getResultList().getSelectedValue().toString();
				
				for(Node e : Q4Sorted)
				{
					if(e.getUrl().equals(looking))
					{
						Q4GUI.getRankArea().setText(String.format("%.3f",e.getCurrentRank()));
					}
				}
				Q4GUI.getRankArea().repaint();
			}
		});
	}

	/**
	 * create a Q3 gui frame and add all action listener to Q3 gui
	 */
	public void Q3Begin()
	{
		this.Q3GUI.frmAdaassignmentquestionagui.setVisible(true);
		//Let gui see able
		
		
		// action for run
		this.Q3GUI.runButton.addActionListener(new ActionListener()
			{
			
				public void actionPerformed(ActionEvent e) 
				{
					
					try
					{
						FileWriter writer = new FileWriter(new File("Q3_output.txt")); // For Question 3 output a file as result
						
						Q3GUI.runButton.setEnabled(false);// only run once
							
						System.out.println("Wait For result, for run time BFS, see console");	
						//get String a simple fix
						String URL = Q3GUI.URLInput.getText();
						if(Q3GUI.httpBox.getSelectedItem().toString().equalsIgnoreCase("http"))
						{
							URL = "http://"+URL;
						}
						else
						{
							URL = "https://"+URL;
						}
						
						if(URL.charAt(URL.length()-1)!='/')
						{
							URL=URL+"/";
						}
						//------simple fix finished

						//get deep and max page to search
						int deep = Integer.parseInt(Q3GUI.BFSinput.getText());
						int max =Integer.parseInt(Q3GUI.MaxPageInput.getText());
						String looking = Q3GUI.KeyWordInput.getText();
						
						//output known information to file
						writer.write("URL : "+URL +"\n");
						writer.write("deep : "+deep+"\n");
						writer.write("max size : "+max +"\n");
						writer.write("key word : ");
						if(looking.length()!=0)
						{
							writer.write(looking+"\n");
						}
						else
						{
							writer.write("no input \n");
						}
						writer.write("=====================result====================\n");
						
						//begin call BFS
						Q3spider.ini(URL, deep, max);
						
						//save BFS result to a static set
						Q3result = Q3spider.getSeen();
						
						// get mete for every node
						for(Node node : Q3result)
						{
							node.completeInformation();							
						}
												
						// if user inputed a keyword 
						boolean isHasKeyinput = Q3GUI.KeyWordInput.getText().length()!=0;		
						
						ArrayList<String> SrcSet = new ArrayList<>();// a set for url output to GUI
				
						for(Node node: Q3result)
						{
							if(isHasKeyinput)
							{
								boolean match = false;
								
								//if key or description has the key word we looking for
								match = node.getKeyWord().toLowerCase().contains(looking.toLowerCase())
										||
										node.getDesc().toLowerCase().contains(looking.toLowerCase());
								
								// add that node to the urlSet display for later
								if(match)
								{
									SrcSet.add(node.getUrl());							
									writer.write("URL : "+node.getUrl()+"\n");
									writer.write("Key word(s)"+node.getKeyWord()+"\n");
									writer.write("Description : "+node.getDesc()+"\n");// same time output it to file
								}
							}
							//if user do not input a key
							else
							{
								// add all node input the putput set
								SrcSet.add(node.getUrl());
								writer.write("URL : "+node.getUrl()+"\n");
								writer.write("Key word(s)"+node.getKeyWord()+"\n");
								writer.write("Description : "+node.getDesc()+"\n\n");// same time output it to file
							}
						}
						
						Q3GUI.ResultSet.setListData(SrcSet.toArray()); // set output data to the URL set we just made
						
						//process finishe update the gui and close the file riter
						Q3GUI.ResultSet.repaint();
						writer.close();
					}
					catch(IOException ioe)
					{
						System.out.println("FAIL ON OUTPUT FILE");
					}

			}
					
			});
		

		this.Q3GUI.ResultSet.addListSelectionListener(new ListSelectionListener()
				{
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						try {
							//get the url we looking for meta
							String looking = Q3GUI.ResultSet.getSelectedValue().toString();
							
							//get key and description from node
							String keyforDisplay = "";
							String descForDisplay= "";
							for(Node node:Q3result)
							{
								if(node.getUrl().equals(looking))
								{
									keyforDisplay=node.getKeyWord();
									descForDisplay = node.getDesc();
								}
							}
							Q3GUI.KeyWordTextArea.setText(keyforDisplay);
							Q3GUI.DescTextArea.setText(descForDisplay);
							
							
							//process finished
							Q3GUI.KeyWordTextArea.repaint();
						}
						catch(NullPointerException e) {
							System.out.println("meta: null,No value!");// if some how the node do not have mete here will catch 
						}
					}			
				});
	}
	
}
