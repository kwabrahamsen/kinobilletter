package kjellwiggo.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Oblig3Controller {

    @Autowired
    Oblig3Repository rep;

    @PostMapping("/purchase")
    public void purchaseTicket(Ticket ticket) {
        rep.purchaseTicket(ticket);
    }

    @GetMapping("/fetch")
    public List<Ticket> fetchTickets() {
        return rep.fetchTickets();
    }

    @PostMapping("/delete")
    public void deleteTickets() {
        rep.deleteTickets();
    }
}
