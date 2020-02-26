package builder_pattern;

public class Address {
    String streerName;
    String city;

    public String getStreerName() {
        return streerName;
    }

    public void setStreerName(String streerName) {
        this.streerName = streerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    String state;
    String country;
    int zipCode;

}
