package com.epam.springadvanced.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/event")
@XmlType(namespace = "http://www.epam.com/event")
public class GetEventRequest {
    private String name;

    @XmlElement(required=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
