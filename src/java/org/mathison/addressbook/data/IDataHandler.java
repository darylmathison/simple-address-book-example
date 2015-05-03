package org.mathison.addressbook.data;

import java.io.IOException;

import javax.swing.table.TableModel;

public interface IDataHandler {
	public void saveData() throws IOException;
	public void loadData(String filename) throws IOException;
	public TableModel getTableModel();
	
	public int getSize();
	public Person getPerson(int entryNum);
}
