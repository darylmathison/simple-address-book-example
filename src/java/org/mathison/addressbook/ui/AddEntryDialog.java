package org.mathison.addressbook.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddEntryDialog extends JDialog {
	JButton okBtn;
	JButton cancelBtn;
	JTextField lstNameFld;
	JTextField fstNameFld;
	JTextField phNumFld;
	JTextField streetFld;
	JTextField cityFld;
	JTextField stateFld;
	JTextField zipFld;
	
	JLabel     lstNameLbl;
	JLabel     fstNameLbl;
	JLabel     phNumLbl;
	JLabel     streetLbl;
	JLabel     cityLbl;
	JLabel	   stateLbl;
	JLabel     zipLbl;
	
	public AddEntryDialog() {
		init();
		setSize(400, 300);
	}
	
	public AddEntryDialog(JFrame frame) {
		super(frame);
		setSize(400, 300);
		//pack();
		init();
	}
	
	private void init() {
		okBtn = new JButton("Ok");
		cancelBtn = new JButton("Cancel");
		
		JPanel main = new JPanel();
		JPanel btnBar = new JPanel();
		JPanel topPanel = new JPanel();
		
		main.setLayout(new BorderLayout());
		
		FlowLayout btnBarLayout = new FlowLayout();
		btnBarLayout.setAlignment(FlowLayout.RIGHT);
		btnBar.setLayout(btnBarLayout);
		btnBar.add(okBtn);
		btnBar.add(cancelBtn);
		
		initTopPanel(topPanel);
		// work on topPanel
		
		
		main.add(topPanel, BorderLayout.CENTER);
		main.add(btnBar, BorderLayout.SOUTH);
		
		this.setContentPane(main);
	}
	private void initTopPanel(JPanel topPanel) {
		lstNameFld = new JTextField();
		fstNameFld = new JTextField();
		phNumFld = new JTextField();
		streetFld= new JTextField();
		cityFld= new JTextField();
		stateFld= new JTextField();
		zipFld= new JTextField();
		
		lstNameLbl = new JLabel("Last name");
		fstNameLbl = new JLabel("First name");
		phNumLbl = new JLabel("Phone number");
		streetLbl = new JLabel("Street");
		cityLbl = new JLabel("City");
		stateLbl = new JLabel("State");
		zipLbl = new JLabel("Zip code");

		LayoutManager manager = new GridBagLayout();
		topPanel.setLayout(manager);
		
		JLabel[] label = { 
				lstNameLbl,
				fstNameLbl,
				phNumLbl,
				streetLbl,
				cityLbl,
				stateLbl,
				zipLbl
		};
		
		JTextField[] field = {
				lstNameFld,
				fstNameFld,
				phNumFld,
				streetFld,
				cityFld,
				stateFld,
				zipFld
		};
		
		GridBagConstraints fieldGbc = new GridBagConstraints();
		GridBagConstraints labelGbc = new GridBagConstraints();
		
		fieldGbc.gridx = 1;
		fieldGbc.gridy = 0;
		fieldGbc.gridheight = 1;
		fieldGbc.gridwidth = 1;
		fieldGbc.weightx = 1;
		fieldGbc.weighty = 0;
		fieldGbc.fill = GridBagConstraints.HORIZONTAL;
		fieldGbc.anchor = GridBagConstraints.CENTER;
		
		labelGbc.gridx = 0;
		labelGbc.gridy = 0;
		labelGbc.gridheight = 1;
		labelGbc.gridwidth = 1;
		labelGbc.weightx = 0;
		labelGbc.weighty = 0;
		labelGbc.fill = GridBagConstraints.NONE;
		labelGbc.anchor = GridBagConstraints.EAST;
		
		for( int i = 0; i < field.length; i++) {
			topPanel.add(label[i], labelGbc);
			topPanel.add(field[i], fieldGbc);
			labelGbc.gridy++;
			fieldGbc.gridy++;
			
		}
	}
	
	public static void main(String[] argv) {
		JFrame frame = new JFrame();
		
		JDialog dialog = new AddEntryDialog(frame);
		dialog.setVisible(true);
	}
}
