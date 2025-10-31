package week3.day2;
//Create a Java class named APIClient and create two methods with the same name passing different input arguments.
public class APIClass {
	//Create single argument method
	public void sendRequest(String endpoint) {
		System.out.println("single argument method");
		System.out.println("Endpoint is "+endpoint);
	}
//Create double arugment method
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus ) {
		System.out.println("multi argument method");
		System.out.println("Endpoint is "+endpoint);
		System.out.println("requestBody is "+requestBody);
		System.out.println("requestStatus is "+requestStatus);

	}
//initializing the object and call the two overloaded methods
	public static void main(String[] args) {
		APIClass api= new APIClass();
		api.sendRequest("123.156.78.90");
		api.sendRequest("987.32.10.52", "Success", true);
}
}
