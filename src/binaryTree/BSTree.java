package binaryTree;

public class BSTree {
    private Node root;
    private long lastTimeInorder = 0;
    private long lastTimePreorder = 0;
    private long lastTimePostorder = 0;

    public BSTree(){
        root = null;
    }

//    public void insert(int data){
//        Node newNode = new Node(data);
//        System.out.println("newnode "+newNode.getData());
//
//        if(root==null){
//            root=newNode;
//            System.out.println("Root");
//            return;
//        }
//
//        Node current = root;
//
//
//        while(true){
//
//            if(data<current.getData()){
//                if(current.getleft()==null){
//                    current.setleft(newNode);
//                    current=newNode;
//                    System.out.println("Left");
//                    return;
//                }else{
//                    current=current.getleft();
//                }
//
//            }else if(data>current.getData()){
//
//                if(current.getright()==null){
//                    current.setright(newNode);
//                    current=newNode;
//                    System.out.println("Right");
//                    return;
//                }else{
//                    current=current.getright();
//                }
//
//            }else{
//                return;
//            }
//
//        }
//
//    }

    public void insert(int data){
        root = insertRecursive(root,data);
    }

    public Node insertRecursive(Node current,int data){
        if(current==null){
            System.out.println("Root node is: " + data);
            System.out.println("Finished");
            return new Node(data);
        }

        if(data < current.getData()){
            System.out.println("Coming Node: "+ data);
            System.out.println("Check Node: "+ current.getData() + " => going to the left subtree");
            current.setleft(insertRecursive(current.getleft(),data));
        }else if(data > current.getData()){
            System.out.println("Coming Node: "+ data);
            System.out.println("Check Node : "+ current.getData() + " => going to the right subtree");
            current.setright(insertRecursive(current.getright(),data));
        }

        return  current;
    }
    public boolean searching(int data){
        if(root == null){
            return false;
        }

        Node current = root;

        while(current != null){
            if(data == current.getData()){
                return true;
            }else if(data < current.getData()){
                current = current.getleft();
            }else{
                current = current.getright();
            }
        }

        return false;
    }

    // left,root,right
    public void inorder(){
        System.out.println("=== Starting Inorder Traversal (Left, Root, Right) ===");
        inorderHelper(root, 0);
        System.out.println("=== Inorder Traversal Complete ===");
        System.out.println();
    }

    private void inorderHelper(Node node, int depth){
        String indent = "    ".repeat(depth);
        System.out.println(indent + "┌─ inorderHelper(depth:" + depth + ") - current-node: " +
                (node != null ? node.getData() : "null"));

        if(node == null){
            System.out.println(indent + "└─ >>> Node is null, returning");
            return;
        }

        System.out.println(indent + "├─ >>> Going LEFT from " + node.getData());
        inorderHelper(node.getleft(), depth + 1);

        System.out.println(indent + "├─ >>> Back to " + node.getData() + " after left subtree");
        System.out.println(indent + "├─ >>> Processing ROOT: " + node.getData());

        long currentTime = System.nanoTime();
        long diff = (lastTimeInorder == 0) ? 0 : (currentTime - lastTimeInorder);
        System.out.println(indent + "│  " + node.getData() + " | Time: " + currentTime + " | Diff: +" + diff + " ns");
        lastTimeInorder = currentTime;

        System.out.println(indent + "├─ >>> Going RIGHT from " + node.getData());
        inorderHelper(node.getright(), depth + 1);

        System.out.println(indent + "└─ >>> Completed subtree at " + node.getData());
    }


    // root,left,right
    public void preorder(){
        System.out.println("=== Starting Preorder Traversal ===");
        preorderHelper(root, 0);
        System.out.println("=== Preorder Traversal Complete ===");
        System.out.println();
    }

