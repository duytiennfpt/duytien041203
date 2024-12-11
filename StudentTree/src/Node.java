public class Node {
    Student students;
    Node left, right;
    public Node(Student student){
        this.students = student;
        this.left = this.right = null;
    }
    public Student getStudent() {
        return students;
    }

    public void setStudent(Student student) {
        this.students = student;
    }
}