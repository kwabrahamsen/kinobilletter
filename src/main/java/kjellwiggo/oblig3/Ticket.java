package kjellwiggo.oblig3;

public class Ticket {
    private int id;
    private String film;
    private String numberOfTickets;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Ticket(int id, String film, String numberOfTickets, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.film = film;
        this.numberOfTickets = numberOfTickets;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Ticket(){ }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(String numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
