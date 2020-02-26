package builder_pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static java.time.LocalDate.now;

public class UserWebDTOBuilder implements UserDTOBuilder {
    String firstName;
    String lastName;
    String age;
    String address;
    UserDTO userDTO;

    @Override
    public UserDTOBuilder getFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder getLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder getAge(LocalDate dateOfBirth) {
        this.age = Period.between(dateOfBirth, now()).toString();
        return this;
    }

    @Override
    public UserDTOBuilder getAddress(Address address) {
        this.address = address.getStreerName() + " , "+ address.getCity() + ", "+address.getState() + ", "+address.getCountry() +
                ", " + address.getZipCode();
        return this;
    }

    @Override
    public UserDTO build() {
        UserDTO userDTO = new UserWebDTO(this.firstName+" "+this.lastName, this.address, this.age);
        this.userDTO = userDTO;
        return userDTO;

    }

    @Override
    public UserDTO getUserWebDTO() {
        return this.userDTO;
    }
}
