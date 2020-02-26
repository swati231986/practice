package builder_pattern;

import java.time.LocalDate;
import java.util.Date;

public interface UserDTOBuilder {

    public UserDTOBuilder getFirstName(String firstName);
    public UserDTOBuilder getLastName(String lastName);
    public  UserDTOBuilder getAddress(Address address);
    public UserDTOBuilder getAge(LocalDate dateOfBirth);

    public UserDTO build() ;

    public UserDTO getUserWebDTO() ;
}
