package model;

public class House{
	private double area;
	private int floors;

	private House next;
	public House(double area,int floors ){
		this.floors=floors;
		this.area=area;
	}
	public void setNext(House next){
		this.next=next;
	}
	public House getNext(){
		return this.next;
	}
	public String getInfo(){
		String msg="area: "+area+" | floors: "+floors;
		return msg;
	}
}