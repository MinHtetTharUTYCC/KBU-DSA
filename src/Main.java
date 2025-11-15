//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
//    IO.println(String.format("Hello and welcome!"));

//    for (int i = 1; i <= 5; i++) {
//        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        IO.println("i = " + i);
//    }

    Node nodeOne = new Node(5);

    System.out.println("Address of nodeOne: "+ nodeOne);
    System.out.println("The data of nodeOne: "+ nodeOne.getData());
    System.out.println("The next of nodeOne: "+ nodeOne.getNext());

    System.out.println();

    Node nodeTwo = new Node(6);
    nodeTwo.setNext(nodeOne);
    System.out.println("Address of nodeTwo: "+ nodeTwo);
    System.out.println("The data of nodeTwo: "+ nodeTwo.getData());
    System.out.println("The next of nodeTwo: "+ nodeTwo.getNext());

    System.out.println();

    Node nodeThree = new Node(7);
    nodeOne.setNext(nodeThree);
    System.out.println("Address of nodeThree: "+ nodeThree);
    System.out.println("The next of nodeOne: "+ nodeOne.getNext());



}
