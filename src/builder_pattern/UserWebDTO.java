package builder_pattern;

public class UserWebDTO implements UserDTO {
    private String name;

    public UserWebDTO(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String address;
    private String age;



}
