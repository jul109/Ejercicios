package ui;
import model.Controller;
import java.util.Scanner;
public class Main{
	public Controller controller;
	public Scanner reader;
	public Main(){
		controller=new Controller();
		reader=new Scanner(System.in);
	}
	public static void main(String[] args){
		Main m=new Main();
		System.out.println("Hola");
		int n=10;
		for (int i=0;i<n ;i++ ) {
			m.controller.addUser(""+i);
		}
		while(true){
			m.menu();
		}
	}
	public void menu(){
		int ans=0;
		String id="";
		while(ans==0){
			System.out.println("1 para mostrar lista");
			System.out.println("2 para add usuario");
			System.out.println("3 para eliminar usuario");

			if(reader.hasNextInt()){
				ans=reader.nextInt();
			}else{
				reader.next();
			}
			switch (ans) {
				case 1:
					System.out.println(controller.show());
					break;
				case 2:
					System.out.println("Escriba el id");
					id=reader.next();
					controller.addUser(id);
					break;
				case 3:
					System.out.println("Escriba el id");
					id=reader.next();
					System.out.println(controller.deleteUser(id));
					break;
				default:
					System.out.println("Error");
			}


		}

	}
}