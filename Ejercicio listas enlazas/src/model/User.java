package model;
public class User{
	private String id;
	private User next;
	User(String id){
		this.id=id;
	}
	public void setNext(User next){
		this.next=next;
	}
	public User getNext(){
		return this.next;
	}
	public String getId(){
		return ""+this.id;
	}
}