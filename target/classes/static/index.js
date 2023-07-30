$(function () {
   getTickets();
});

//Purchasing ticket
function purchaseTicket() {
    //Fetching input data
    const film = $("#film").val();
    const numberOfTickets = $("#numberOfTickets").val();
    const firstName = $("#firstName").val();
    const lastName = $("#lastName").val();
    const phone = $("#phone").val();
    const email = $("#email").val();

    //If all fields are filled in ticket object is constructed and sent to server
    if (!findError(numberOfTickets, firstName, lastName, phone, email)) {
        const ticket = {
            film : film,
            numberOfTickets : numberOfTickets,
            firstName : firstName,
            lastName : lastName,
            phone : phone,
            email : email
        }

        $.post("/purchase", ticket, function () {
            window.location.replace("index.html");
        });
    }
}

//Fetching tickets from server
function getTickets() {
    $.get("/fetch", function (tickets) {
        let ticketsString = "<table class='table table-striped table-hover'><thead><tr><th>Film</th><th>Antall</th><th>Fornavn</th><th>Etternavn<i class=\"bi bi-arrow-up\"></i></th><th>Telefonnr</th><th>Epost</th></tr></thead><tbody>";
        let index = 0;

        for (let ticket of tickets) {
            index++;
            ticketsString += "<tr>" +
                "<td>"+ticket.film+"</td>" +
                "<td>"+ticket.numberOfTickets+"</td>" +
                "<td>"+ticket.firstName+"</td>" +
                "<td>"+ticket.lastName+"</td>" +
                "<td>"+ticket.phone+"</td>" +
                "<td>"+ticket.email+"</td></tr>";
        }
        ticketsString += "</body></table>";
        //Printing ticket table if there are any entries
        if (index > 0) {
            $(".alert-danger").remove();
            $("#ticketsTable").html(ticketsString);
        }
    });
}

//Deleting tickets from server
function deleteTickets() {
    $.post("/delete", function () {
        $("#ticketsTable").html("<div class='alert alert-danger' role='alert'>Kinobilletter slettet fra server!</div>");
    })
}

//Finding input errors
function findError(numberOfTickets, firstName, lastName, phone, email) {
    let errorFound = false;
    //Looks for input errors and returns true or false
    const errorMessage = "<span class='text-danger'>Må fylles ut!</span>";
    const errorClear = "";
    if (numberOfTickets === "") {
        $("#errorNumberofTickets").html(errorMessage);
        errorFound = true;
    }
    else {
        $("#errorNumberofTickets").html(errorClear);
    }
    if (firstName === "") {
        $("#errorFirstName").html(errorMessage);
        errorFound = true;
    }
    else {
        $("#errorFirstName").html(errorClear);
    }
    if (lastName === "") {
        $("#errorLastName").html(errorMessage);
        errorFound = true;
    }
    else {
        $("#errorLastName").html(errorClear);
    }
    if (phone === "") {
        $("#errorPhone").html(errorMessage);
        errorFound = true;
    }
    else {
        $("#errorPhone").html(errorClear);
    }
    if (email === "") {
        $("#errorEmail").html(errorMessage);
        errorFound = true;
    }
    else {
        $("#errorEmail").html(errorClear);
    }
    return errorFound;
}