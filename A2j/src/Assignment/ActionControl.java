package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionControl {
	Q3GUI gui;
	Spider spider;
	Set<Node> result;
	ActionControl(Q3GUI gui, Spider spider)
	{
		this.gui=gui;
		this.spider=spider;
	}
	
	public void Begin()
	{
		this.gui.frmAdaassignmentquestionagui.setVisible(true);
		this.gui.runButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					gui.runButton.setEnabled(false);
					System.out.println("Wait For result, for run time BFS, see console");					
					String URL = gui.URLInput.getText();
					if(gui.httpBox.getSelectedItem().toString().equalsIgnoreCase("http"))
					{
						URL = "Http://"+URL;
					}
					else
					{
						URL = "Https://"+URL;
					}
					if(URL.charAt(URL.length()-1)!='/')
					{
						URL=URL+"/";
					}
					int deep = Integer.parseInt(gui.BFSinput.getText());
					spider.ini(URL, deep);
					result = spider.getSeen();
					ArrayList<String> SrcSet = new ArrayList<>();

					boolean isHasKeyinput = gui.KeyWordInput.getText().length()!=0;
					for(Node node: result)
					{
						if(isHasKeyinput)
						{
							boolean match = false;
							ArrayList<String> unCheckResultMeta = spider.leg.getMeta(node.getUrl());
							if(unCheckResultMeta.size()!=0)
							{
								for(String keyOrDec: unCheckResultMeta)
								{
									if(keyOrDec.toLowerCase().contains(gui.KeyWordInput.getText().toString().toLowerCase()))
									{
										match=true;
									}
								}
							}
							if(match)
							{
								SrcSet.add(node.getUrl());
							}
						}
						else
						{
							SrcSet.add(node.getUrl());
						}
					}
					
					gui.ResultSet.setListData(SrcSet.toArray());
					gui.ResultSet.repaint();
			}
					
			});
		this.gui.ResultSet.addListSelectionListener(new ListSelectionListener()
				{

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
					try {
						//gui.ResultSet.repaint();
						System.out.println(gui.ResultSet.getSelectedValue());
					//	gui.KeyWordTextArea.setText(
						ArrayList<String> mateSet = spider.leg.getMeta(gui.ResultSet.getSelectedValue().toString());
						String keyforDisplay = "";
						String descForDisplay= "";
						for(String e:mateSet)
						{
							System.out.println(e);
							if(e.toLowerCase().contains("key"))
							{
								keyforDisplay =e;
							}
							else if(e.toLowerCase().contains("desc"))
							{
								descForDisplay=e;
							}
						}
						gui.KeyWordTextArea.setText(keyforDisplay);
						gui.DescTextArea.setText(descForDisplay);
						gui.KeyWordTextArea.repaint();
					}
					catch(NullPointerException e) {
						System.out.println("No value!");
					}
					}
			
				});
		
		
	}
	
}
