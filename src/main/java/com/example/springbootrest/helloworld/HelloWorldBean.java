package com.example.springbootrest.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	/* If we do not Provide Getter then Automatic Conversion will not happen
	 * 
	 "message": "No converter found for return value of type: class com.example.springbootbasics.HelloWorldBean",
    	"trace": "org.springframework.http.converter.HttpMessageNotWritableException: No converter found for return value of type: class com.example
	  
	 */

}
