package bean;

public class Dept {
    private String dname;
    private String job;
    private int no;

    public Dept() {
    }

    public Dept(String dname, String job, int no) {
        this.dname = dname;
        this.job = job;
        this.no = no;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", job='" + job + '\'' +
                ", no=" + no +
                '}';
    }
}
