public class LinkedList {
    private Node header;
    private Node tail;

    public Node getHeader() {
        System.out.println("Header data is: " + header.getData());
        return header;
    }

    public Node getTail() {
        System.out.println("Tail data is: " + tail.getData());
        return tail;
    }

    public LinkedList(){
        header = null;
    }
    public  void addFirst(int data){
        Node newNode = new Node(data);
        if(header == null){
            header = newNode;
            tail = newNode;
        }else{
            newNode.setNext(header);
            header=newNode;
        }
    }
    public  void addLast(int data){
        Node newNode = new Node(data);
        if(header == null){
            header = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail=newNode;
        }

    }
    public  void addAnyPos(int data,int pos){
        Node newNode = new Node(data);

        // Case1:inset at first
        if(pos==1){
            addFirst(data);
            return;
        }

        // (pos-1)the node
        Node temp = header;
        int count = 1;

        while(temp!=null && count<pos-1){
            temp = temp.getNext();
            count++;
        }

        //if temp is null,position is OUT OF BOUNDS
        if(temp == null){
            System.out.println("Invalid position: " + pos);
            return;
        }

        //Case 2: Insert at last
        if(temp == tail){
            addLast(data);
            return;
        }

        //Case 3: insert in middle
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    public void delFirst(){
        if(header==null){
            System.out.println("No Node in the Linked list");
        }else if(header==tail){
            header=tail=null;
        }else{
            header = header.getNext();
        }
    }
    public void delLast(){
        if(header==null){
            System.out.println("No Node in the Linked list");
            return;
        }

        if(header == tail){
            header = tail = null;
            return;
        }

        Node current = header;
        //get the node before the last
        while(current.getNext() != tail){
            current = current.getNext();
//            System.out.println("current data is: " + current.getData());
        }

        tail.setNext(null); //clear

        current.setNext(null);
        tail = current;

//        Node temp = header;
//        while (temp.getNext()!= tail){
//            temp = temp.getNext();
//        }
//
//        System.out.println("Node deleted successfully");
//        tail = temp;
//        tail.setNext(null);
    }

    public void traverse(){
        if(header==null){
            System.out.println("No node in the Linked list");
        }else{
            Node curr=header;
            while(curr != null){
                System.out.println("Node in the list is: " + curr.getData());
                curr = curr.getNext();
            }
        }
    }
    public void searching(int data){
        System.out.println("Searching for data: " + data);

        if(header==null){
            System.out.println("No Node in the Linked list");
            return;
        }

        Node curr = header;
        boolean found =false;

        while(curr != null){
            if(curr.getData()==data){
                System.out.println("Yes the node: " + data +  " is found in the Linked list");
                found = true;
                break;
            }
            curr = curr.getNext();
        }

        if(!found){
            System.out.println("No the node: " + data + " is NOT FOUND in the Linked list");
        }

//            do{
//                if(curr.getData()==data){
//                    System.out.println("Yes this node is in the Linked list");
//                }
//                curr=curr.getNext();
//                if(curr.getNext() == null){
//                    System.out.println("No this node with data: "+ data +" IS NOT in the Linked list");
//                }
//            }while(curr.getNext()!=null);
    }

    public void delAnyPos(int position){
        if(position <= 0) {
            System.out.println("Invalid position to delete: " + position);
            return;
        }

        if(header==null){
            System.out.println("No Node in the Linked list. Can't delete any position");
            return;
        }

        // Case1: Deletion at the head: position: 1 (in-term of index: it's 0)
        if(position==1){
            delFirst();
            return;
        }

        Node beforeToDelete = header;
        int count= 1;

        //find the node before the one to delete
        while (beforeToDelete != null && count<position-1){
            beforeToDelete = beforeToDelete.getNext();
            count++;
        }

        if(beforeToDelete == null || beforeToDelete.getNext() ==null){
            System.out.println("Invalid position: " + position);
            return;
        }

        Node noteToDelete = beforeToDelete.getNext();

        //Case 2 & 3: Delete in middle or last
        beforeToDelete.setNext(noteToDelete.getNext());

        //if deleted-node is the tail
        if(noteToDelete == tail){
            tail = beforeToDelete;  //update the tail
        }

        //Clear
        noteToDelete.setNext(null);

        System.out.println("Node deleted at position: "+ position + " with data "+ noteToDelete.getData());
    }

    public  static void main(String[] args){
        System.out.println("LINKED LIST DEMO");

        LinkedList list = new LinkedList();

        list.addFirst(70);
        list.addFirst(60);
        list.addFirst(50);

        list.addLast(80);
        list.addLast(90);
        list.addLast(100);

        list.getHeader();
        list.getTail();

        System.out.println("\nUsing traverse");
        list.traverse();

        System.out.println("\nUsing delFirst...");
        list.delFirst();
        list.getHeader();
        list.getTail();

        System.out.println("\nUsing traverse");
        list.traverse();

        System.out.println("\nUsing delLast...");
        list.delLast();
        list.getTail();

        System.out.println("\nUsing traverse");
        list.traverse();

        System.out.println("\nUsing searching...");
        list.searching(90);

        System.out.println("Using delAnyPos");
        list.delAnyPos(2);
        list.traverse();
        list.getHeader();
        list.getTail();

    }
}
