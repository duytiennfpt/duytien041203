public class Students {
    private String id;

    private String name;

    private double mark;

    private String rank;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setMark(double mark) {
        this.mark = mark;
        this.rank = rankRate(mark);
    }

    public double getMark() {
        return mark;
    }

    public String getRank() {
        return rank;
    }

    public Students(String id, String name , double mark) {
        this.id = id;
        this.mark = mark;
        this.name = name;
        this.rank = rankRate(mark);
    }
    public String rankRate(double mark) {
        if (mark >=0 && mark < 5.0) return "Fail";
        if (mark >=5.0 && mark < 6.5) return "Medium";
        if (mark >=6.5 && mark < 7.5) return "Good";
        if (mark >= 7.5 && mark <= 9.0) return "Very Good";
        return "Excellent";
    }

    public String toString() {
        return "id: " + id + " name: " + name + " mark: " + mark + " rank: " + rank ;
    }
}