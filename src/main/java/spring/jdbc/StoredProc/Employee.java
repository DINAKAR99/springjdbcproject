package spring.jdbc.StoredProc;

public class Employee {
    private int eid;
    private String ename;
    private String esal;

    public Employee(int eid, String ename, String esal) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
    }

    public Employee() {
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsal() {
        return esal;
    }

    public void setEsal(String esal) {
        this.esal = esal;
    }

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
    }
}
