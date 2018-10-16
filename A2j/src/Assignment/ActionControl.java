package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

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
					for(Node node: result)
					{
						SrcSet.add(node.getUtl());
					}
					gui.ResultSet.setListData(SrcSet.toArray());
					gui.ResultSet.repaint();
			}
					
			});
		this.gui.ResultSet.addListSelectionListener(new ListSelectionListener()
				{

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						gui.ResultSet.repaint();
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
			
				});
		
		
	}
	
}
