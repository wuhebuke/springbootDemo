package com.company.common.core.domain;

import lombok.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * @author flk
 * @date 2023/11/2
 */
@Data
public class Response {
    private String success;

    private String reason;
}
