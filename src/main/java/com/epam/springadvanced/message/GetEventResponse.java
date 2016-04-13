package com.epam.springadvanced.message;

import com.epam.springadvanced.entity.Event;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/spadvance")
@XmlType(namespace = "http://www.epam.com/spadvance")
public class GetEventResponse {
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
