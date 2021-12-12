package pkg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.StringJoiner;

public class Main {

	public static void main(String[] args) {
//		try (var conn = MySQLConnection.getConnection("root", "toor");
//			 var pstmt = conn.prepareStatement("SELECT * FROM tb_test;");
//			 var rs = pstmt.executeQuery()) {
//
//			while (rs.next()) {
//				var value = rs.getString("cl_test");
//				System.out.println(value);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		Item item = new Item("Biscoito");

		ByteArrayOutputStream byteStream = null;
		try {
			ObjectOutputStream outStream = null;
			try {
				byteStream = new ByteArrayOutputStream();
				outStream = new ObjectOutputStream(byteStream);
				outStream.writeObject(item);
			} finally {
				byteStream.close();
				outStream.close();
			}
			if (byteStream != null)
				System.out.println(byteStream.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Item item2 = null;
		try {
			ObjectInputStream inStream = null;
			try {
				inStream = new ObjectInputStream(new ByteArrayInputStream(byteStream.toByteArray()));
				Object object = inStream.readObject();
				if (object instanceof Item)
					item2 = (Item) object;
			} finally {
				byteStream.close();
				inStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (item2 != null)
			System.out.println(item2);

	}

	static class Item implements Serializable {

		private static final long serialVersionUID = 1L;

		private String name;

		public Item() {
		}

		public Item(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Item [name=" + name + "]";
		}

	}

}
