package org.mathison.addressbook.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

public class DataHandler implements IDataHandler {

	private List<Person> personList;
	private String filename;
	
	DataHandler(String filename) {
		personList = new ArrayList<Person>();
		this.filename = filename;
	}
	
	@Override
	public Person getPerson(int entryNum) {
		
		return personList.get(entryNum);
	}

	@Override
	public int getSize() {
		
		return personList.size();
	}

	@Override
	public TableModel getTableModel() {
		
		return new HandlerTableModel(this);
	}

	@Override
	public void loadData(String filename) throws IOException {
		if (!filename.equals(this.filename)) {
			this.filename = filename;
		}
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		personList.clear();
		int totalnum = in.readInt();
		try {
			for(int i = 0; i < totalnum; i++) {
				personList.add((Person)in.readObject());
			}
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			in.close();
		}
	}

	@Override
	public void saveData() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		try {
			out.writeInt(personList.size());
			for (Person p: personList){
				out.writeObject(p);
			}
		} finally {
			out.close();
		}
	}

}
