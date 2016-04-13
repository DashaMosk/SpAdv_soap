package com.epam.springadvanced.endpoints;

import com.epam.springadvanced.message.CreateEventRequest;
import com.epam.springadvanced.message.GetEventRequest;
import com.epam.springadvanced.message.GetEventResponse;
import com.epam.springadvanced.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://www.epam.com/spadvance";

    private EventService eventService;

    @Autowired
    public EventEndpoint(EventService eventService) {
        this.eventService = eventService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEventRequest")
    @ResponsePayload
    public GetEventResponse getEventByName(@RequestPayload GetEventRequest request) {
        GetEventResponse response = new GetEventResponse();
        response.setEvent(eventService.getByName(request.getName()));
        return response;
   }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEventRequest")
    @ResponsePayload
    public GetEventResponse createEvent(@RequestPayload CreateEventRequest request) {
        GetEventResponse response = new GetEventResponse();
        if(request.getDateTime() != null) {
            response.setEvent(eventService.create(request.getName(), request.getDateTime(), request.getPrice(), request.getRating()));
        } else {
            response.setEvent(eventService.create(request.getName(), request.getPrice(), request.getRating()));
        }
        return response;
    }

}
