package com.epam.springadvanced.message;

import com.epam.springadvanced.service.Rating;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;

@XmlRootElement(namespace = "http://www.epam.com/spadvance")
@XmlType(namespace = "http://www.epam.com/spadvance")
public class CreateEventRequest {
    private String name;
    private float price;
    Rating rating;
    private LocalDateTime dateTime;

    @XmlElement(required=true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(required=true)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlElement(required=true)
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


    @XmlElement(nillable=true)
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
