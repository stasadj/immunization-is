package com.immunization.common.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

@Service
public class XMLCalendarService {
    
    public XMLGregorianCalendar getCurrentDate() throws DatatypeConfigurationException{
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
    }
}
