package kjellwiggo.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Oblig3Repository {

    @Autowired
    public JdbcTemplate db;

    //Updating database with new ticket purchase
    public void purchaseTicket(Ticket ticket) {
        String sql = "INSERT INTO Tickets (film, numberOfTickets, firstName, lastName, phone, email) VALUES (?,?,?,?,?,?)";
        db.update(sql, ticket.getFilm(), ticket.getNumberOfTickets(), ticket.getFirstName(), ticket.getLastName(), ticket.getPhone(), ticket.getEmail());
    }

    //Fetching tickets in database
    public List<Ticket> fetchTickets() {
        String sql = "SELECT* FROM Tickets ORDER BY lastName, firstName ASC";
        List<Ticket> allTickets = db.query(sql, BeanPropertyRowMapper.newInstance(Ticket.class));
        return allTickets;
    }

    //Deleting all tickets in database
    public void deleteTickets() {
        String sql = "DELETE FROM Tickets";
        db.update(sql);
    }
}
