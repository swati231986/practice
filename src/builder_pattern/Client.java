package builder_pattern;

import java.time.LocalDate;

public class Client {
    public static void main(String args[]) {

        User user = createUser();
        UserDTOBuilder userDTOBuilder = new UserWebDTOBuilder();
        UserDTO userDTO = userDTOBuilder.getAddress(user.getAddress()).getFirstName(user.getFirstName()).
                getLastName(user.getLastName()).getAge(user.getDateOfBirth()).build();
        System.out.println(userDTO.getName());
        System.out.println(userDTO.getAddress());
        System.out.println(userDTO.getAge());
    }

    public static User createUser() {
        User user = new User();

        user.setFirstName("Swati");
        user.setLastName("Chaturvedi");
        user.setDateOfBirth(LocalDate.of(1986, 7, 23));

        Address address = new Address();
        address.setCity("Sunnyvale");
        address.setCountry("USA");
        address.setState("California");
        address.setStreerName("Firloch Avenye");
        address.setZipCode(94086);
        user.setAddress(address);

        return user;
    }
}
