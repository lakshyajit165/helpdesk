package com.stackroute.helpdesk.commanddesignframework.command.kvcstatus.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class KycStatus {
    private String documentStatus;
    private String drivingLicenceNumber;
    private String image;
    private ExpiryDate expiryDate;
}
