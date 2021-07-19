
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegisterDAO {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			//System.out.println("connection made");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	public String insert(Member member)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "OK";
//		ResultSet rs;
//		try {
//			//Class.forName("com.mysql.jdbc.Driver");
//			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
//			Statement st = con.createStatement();
//
//			//Statement st = con.createStatement();
//			int i = st.executeUpdate("insert into employees values('"+member.getUname()+"','"+ member.getPassword()+"','"+member.getEmail()+"','"+member.getPhone()+"')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			result = "Data not entered";
//		}
		String sql = "insert into login values(?,?,?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getPhone());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "NO";
		}
		
		return result;
	}

}