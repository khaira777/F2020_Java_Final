package gurkiratkhaira_sec004_ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private Button display;

	@FXML
	private TextArea display_area;

	@FXML
	private TextField student;

	@FXML
	void displayAction() {
		try {

			System.out.println("> Start Program ...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("> Driver Loaded successfully.");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD",
					"comp214_f20_145", "password");
			System.out.println("> Database connected successfully.");

			String ct = student.getText();
			String query = "SELECT * FROM student where city='" + ct + "'";

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			StringBuilder sb = new StringBuilder();
			sb.append(
					"Student ID\tFirst N\tLast N\tAddress\t\t\t\tCity\t\t\tProvince\tPostal Code\n-------------------------------------------------------------------------------------------------------------\n");

			while (rs.next()) {
				String id = rs.getString("studentID");
				String fn = rs.getString("firstName");
				String ln = rs.getString("lastName");
				String ad = rs.getString("address");
				String cy = rs.getString("city");
				String pv = rs.getString("province");
				String pc = rs.getString("postalCode");

				sb.append(id + "\t" + fn + "   \t" + ln + "\t" + ad + "  \t" + cy + "\t\t" + pv + "\t\t" + pc + "\n");

			}
			display_area.setText(String.valueOf(sb));
			st.close();
		} catch (Exception e) {
			System.err.println("Exception:" + e);
			System.err.println(e.getMessage());
		}
	}
}
