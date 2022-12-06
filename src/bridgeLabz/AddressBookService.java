package bridgeLabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressBookService {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Address_book_service"; // table details
		String username = "root"; // MySQL credentials
		String password = "Aditya@120";
		try {
			Class.forName(
					"com.mysql.cj.jdbc.Driver"); // Driver name
			Connection con = DriverManager.getConnection(
					url, username, password);
			System.out.println(
					"Connection Established successfully");
			PreparedStatement st = con.prepareStatement("Select * from contacts");
			PreparedStatement st2= con.prepareStatement("update contacts set city = ? where first_name = ?");
			st2.setString(1,"Delhi");
			st2.setString(2,"Neha");
			boolean result = st2.execute();
			if (result) {
				ResultSet rs = st2.getResultSet();
				while (rs.next()) {
					String firstname = rs.getString("first_name"); // Retrieve name from db
					System.out.println("First Name :"+firstname); // Print result on console

					String lastname = rs.getString("last_name"); // Retrieve name from db
					System.out.println("Last Name :"+lastname); // Print result on console

					String address = rs.getString("Address"); // Retrieve name from db
					System.out.println("Address :"+address); // Print result on console

					String city = rs.getString("city"); // Retrieve name from db
					System.out.println("City :"+city); // Print result on console

					String state = rs.getString("State"); // Retrieve name from db
					System.out.println("State :"+state); // Print result on console

					String Phone_Number = rs.getString("Phone_Number"); // Retrieve name from db
					System.out.println("Phone Number :"+Phone_Number); // Print result on console

					String zip = rs.getString("Zip"); // Retrieve name from db
					System.out.println("Zip :"+zip); // Print result on console

					String emailid = rs.getString("email_id"); // Retrieve name from db
					System.out.println("Email id :"+emailid); // Print result on console
				}
				//            }else{
				//                int rowcount=st.getMaxRows();
				//                System.out.println(rowcount);
				//            }
			} else {
				int rowCount = st2.getUpdateCount();
				System.out.println(rowCount);
			}

			con.close(); // close connection
			System.out.println("Connection Closed....");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
