package week4.day1;

public class JavaConnection implements DatabaseConnection {
	@Override
	public  void connect() {
		System.out.println("Connection established");
	}
	@Override
	public  void disconnect() {
		System.out.println("Connection disconnected");
	}
	@Override
	public  void executeUpdate() {
		System.out.println("executed and updated");
	}
	public static void main(String[] args) {
		JavaConnection jC= new JavaConnection();
		jC.connect();
		jC.disconnect();
		jC.executeUpdate();
	}
}
