package week4.day1;

public abstract class MySqlConnection implements DatabaseConnection {
	@Override
	public  void connect() {
		System.out.println("Connection established");
	}
	@Override
	
	public  void disconnect(){
		System.out.println("Connection disconnected");
	}
	@Override
	public  void executeUpdate(){
		System.out.println("executed updated");
	}
	public void executeQuery() {
		System.out.println("Execute the query");
		
	}
	
	
}
