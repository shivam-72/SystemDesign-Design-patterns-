package com.adapterPattern;
interface NotificationService{
	void sendEmail(String to,String content,String title);
}

class EmailNotificationService implements NotificationService{
	public void sendEmail(String to,String subject,String body ) {
		System.out.println("send mail to "+ to);
		System.out.println(subject);
		System.out.println(body);
	}
}
//this is the newservice i want to use instead of EMAILNOTIFICATION SERVICE AND IT SHOULD ADAPT
class GridNotificationService {
	public void sendEmail(String recepient,String title,String content ) {
		System.out.println("send mail to "+ recepient);
		System.out.println(title);
		System.out.println(content);
	}
}
//adapter class 
class SendGridAdapter implements NotificationService{
    private GridNotificationService sendGridNotificationService;
    public SendGridAdapter(GridNotificationService sendGridNotificationService) {
    	this.sendGridNotificationService=sendGridNotificationService;
    }
	@Override
	public void sendEmail(String to, String subject,String body) {
		// TODO Auto-generated method stub
		sendGridNotificationService.sendEmail(to, subject, body);
	}
	
}
public class AdaptarPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotificationService service=new SendGridAdapter(new GridNotificationService());
		service.sendEmail("shivam@gamil.com", "this is a mail", "subject");
	}

}
