@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=LocalDateTime.class, value=LocalDateTimeXmlAdapter.class),
        @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateXmlAdapter.class)
})
package com.epam.springadvanced.entity;

import com.epam.springadvanced.service.impl.LocalDateTimeXmlAdapter;
import com.epam.springadvanced.service.impl.LocalDateXmlAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;
import java.time.LocalDateTime;