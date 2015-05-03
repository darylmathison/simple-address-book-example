package org.mathison.addressbook.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.mathison.addressbook.ui.AddressBookFrame;

public class AddressBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new AddressBookFrame();
		//frame.pack();
		frame.setSize(400, 300);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				System.exit(0);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				
				
			}
			
		});
		frame.setVisible(true);

	}

}
