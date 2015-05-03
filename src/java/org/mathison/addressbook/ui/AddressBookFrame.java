package org.mathison.addressbook.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.mathison.addressbook.data.IDataHandler;

public class AddressBookFrame extends JFrame {
	IDataHandler dataHandler;
	JTable table;
	JButton newBtn;
	JButton addBtn;
	JButton editBtn;
	JButton openBtn;
	JButton delBtn;
	JButton closeBtn;
	JButton quitBtn;
	JButton saveBtn;
	JButton saveAsBtn;
	
	public AddressBookFrame() {
		init();
	}
	
	void init() {
		dataHandler = null;
		//table.setModel(dataHandler.getTableModel());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel tablePanel = new JPanel();
		table = new JTable();
		
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(table, BorderLayout.CENTER);
		
		JPanel upperButtonBar = new JPanel();
		JPanel lowerButtonBar = new JPanel();
		
		newBtn = new JButton("New");
		addBtn = new JButton("Add");
		editBtn = new JButton("Edit");
		delBtn  = new JButton("Delete");
		openBtn = new JButton("Open");
		closeBtn = new JButton("Close");
		quitBtn = new JButton("Quit");
		saveBtn = new JButton("Save");
		saveAsBtn = new JButton("Save As...");
		
		
		addBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog dialog = new AddEntryDialog(AddressBookFrame.this);
				dialog.setVisible(true);
			}
			
		});
		
		quitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		upperButtonBar.add(addBtn);
		upperButtonBar.add(editBtn);
		upperButtonBar.add(delBtn);
		
		lowerButtonBar.add(newBtn);
		lowerButtonBar.add(saveBtn);
		lowerButtonBar.add(saveAsBtn);
		lowerButtonBar.add(quitBtn);
		
		tablePanel.add(upperButtonBar, BorderLayout.SOUTH);
		mainPanel.add(lowerButtonBar, BorderLayout.SOUTH);
		mainPanel.add(tablePanel);
		setContentPane(mainPanel);
	}
}
