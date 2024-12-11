//public class Tree {
//    Node root;
//
//    Tree(){
//        root = null;
//    }
//
//    void insert (Students students){
//        root = insertRec(root, students);
//    }
//    Node insertRec(Node root, Students students){
//        if (root == null){
//            root = new Node(students);
//            return root;
//        }
//        else {
//            if (students.getId() < root.students.getId()){
//                root.left = insertRec(root.left, students);
//            }
//            else{
//                root.right = insertRec(root.right,students);
//            }
//        }
//        return root;
//    }
//
//    boolean search(Students students){
//        return searchRec(root,students);
//    }
//    boolean searchRec(Node root, Students students){
//        if (root == null){
//            return false;
//        }
//        if (root.students.getId() == students.getId()){
//            return true;
//        }
//        if (students.getId() < root.students.getId()){
//            return searchRec(root.left,students);
//        }
//        else {
//            return searchRec(root.right,students);
//        }
//    }
//    void inOrderTraversal(Node root){
//        if (root != null){
//            inOrderTraversal(root.left);
//            System.out.println(root.students + "");
//            inOrderTraversal(root.right);
//        }
//    }
//    void preOrderTraversal(Node root){
//        if (root != null){
//            System.out.println(root.students + "");
//            preOrderTraversal(root.left);
//            preOrderTraversal(root.right);
//        }
//    }
//    void postOrderTraversal(Node root){
//        if (root != null){
//            postOrderTraversal(root.left);
//            postOrderTraversal(root.right);
//            System.out.println(root.students + "");
//        }
//    }
//}