
public class Location {
    private String country;
    private String city;
    private String airport;

    public Location(String country, String city, String airport) {
        this.country = country;
        this.city = city;
        this.airport = airport;
    }

    @Override
    public String toString() {
        return country + " (" + city + ") | " + airport;
    }
}