package com.epam.springadvanced.message.response;

import com.epam.springadvanced.entity.Ticket;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;

@XmlRootElement(namespace = "http://www.epam.com/event")
@XmlType(namespace = "http://www.epam.com/event")
public class TicketsResponse {
    private Collection<Ticket> tickets;

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
