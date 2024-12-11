public class Node {
    private Students students;
    private Node next;

    public Node(Students student){
        this.students = student;
        this.next = null;
    }
    public Students getStudent() {
        return students;
    }

    public void setStudent(Students student) {
        this.students = student;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}