    private void preorderHelper(Node node, int depth){
        String indent = "    ".repeat(depth);
        System.out.println(indent + "┌─ preorderHelper(depth:" + depth + ") - current-node: " +
                (node != null ? node.getData() : "null"));

        if(node == null){
            System.out.println(indent + "└─ >>> Node is null, returning");
            return;
        }

        long currentTime = System.nanoTime();
        long diff = (lastTimePreorder == 0) ? 0 : (currentTime - lastTimePreorder);

        System.out.println(indent + "│  " + node.getData() + " | Time: " + currentTime + " | Diff: +" + diff + " ns");
        lastTimePreorder = currentTime;

        System.out.println(indent + "├─ >>> Processing ROOT: " + node.getData());

        System.out.println(indent + "├─ >>> Going LEFT from " + node.getData());
        preorderHelper(node.getleft(), depth + 1);

        System.out.println(indent + "├─ >>> Back to " + node.getData() + " after left subtree");
        System.out.println(indent + "├─ >>> Going RIGHT from " + node.getData());
        preorderHelper(node.getright(), depth + 1);

        System.out.println(indent + "└─ >>> Completed subtree at " + node.getData());
    }

    // left,right,root
    public void postorder(){
        System.out.println("=== Starting Postorder Traversal (Left, Right, Root) ===");
        postorderHelper(root, 0);
        System.out.println("=== Postorder Traversal Complete ===");
        System.out.println();
    }

    private void postorderHelper(Node node, int depth){
        String indent = "    ".repeat(depth);
        System.out.println(indent + "┌─ postorderHelper(depth:" + depth + ") - current-node: " +
                (node != null ? node.getData() : "null"));

        if(node == null){
            System.out.println(indent + "└─ >>> Node is null, returning");
            return;
        }

        System.out.println(indent + "├─ >>> Going LEFT from " + node.getData());
        postorderHelper(node.getleft(), depth + 1);

        System.out.println(indent + "├─ >>> Back to " + node.getData() + " after left subtree");
        System.out.println(indent + "├─ >>> Going RIGHT from " + node.getData());
        postorderHelper(node.getright(), depth + 1);

        System.out.println(indent + "├─ >>> Back to " + node.getData() + " after right subtree");
        System.out.println(indent + "├─ >>> Processing ROOT: " + node.getData() + " (POSTORDER VISIT)");

        long currentTime = System.nanoTime();
        long diff = (lastTimePostorder == 0) ? 0 : (currentTime - lastTimePostorder);
        System.out.println(indent + "│  " + node.getData() + " | Time: " + currentTime + " | Diff: +" + diff + " ns");
        lastTimePostorder = currentTime;

        System.out.println(indent + "└─ >>> Completed and leaving " + node.getData());
    }

    public void deleting(int data){
        root = deleteHelper(root, data);
    }
    private Node deleteHelper(Node node, int data){
        if(node == null){
            return null;
        }

        if(data < node.getData()){
            node.setleft(deleteHelper(node.getleft(), data));
        }else if(data > node.getData()){
            node.setright(deleteHelper(node.getright(), data));
        }else{
            // Node with only one child or no child
            if(node.getleft() == null){
                return node.getright();
            }else if(node.getright() == null){
                return node.getleft();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.setData(minValue(node.getright()));

            // Delete the inorder successor
            node.setright(deleteHelper(node.getright(), node.getData()));
        }

        return node;
    }

    private int minValue(Node node){
        int minValue = node.getData();
        while(node.getleft() != null){
            minValue = node.getleft().getData();
            node = node.getleft();
        }
        return minValue;
    }
    
    public static void main(String[] args) {

        BSTree bst = new BSTree();
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
        bst.insert(3);
        bst.insert(9);

//        if(bst.searching(7)){
//            System.out.println("Found 7");
//        }else{
//            System.out.println("Not Found 7");
//        }


        System.out.println("IN-ORDER:");
        bst.inorder();
        System.out.println("PRE-ORDER:");
        bst.preorder();
        System.out.println("POST-ORDER:");
        bst.postorder();

        bst.deleting(7);
        bst.deleting(5);
        bst.deleting(4);
        bst.deleting(3);
        bst.deleting(9);
    
    }
    
}
