package ui;
import model.Builder;
import java.util.Scanner;
public class Main{
	public Scanner reader;
	public Builder builder;
	Main(){
		reader=new Scanner(System.in);
		builder=new Builder();
	}

	public static void main(String[] args){
		Main execute=new Main();
		execute.builder.addFirstHouse(1,1);
		execute.builder.addFirstHouse(2,2);
		execute.builder.addFirstHouse(3,3);

		execute.showMenu();


	}
	public void showMenu(){
		int option=-1;
		boolean execute=true;
		while(execute) {
			System.out.println("1 to add a house");
			System.out.println("2 to show the houses");
			System.out.println("3 to exchange houses");
			System.out.println("4 to show the first house");
			System.out.println("0 to exit ");
			if(reader.hasNextInt()){
				option=reader.nextInt();
			}else{
				reader.next();
			}
			switch(option) {
				case 1:
					addHouse();
					break;
				case 2:
					showHouses();
					break;
				case 3:
					exchangeHouses();
					break;
				case 4:
					showFirstHouse();
					break;
				case 0:
					execute=false;
					break;
				default:
					System.out.println("Error");
			}
		}

	}
	public void addHouse(){
		int floors;
		double area;
		System.out.println("Type the area");
		floors=validateInt();
		System.out.println("Type the number of floors");
		area=validateDouble();
		System.out.println(floors);
		System.out.println(area);
		builder.addFirstHouse(area,floors);
	}
	public void showHouses(){
		String msg=builder.print();
		System.out.println(msg);
	}
	public void showFirstHouse(){
		System.out.println(builder.getFirstHouseInfo());
	}
	public void exchangeHouses(){
		int index1, index2;
		System.out.println("Type the index of the first house");
		index1=validateInt();
		System.out.println("Type the index of the second house");
		index2=validateInt();
		System.out.println(builder.exchangeHouses(index1, index2));
	}

	public int validateInt(){
		int ans=-1;
		while(ans==-1){
			if(reader.hasNextInt()){
				ans=reader.nextInt();
			}else{
				System.out.println("Error");
				reader.next();
			}
		}
		return ans;
	}
	public double validateDouble(){
		double ans=-1;
		while(ans==-1){
			if(reader.hasNextDouble()){
				ans=reader.nextDouble();
			}else{
				System.out.println("Error");
				reader.next();
			}
		}
		return ans;
	}

}