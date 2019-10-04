package com.stackroute.helpdesk.commanddesignframework.command.refund.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    private String Id;
    private String status;
    private List<Rider> rider;
    private List<SourceZone> sourceZones;
    private List<Vehicle> vehicles;
    private List<PaymentMethod> paymentMethods;
    private String[] destinationZones;
    private String bookedAt;
    private String rideStartAt;
    private String rideEndAt;
    private String distance;
    private int duration;
    private String payment;
}