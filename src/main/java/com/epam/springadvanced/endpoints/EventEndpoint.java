package com.epam.springadvanced.endpoints;

import com.epam.springadvanced.message.*;
import com.epam.springadvanced.message.response.EventResponse;
import com.epam.springadvanced.message.response.EventsResponse;
import com.epam.springadvanced.message.response.TicketsResponse;
import com.epam.springadvanced.repository.AuditoriumRepository;
import com.epam.springadvanced.service.EventService;
import com.epam.springadvanced.service.UserService;
import com.epam.springadvanced.service.exception.AuditoriumAlreadyAssignedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://www.epam.com/event";

    private EventService eventService;
    private AuditoriumRepository auditoriumRepo;
    private UserService userService;

    @Autowired
    public EventEndpoint(EventService eventService, AuditoriumRepository auditoriumRepo, UserService userService) {
        this.eventService = eventService;
        this.auditoriumRepo = auditoriumRepo;
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventRequest")
    @ResponsePayload
    public EventResponse getEventByName(@RequestPayload GetEventRequest request) {
        EventResponse response = new EventResponse();
        response.setEvent(eventService.getByName(request.getName()));
        return response;
   }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEventRequest")
    @ResponsePayload
    public EventResponse createEvent(@RequestPayload CreateEventRequest request) {
        EventResponse response = new EventResponse();
        if(request.getDateTime() != null) {
            response.setEvent(eventService.create(request.getName(), request.getDateTime(), request.getPrice(), request.getRating()));
        } else {
            response.setEvent(eventService.create(request.getName(), request.getPrice(), request.getRating()));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removeEventRequest")
    public void removeEvent(@RequestPayload RemoveEventRequest request) {
        eventService.remove(eventService.getById(request.getIdEvent()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEventsRequest")
    @ResponsePayload
    public EventsResponse getAllEvents() {
        EventsResponse response = new EventsResponse();
        response.setEvents(eventService.getAll());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNextEventRequest")
    @ResponsePayload
    public EventsResponse getNextEvents(@RequestPayload GetNextEventRequest request) {
        EventsResponse response = new EventsResponse();
        response.setEvents(eventService.getNextEvents(request.getDate()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "assignAuditoriumRequest")
    @ResponsePayload
    public EventResponse assignAuditorium(@RequestPayload AssignAuditoriumRequest request)
            throws AuditoriumAlreadyAssignedException{
        EventResponse response = new EventResponse();
        response.setEvent(eventService.assignAuditorium(eventService.getById(request.getEventId()),
                auditoriumRepo.getById(request.getAuditId()), request.getDate()));
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookedTicketsRequest")
    @ResponsePayload
    public TicketsResponse getBookedTickets() {
        TicketsResponse response = new TicketsResponse();
        response.setTickets(userService.getBookedTickets());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookedTicketsByUserRequest")
    @ResponsePayload
    public TicketsResponse getBookedTicketsByUser(@RequestPayload GetBookedTicketsByUserRequest request) {
        TicketsResponse response = new TicketsResponse();
        response.setTickets(userService.getBookedTicketsByUserId(request.getUserId()));
        return response;
    }

}
