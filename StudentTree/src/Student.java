public class Student {
    int id;

    String name;

    double mark;

    String rank;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Student(int id, String name , double mark) {
        this.id = id;
        this.mark = mark;
        this.name = name;
        this.rank = rankRate();
    }

    private String rankRate(){
        if (mark >=0 && mark < 5.0) return "Fail";
        if (mark >=5.0 && mark < 6.5) return "Medium";
        if (mark >=6.5 && mark < 7.5) return "Good";
        if (mark >= 7.5 && mark <= 9.0) return "Very Good";
        return "Excellent";
    }
    @Override
    public String toString() {
        return   "Id: " + id + '\''+ " Name: " + name + '\'' + "Mark: " + mark + '\'' + " Rank: " + rank ;
    }
}