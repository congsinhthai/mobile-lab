package Task4;

public class Employee_Task4 {
    String name;
    String id;
    Boolean is_manager;

    public Employee_Task4()
    {

    }

    public Employee_Task4(String name, String id, Boolean is_manager) {
        this.name = name;
        this.id = id;
        this.is_manager = is_manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(Boolean is_manager) {
        this.is_manager = is_manager;
    }
}
