public class Tree {
    Node root;

    Tree(){
        this.root = null;
    }

    void addStudent(Student students){
        try {
            if (searchById(root, students.getId()) != null) {
                throw new Exception("ID " + students.getId() + " already exists. Cannot add duplicate ID.");
            }
            root = insert(root, students);
            System.out.println("Student added: " + students);
        } catch (Exception e) {
            System.out.println("Error while adding student: " + e.getMessage());
        }
    }
    Node searchById(Node root, int id) {
        if (root == null || root.students.getId() == id) {
            return root;
        }
        if (id < root.students.getId()) {
            return searchById(root.left, id);
        } else {
            return searchById(root.right, id);
        }
    }
    Node insert(Node root, Student students){
        if (root == null){
            return new Node(students);
        }
        else {
            if (students.getId() < root.students.getId()){
                root.left = insert(root.left, students);
            }
            else {
                root.right = insert(root.right, students);
            }
        }
        return  root;
    }

    void editStudent(int id, String name, double mark) {
        try {
            Node studentNode = searchNode(root, id);
            if (studentNode != null) {
                studentNode.students.setName(name);
                studentNode.students.setMark(mark);
                System.out.println("Updated student: " + studentNode.students);
            } else {
                throw new Exception("Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while editing student: " + e.getMessage());
        }
    }
    public void deleteStudent(int id) {
        try {
            root = deleteRec(root, id);
            System.out.println("Student with ID " + id + " deleted.");
        } catch (Exception e) {
            System.out.println("Error while deleting student: " + e.getMessage());
        }
    }
    Node deleteRec(Node root, int id) {
        if (root == null) {
            throw new RuntimeException("Student with ID " + id + " not found.");
        }

        if (id < root.students.getId()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.students.getId()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.students = minValue(root.right);
            root.right = deleteRec(root.right, root.students.getId());
        }
        return root;
    }
    Student minValue(Node root) {
        Student minVal = root.students;
        while (root.left != null) {
            minVal = root.left.students;
            root = root.left;
        }
        return minVal;
    }

    Node delete(Node root, int id) {
        if (root == null) return null;

        if (id < root.students.getId()) {
            root.left = delete(root.left, id);
        } else if (id > root.students.getId()) {
            root.right = delete(root.right, id);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node minLargerNode = findMin(root.right);
            root.students = minLargerNode.students;
            root.right = delete(root.right, minLargerNode.students.getId());
        }
        return root;
    }
    private Node findMin(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    Student searchStudent(int id) {
        Node studentNode = searchNode(root, id);
        return studentNode != null ? studentNode.students : null;
    }

    Node searchNode(Node root, int id) {
        if (root == null || root.students.getId() == id) return root;
        if (id < root.students.getId()) return searchNode(root.left, id);
        return searchNode(root.right, id);
    }
    public void displayStudents() {
        try {
            if (root == null) {
                System.out.println("No students to display.");
            } else {
                preOrderTraversal(root);
            }
        } catch (Exception e) {
            System.out.println("Error while displaying students: " + e.getMessage());
        }
    }
    int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    void fillArray(Node root, Student[] array, int[] index) {
        if (root != null) {
            array[index[0]++] = root.students;
            fillArray(root.left, array, index);
            fillArray(root.right, array, index);
        }
    }

    void bubbleSortById(Student[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getId() > array[j + 1].getId()) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    void displaySortedStudents(Student[] array) {
        for (Student student : array) {
            System.out.println(student);
        }
    }
    void sortStudent() {
        if (root == null) {
            System.out.println("No students to sort.");
            return;
        }

        int size = countNodes(root);

        Student[] studentsArray = new Student[size];
        fillArray(root, studentsArray, new int[]{0});
        bubbleSortById(studentsArray);

        System.out.println("Students sorted by ID:");
        displaySortedStudents(studentsArray);
    }
    void selectionSortByName(Student[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].getName().compareToIgnoreCase(array[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }
            Student temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    void sortStudentByName() {
        if (root == null) {
            System.out.println("No students to sort.");
            return;
        }

        int size = countNodes(root);

        Student[] studentsArray = new Student[size];
        fillArray(root, studentsArray, new int[]{0});

        selectionSortByName(studentsArray);
        System.out.println("Students sorted by Name:");
        displaySortedStudents(studentsArray);
    }
    void inOrderTraversal(Node root){
        if (root != null){
            inOrderTraversal(root.left);
            System.out.println(root.students + "");
            inOrderTraversal(root.right);
        }
    }
    void preOrderTraversal(Node root){
        if (root != null){
            System.out.println(root.students + "");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    void postOrderTraversal(Node root){
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.students + "");
        }
    }
}