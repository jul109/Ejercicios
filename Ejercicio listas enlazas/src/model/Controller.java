package model;
public class Controller{
	public User head;
	public User tail;
	public Controller(){

	}
	public void addUser(String n){
		User newUser= new User(n);
		addUser(newUser);
	}
	public String show(){
		User current=head;
		

		//forma iterativa
		String msg="";
		while(true){
			msg+=current.getId();
			if(current.getNext()!=null){
				current=current.getNext();
			}else{
				break;
			}
		}
		return msg;
		//return show(head);
	}
	private void addUser(User newUser){

		if(head==null){
			head=newUser;
			tail=newUser;
		}else{
			newUser.setNext(head);
			head=newUser;
		}
	}
	public String show(User current){
		//forma recursiva
		String msg="";
		if(current.getNext()==null){
			msg=current.getId()+"end";
		}else{
			msg+=current.getId()+show(current.getNext());
		}
		return msg;
	}

	public String deleteUser(String target){
		String msg="";
		if(head!=null){
			msg=deleteUser(head,null,target)
		}else{
			msg="La lista esta vacia";
		}
		return msg;
	}

	public String deleteUser(User current, User previous, String target){
		String msg="";
		if(target.equals( current.getId() )){
			if(current==head){
				head=current.getNext();
				current.setNext(null);
			}else if(current==tail){
				tail=previous;
				tail.setNext(null);
			}else{
				previous.setNext(current.getNext());
				current.setNext(null);
			}
			msg="Se elimino";
		}else{
			if(current.getNext()==null){
				msg="No se encontro nada";
			}else{
				msg=deleteUser(current.getNext(), current, target);
			}
		}
		return msg;
		

	}


	
}