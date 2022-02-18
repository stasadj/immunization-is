package com.immunization.trustee.dto.response;

import javax.validation.constraints.NotNull;
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
@XmlType(name = "", propOrder = { "uuid", "razlogOdbijanja" })
@XmlRootElement(name = "odgovor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Odgovor {
	@NotNull(message = "Request UUID is missing.")
	@XmlElement(name = "uuid")
	private String uuid;

	@XmlElement(name = "razlog_odbijanja")
	private String razlogOdbijanja;
}
