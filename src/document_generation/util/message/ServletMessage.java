package document_generation.util.message;


public class ServletMessage implements Message{

	ServletMessage(){
		this.messageType = MessageType.MISC;
		this.write("");
	}
	
	String message;
	MessageType messageType;
	
	public MessageType getStatus(){
		return this.messageType;
	}
	@Override
	public String read() {
		// TODO Auto-generated method stub
		System.out.println(messageType + ": " + message);
		return message;
		
	}

	@Override
	public void write(String s) {
		// TODO Auto-generated method stub
		this.messageType = MessageType.MISC;
		this.message = s;
		
	}
	public void write(MessageType m , String s){
		write(s);
		this.messageType = m;
		
	}
	public void add(MessageType m, String s){
		String message =  read() + "<br> " + m + ": " +s;
		this.messageType = m;
		this.message = message;
	}

}
