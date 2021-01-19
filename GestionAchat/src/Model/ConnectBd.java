package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBd {
		
		private static Connection connection = null;
		
		public static Connection getConnection() {
			return connection;
		}

		public ConnectBd()
		{
			try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			} catch ( ClassNotFoundException e ) {
			    e.printStackTrace();
			}
			
			String url = "jdbc:mysql://localhost:3306/produits-fournisseurs?serverTimezone=UTC";
			String user = "root";
			String password = "";
			connection = null;
			
			try 
			{
			    connection = DriverManager.getConnection(url, user, password );
			}
			catch(SQLException e)
			{
				System.err.print(e.getMessage());
			}
			
		}
		
		public User getUser(String log, String pass)
		{
			Statement statement;
			try {
				
				statement = connection.createStatement();
				ResultSet res = statement.executeQuery("SELECT * FROM users");
				while(res.next())
				{
					String login = res.getString("login");
					String password = res.getString("password");
					if(login.equals(log) && password.equals(pass))
					{
						return new User(login, password);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
			
		}

}
