package com.facadepattern;

class ApiGateway{
	  UserService userService;
      OrderService orderService;
      PaymentService paymentService;
      public ApiGateway(){
    	 userService=new UserService();
    	 orderService=new OrderService();
    	 paymentService=new PaymentService();
      }
      public String getOrderDetail(String userId,String orderId,String payementId) {
    	 String a= userService.getUserDetails(userId);
    	 String b= orderService.getOrderDetails(orderId);
    	 String c= paymentService.processPayment(payementId);
    	  return a+"\n"+b+"\n"+c;
      }
}
class UserService{
	public String getUserDetails(String userId) {
		return "user deatils for userid " +userId;
	}
}
class OrderService{
	public String getOrderDetails(String orderId) {
		return "item ordered with orderid " +orderId;
	}
}

class PaymentService{
	public String processPayment(String paymentId) {
		return "Processing paymet with paymentid " +paymentId;
	}
}
public class FacadePatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//with facade pattern : all the method will run together so we can use one class and call method
		//that will call all the method
//       UserService userService=new UserService();
//       OrderService orderService=new OrderService();
//       PaymentService paymentService=new PaymentService();
//       userService.getUserDetails("user1");
//       orderService.getOrderDetails("oderid1");
//       paymentService.processPayment("paymentid1");
		
		//withoutfacadepattern
		ApiGateway gateway=new ApiGateway();
		System.out.println(gateway.getOrderDetail("user1", "order1", "payment1"));
		//advantage
		//client is simplipied
		//client is decoupled
		//centralised control //apiugatway gateway can callall thye methods 
	}

}
