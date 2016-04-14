package com.epam.springadvanced.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;

@XmlRootElement(namespace = "http://www.epam.com/event")
@XmlType(namespace = "http://www.epam.com/event")
public class AssignAuditoriumRequest {
    private long eventId;
    private int auditId;
    private LocalDateTime date;

    @XmlElement(required=true)
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @XmlElement(required=true)
    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    @XmlElement(required=true)
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
