package org.mathison.addressbook.data;

import java.io.IOException;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


class HandlerTableModel extends AbstractTableModel implements TableModel {

	public IDataHandler handler;
	private String[] columnNames = {
									"Id",
									"Name",
									"Phone Number",
									"Street",
									"City",
									"State",
									"Zipcode"
									};

	public HandlerTableModel(IDataHandler handler) {
		this.handler = handler;
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return Person.NUM_OF_DATA_ITEMS + Address.NUM_OF_DATA_ITEMS - 1;
	}

	@Override
	public int getRowCount() {
		return handler.getSize();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Person per = handler.getPerson(arg0);
		
		switch(arg1) {
		case 0:
			return String.valueOf(per.getId());
		case 1:
			return (String)(per.getLastName() + ", " + per.getFirstName());

		case 2:
			return per.getPhoneNum();

		case 3:
			return per.getAddress().getStreet();

		case 4:
			return per.getAddress().getCity();

		case 5:
			return per.getAddress().getState();

		case 6:
			return per.getAddress().getZip();

		default:
			return "Column not accounted for";

		}
	}

}
