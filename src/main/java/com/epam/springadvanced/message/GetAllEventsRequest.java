package com.epam.springadvanced.message;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://www.epam.com/event")
@XmlType(namespace = "http://www.epam.com/event")
public class GetAllEventsRequest {
}
