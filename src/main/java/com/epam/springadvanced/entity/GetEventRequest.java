package com.epam.springadvanced.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/spadvance")
@XmlType(namespace = "http://www.epam.com/spadvance")
public class GetEventRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
