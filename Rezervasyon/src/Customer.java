
public class Customer {
    private String name;
    private String surname;
    private String idCard;
    private String phoneNo;
    private String email;
    private boolean hasSpecialNeeds;

    public Customer(String name, String surname, String idCard, String phoneNo, String email, boolean hasSpecialNeeds) {
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.phoneNo = phoneNo;
        this.email = email;
        this.hasSpecialNeeds = hasSpecialNeeds;
    }

    @Override
    public String toString() {
        return "AD-SOYAD = " + name + "-" + surname +
                " | KİMLİK-NO = " + idCard +
                " | TEL-NO = " + phoneNo +
                " | E-MAİL = " + email +
                " | ENGEL DURUMU = " + hasSpecialNeeds + "\n";
    }
}
