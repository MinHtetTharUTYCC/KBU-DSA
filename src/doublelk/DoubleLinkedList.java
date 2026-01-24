package doublelk;

public class DoubleLinkedList {
    MyNode header;
    MyNode tail;

    public void addFirst(int iData){
        MyNode newNode = new MyNode(iData);

        if(header ==null){
            header=tail=newNode;
        }else{
            newNode.setNext(header); //nextNode's next  must be current header
            header.setPrev(newNode); //current header's prev must be newNode

            header = newNode; //update header to be newNode
        }
    }

    public void addLast(int iData){
        MyNode newNode = new MyNode(iData);

        if(header == null && tail == null){
            header = tail = newNode;
        }else {
            tail.setNext(newNode);
            newNode.setPrev(tail);

            tail = newNode;
        }
    }

    public void delFirst(){
        if(header == null){
            System.out.println("No node in the double linked list!!");
        }else if(header==tail){
            header = tail = null;
        }else{
            MyNode newHeader = header.getNext();
            header.setNext(null); //clear the old header
            header = newHeader;
            header.setPrev(null); //set new header's prev to null
        }
    }

    private void delLast() {
        if(header == null){
            System.out.println("No node in the double linked list!!");
        }else if(header==tail){
            header = tail = null;
        }else{
            MyNode newTail = tail.getPrev();
            tail.setPrev(null); //clear old tail
            tail = newTail; //update tail
            tail.setNext(null); //set new tail's next to null
        }
    }

    public void addAnyPos(int position,int newData){
        if(position <=0 ){
            System.out.println("Invalid position!!: " + position);
            return;
        }

        MyNode newNode = new MyNode(newData);

        //if no header
        if(header == null){
            header = tail = newNode;
            return;
        }

        //if first positon
        if(position == 1){ //in-term of index: it's 0
            newNode.setNext(header);
            header.setPrev(newNode);
            header = newNode;
            return;
        }

        MyNode current = header;
        int count = 1;

        //get the node before the desired position
        while(current != null && count < position-1){
            current = current.getNext();
            count++;
        }

        if(current ==null){
            System.out.println("Invalid position: "+ position+ ". Cannot insert");
            return;
        }

        //if tail
        if(current == tail){
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            return;
        }

        //if middle
        newNode.setNext(current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        newNode.setPrev(current);
    }

    public void delAnyPos(int position){
        if(position <= 0) {
            System.out.println("Invalid position: 0! Cannot delete");
            return;
        }
        if(header == null){
            System.out.println("No node in the double linked list!!" + " Cannot delete");
            return;
        }

        //if header
        if(position == 1){
            delFirst();
            return;
        }

        MyNode toDelete = header;
        int count = 1;

        //loop until getting the node to delete
        while(toDelete != null && count < position){
            toDelete = toDelete.getNext();
            count++;
        }

        if(toDelete == null){
            System.out.println("Invalid position: "+ position+ ". Cannot delete");
            return;
        }

        // delete at tail
        if(toDelete == tail){
            delLast();
        } else {
            // delete at middle
            toDelete.getNext().setPrev(toDelete.getPrev());
            toDelete.getPrev().setNext(toDelete.getNext());

            toDelete.setNext(null); //clear
            toDelete.setPrev(null); //clear
        }

        System.out.println("Node SUCCESSFULLY deleted at position: " + position);
    }

    public MyNode getHeader(){
        System.out.println("The header node is: " + header.getIData());
        return header;
    }
    public MyNode getTail(){
        System.out.println("The tail node is: " + tail.getIData());
        return tail;
    }

    private void traversal(){
        if(header == null){
            System.out.println("No node in the double linked list!!");
        } else {
            MyNode current = header;
            while (current != null){
                System.out.println("Node in the double linked list: "+ current.getIData());
                current = current.getNext();
            }
        }
    }

    private void searching(int searchData){
        System.out.println("Searching for: " + searchData + " in the double linked list...");
        if(header == null){
            System.out.println("No node in the double linked list!!");
        }else {
            MyNode current = header;
            boolean found = false;

            //while current node exists
            while (current != null){
                if(current.getIData()==searchData){
                    System.out.println(searchData + " is found in the double linked list");
                    found = true;
                    break; //stop searching if data is found
                }
                current = current.getNext();
            }

            if(!found){
                System.out.println(searchData + " is NOT FOUND in the double linked list!!");
            }
        }
    }



    public static void main(String[] args){
        DoubleLinkedList doubleLK = new DoubleLinkedList();

        System.out.println("\nUsing addFirst:");
        doubleLK.addFirst(40);
        doubleLK.addFirst(30);
        doubleLK.addFirst(20);
        doubleLK.getHeader();
        doubleLK.getTail();

        System.out.println("\nUsing addLast:");
        doubleLK.addLast(50);
        doubleLK.addLast(60);
        doubleLK.getHeader();
        doubleLK.getTail();

        System.out.println("\nUsing delFirst:");
        doubleLK.delFirst();
        doubleLK.getHeader();

        System.out.println("\nUsing delLast:");
        doubleLK.delLast();
        doubleLK.getTail();

        System.out.println("\nUsing traversal:");
        doubleLK.traversal();

        System.out.println("\nUsing searching:");
        doubleLK.searching(30);
        doubleLK.searching(40);
        doubleLK.searching(50);
        // Not found case
        doubleLK.searching(90);

        System.out.println("\nUsing addAnyPos");
        doubleLK.addAnyPos(2,35);
        doubleLK.addAnyPos(5,60);
        System.out.println("\nUsing traversal:"); //check
        doubleLK.traversal();

        System.out.println("\nUsing delAnyPos");
        doubleLK.delAnyPos(4);
        System.out.println("\nUsing traversal:"); //check
        doubleLK.traversal();

    }
}
