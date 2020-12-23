package Employee;

public class fullTimeEmployee extends Employee {

    public fullTimeEmployee(String id, String name) {
        super(id, name);
    }

    public fullTimeEmployee() {
    }

    @Override
    public double TinhLuong() {
        return 500;
    }
    public String toString(){
        String str1=super.toString();
        String str2=" - Fulltime - Luong - "+ TinhLuong();
        return str1+str2;
    }
}
