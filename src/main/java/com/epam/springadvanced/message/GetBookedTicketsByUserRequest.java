package com.epam.springadvanced.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/event")
@XmlType(namespace = "http://www.epam.com/event")
public class GetBookedTicketsByUserRequest {
    private long userId;

    @XmlElement(required=true)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
