package com.immunization.trustee.dto.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "userUri", "razlogOdbijanja" })
@XmlRootElement(name = "odgovor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Odgovor {
	@XmlElement(name = "user_uri", required = true)
	private String userUri;

	@XmlElement(name = "razlog_odbijanja")
	private String razlogOdbijanja;
}
