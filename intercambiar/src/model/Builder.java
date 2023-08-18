package model;

public class Builder{
    private House tail;
    private House head;
    public Builder(){

    }
    public void addFirstHouse(double area, int floors){
        House newHouse= new House(area,floors);
        if(head==null){
            this.head=newHouse;
            this.tail=newHouse;
        }else{
            newHouse.setNext(head);
            this.head=newHouse;
        }
    }
    public void addFirstHouse(House newHouse){
        if(head==null){
            this.head=newHouse;
            this.tail=newHouse;
        }else{
            newHouse.setNext(head);
            this.head=newHouse;
        }
    }
    public House getFirstHouse(){
        return this.head;
    }
    private String print(House current){
        String msg="";
        if(head==null){
            msg="This list is empty";
        } else if(current.getNext()!=null){
            msg=current.getInfo()+"  -  "+print(current.getNext());
        }else{
            msg= current.getInfo();
        }
        return msg;
    }

    public String print(){
        return print(head);
    }
    public String getFirstHouseInfo(){
        String msg="";
        if(tail!=null){
            msg=tail.getInfo();
        }else{
            msg="The list is empty";
        }
        return msg;
    }

    public String exchangeHouses(int targetIndex1, int targetIndex2){
        if(targetIndex1<targetIndex2){ //la idea es que el indice1 sea el mayor porque
            //es el que primero se elimina
            //siempre, por eso el cambio
            int aux=targetIndex2;
            targetIndex2=targetIndex1;
            targetIndex1=aux;
        }

        House[] info1=getHouse(targetIndex1,0,head,null); //buscamos el previ
        House house1=info1[0];
        House house1Previous=info1[1];
        
        House[] info2=getHouse(targetIndex2,0,head,null); //aqui la busqueda se inicia 
        //desde el indice 1, para hacerlo todo mas eficiente. Por eso el segundo parametro de la función es
        //targetIndex1 (ese es el current index)
        //luego house1(esa sería la casa actual, correspondiente al current index)
        //
        //ahora mismo da un error
        House house2=info2[0];
        House house2Previous=info2[1];

        System.out.println("House2 info");
        System.out.println(info2[0].getInfo());
        System.out.println(house2.getInfo());
        


        deleteHouse(house1,house1Previous);
        System.out.println("House2 info");
        System.out.println(house2.getInfo());
        deleteHouse(house2,house2Previous);
        addHouse(house1,getHouse(targetIndex2-1,0,head,null)[0]);
        addHouse(house2,getHouse(targetIndex1-1,0,head,null)[0]);
        
        return "El cambio fue exitoso";




    }
    public void deleteHouse(House current, House previous){
        //current= elemento a eliminar
        // previous= elemento previo al que se va a elimnar 
        if(current==head&& current==tail){ //si la lista tan solo tiene un elemento, simplemente
            //head y tail la igualamos a null 
            head=null;
            tail=null;
        }else if(previous==null|| current==head){ //hablamos de que se eliminaria la cabeza que es el
                                            //unicoelemento cuyo previous es null
          
            head=current.getNext(); //hacemos que el siguiente del que estamos sea la cabeza
     

            current.setNext(null); //eliminamos la conexión del elemento actual con la lista


        }else if(current.getNext()==null || current==tail){ //si nuestro elemento no tiene next
            //significa que es la cola
            previous.setNext(null); //hacemos que el elemento anterior al que deseamos eliminar apunte al nulo
            tail=previous; //y que ese elemento sea la cola
        }else{ //aquí sería el caso en el que el elemento es uno que no es ni la cola ni la
            //cabeza. osea nuestro elemento current debe tener previous y next
            previous.setNext(current.getNext()); //hacemos que el next de nuestro previous
            //conecto con el next del elemento a eliminar
            current.setNext(null); //eliminamos la conexión del elemento actual

        }
        System.out.println("Lista con la cosa eliminada");
        System.out.println(print());
    }

    public void addHouse(House newHouse, House previous){
        if(head==null&&tail==null){ //si la head y la tail es nula. Entonces puedo llamar 
            //reutilizar la función addFirstHouse. Eso me pondría a la casa nueva como cabeza y cola
            addFirstHouse(newHouse);
        }else if(previous==null){ //si el previo debe ser nulo, entonces lo que quiere es que el nuevo 
            //sea elemento sea la cabeza, por lo que tambien llamaria a addFirstJouse
            addFirstHouse(newHouse); 
        }else if(previous==tail){ //si el previous de donde lo quiero agregar
            //es la cola, entonces debo meter la newhouse en la ultima posición
            //por lo que el next de la cola actual seria la nueva casa
            //y la nueva cola sería la nueva casa
            tail.setNext(newHouse); 
            tail=newHouse;
        }else{ //aquí es porque no lo quiero agregar ni antes de una cabeza, ni despues de una cola
            newHouse.setNext(previous.getNext()); //el next de mi nueva casa va a ser el
            //mismo next de la casa previa
            previous.setNext(newHouse); //y la casa previa pasa a tener como next a mi casa actual

        }
        
    }

    public House[] getHouse(int targetIndex){
        return getHouse(targetIndex,0,head,null);
    }
    public House[] getHouse(int targetIndex, int currentIndex, House current, House previous){
        House results[]=new House[2];
        if(targetIndex<0){
            results[0]=null;
            results[1]=null;
            return results;
        }
        if(targetIndex==currentIndex){
            results[0]=current;
            results[1]=previous;
            System.out.println("Se encontro la casa"+ targetIndex);
            System.out.println(current.getInfo());
            System.out.println(results[0].getInfo());
            return results;
        }else{
            currentIndex++;
            if(current.getNext()!=null) {
                results=getHouse(targetIndex, currentIndex, current.getNext(), current);
            }
        }
        return results;

    }





}