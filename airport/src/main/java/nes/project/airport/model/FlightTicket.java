package nes.project.airport.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "flight_ticket", schema = "airport")
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_ticket_id_seq")
    @SequenceGenerator(name = "flight_ticket_id_seq", sequenceName = "flight_ticket_id_seq", allocationSize = 1)
    @Column(name = "flight_ticket_id")
    private Integer flightTicketId;

    @Column(name = "flight_plan_id")
    private Integer flightPlanId;
    @Column(name = "ticket_price")
    private Double ticketPrice;
    @Column(name = "passenger_tckn")
    private BigInteger passengerTCKN;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "passenger_surname")
    private String passengerSurname;

    @Override
    public String toString() {
        return "FlightTicket{" +
                "flightTicketId=" + flightTicketId +
                ", flightPlanId=" + flightPlanId +
                ", ticketPrice=" + ticketPrice +
                ", passengerTCKN=" + passengerTCKN +
                ", passengerName='" + passengerName + '\'' +
                ", passengerSurname='" + passengerSurname + '\'' +
                '}';
    }

    public Integer getFlightTicketId() {
        return flightTicketId;
    }

    public void setFlightTicketId(Integer flightTicketId) {
        this.flightTicketId = flightTicketId;
    }

    public Integer getFlightPlanId() {
        return flightPlanId;
    }

    public void setFlightPlanId(Integer flightPlanId) {
        this.flightPlanId = flightPlanId;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BigInteger getPassengerTCKN() {
        return passengerTCKN;
    }

    public void setPassengerTCKN(BigInteger passengerTCKN) {
        this.passengerTCKN = passengerTCKN;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }
}
