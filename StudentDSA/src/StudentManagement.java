public class StudentManagement {
    private Node head;

    public StudentManagement() {
        this.head = null;
    }

    public void addStudent(Students student) {
        try {
            Node temp = head;
            while (temp != null) {
                if (temp.getStudent().getId().equals(student.getId())) {
                    System.out.println("Error: Student with ID " + student.getId() + " already exists.");
                    return;
                }
                temp = temp.getNext();
            }
            Node newNode = new Node(student);
            if (head == null) {
                head = newNode;
            } else {
                temp = head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
            }
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error while adding student: " + e.getMessage());
        }
    }

    public void editStudent(String id, String name, double mark) {
        try {
            Node temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.getStudent().getId().equals(id)) {
                    temp.getStudent().setName(name);
                    temp.getStudent().setMark(mark);
                    System.out.println("Student updated successfully.");
                    found = true;
                    break;
                }
                temp = temp.getNext();
            }
            if (!found) {
                System.out.println("Error: Student with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error while editing student: " + e.getMessage());
        }
    }

    public void deleteStudent(String id) {
        try {
            if (head == null) {
                throw new IllegalArgumentException("Student list is empty. No ID to delete.");
            }

            if (head.getStudent().getId().equals(id)) {
                head = head.getNext();
                System.out.println("Student with ID " + id + " deleted successfully.");
                return;
            }

            Node temp = head;
            while (temp.getNext() != null) {
                if (temp.getNext().getStudent().getId().equals(id)) {
                    temp.setNext(temp.getNext().getNext());
                    System.out.println("Student with ID " + id + " deleted successfully.");
                    return;
                }
                temp = temp.getNext();
            }

            throw new IllegalArgumentException("Student ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void bubbleSortStudentsById() {
        try {
            if (head == null || head.getNext() == null) {
                throw new IllegalArgumentException("No students available to sort.");
            }

            boolean swapped;
            do {
                Node current = head;
                Node prev = null;
                Node next = head.getNext();
                swapped = false;

                while (next != null) {
                    if (current.getStudent().getId().compareTo(next.getStudent().getId()) > 0) {
                        swapped = true;
                        if (prev != null) {
                            Node temp = next.getNext();
                            prev.setNext(next);
                            next.setNext(current);
                            current.setNext(temp);
                        } else {
                            Node temp = next.getNext();
                            head = next;
                            next.setNext(current);
                            current.setNext(temp);
                        }
                        prev = next;
                        next = current.getNext();
                    } else {
                        prev = current;
                        current = next;
                        next = next.getNext();
                    }
                }
            } while (swapped);

            System.out.println("Students sorted by ID using bubble sort.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void insertionSortStudentsByMark() {
        if (head == null || head.getNext() == null) return;
        Node sorted = null;

        Node current = head;
        while (current != null) {
            Node next = current.getNext();
            if (sorted == null || sorted.getStudent().getMark() >= current.getStudent().getMark()) {
                current.setNext(sorted);
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.getNext() != null && temp.getNext().getStudent().getMark() < current.getStudent().getMark()) {
                    temp = temp.getNext();
                }
                current.setNext(temp.getNext());
                temp.setNext(current);
            }
            current = next;
        }
        head = sorted;
        System.out.println("Students sorted by mark using insertion sort.");
    }

    public Students searchStudent(String id) {
        try {
            Node temp = head;
            while (temp != null) {
                if (temp.getStudent().getId().equals(id)) {
                    return temp.getStudent();
                }
                temp = temp.getNext();
            }
            throw new IllegalArgumentException("Student with ID " + id + " not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getStudent());
            temp = temp.getNext();
        }
    }
}