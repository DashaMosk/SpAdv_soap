package com.epam.springadvanced.endpoints;

import com.epam.springadvanced.service.EventService;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EventEndpoint {
    private static final String NAMESPACE_URI = "http://epam.com/spadvance-web-service";

    private EventService eventService;

    @Autowired
    public EventEndpoint(EventService eventService) {
        this.eventService = eventService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SpadvanceRequest")
    @ResponsePayload
    public void getAllEvents(@RequestPayload Element request) {
        eventService.getAll();
//       GetAllEventsResponse response = new GetAllEventsResponse();
//       // response.setEvents(eventService.getAll());
//
//        // return response;
   }

}
