package com.singleletpattern;

class Logger{
	static Logger logger;
	//so we cannot create more than one object from this as weonly need one logger instance.
	String mode;
	String path;
	private Logger() {
		mode="debug";
		path="pathoffile";
	}
	//it will only return 1 instance
	public static Logger getInstance() {
		if(logger==null) {
			logger=new Logger();
		}
		return logger;
	}
}
public class SingletPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Logger log1=Logger.getInstance();
       Logger log2=Logger.getInstance();
       System.out.println(log1.mode);
       //it will return true as object is created only once.
       System.out.println(log1==log2);
       
	}

}
