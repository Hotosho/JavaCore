package lesson9;

public class Company {

    private String name;
    private String countryFounded;

    protected String code;

    public String getName() {
        return name;
    }

    public String getCountryFounded() {
        return countryFounded;
    }

    public void setCountryFounded(String countryFounded) {
        this.countryFounded = countryFounded;
    }
}
