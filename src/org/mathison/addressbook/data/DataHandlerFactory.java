package org.mathison.addressbook.data;

public class DataHandlerFactory {
	public static IDataHandler getHandler(String filename) {
		return new DataHandler(filename);
	}
}
