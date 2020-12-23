package Employee;

public class partTimeEmployee extends Employee{


    public partTimeEmployee(String id, String name) {
        super(id, name);
    }

    public partTimeEmployee() {
    }

    @Override
    public double TinhLuong() {
        return 200;
    }

    @Override
    public String toString() {
        String str1=super.toString();
        String str2=" - Parttime - Luong - "+ TinhLuong();
        return str1+str2;
    }
}
