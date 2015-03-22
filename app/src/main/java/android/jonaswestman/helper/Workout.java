package android.jonaswestman.helper;

public class Workout {

    private int id;
    private String title;
    private int sets;
    private int week;
    private int reps;
    private String day;

    public Workout() {
    }

    public Workout(String title, int sets, int reps, int week, String day) {
        super();
        this.title = title;
        this.sets = sets;
        this.reps = reps;
        this.week = week;
        this.day = day;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSets() {
        return this.sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() { return this.reps; }

    public void setReps(int reps)
    {
        this.reps = reps;
    }

    public int getId() {
        return this.id;
    }

    public int getWeek() { return this.week; }

    public String getDay() { return this.day; }

    public void setDay(String day) {
        this.day = day;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Workout [id=" + id + ", title=" + title + ", sets=" + sets + ", week=" + week + ", day=" + day + ",reps=" + reps + "]";
    }

}
