package nes.project.airport.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "flight_plan", schema = "airport")
public class FlightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_plan_id_seq")
    @SequenceGenerator(name = "flight_plan_id_seq", sequenceName = "flight_plan_id_seq", allocationSize = 1)
    @Column(name = "flight_plan_id")
    private Integer flightPlanId;

    @Column(name = "airway_id")
    private Integer airwayId;
    @Column(name = "route_id")
    private Integer routeId;
    @Column(name = "flight_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp flightDate;
    @Column(name = "plane_name")
    private String planeName;
    @Column(name = "plane_capacity")
    private Integer planeCapacity;
    @Column(name = "full_seat_count")
    private Integer fullSeatCount;
    @Column(name = "ticket_price")
    private Double ticketPrice;

    @Override
    public String toString() {
        return "FlightPlan{" +
                "flightPlanId=" + flightPlanId +
                ", airwayId=" + airwayId +
                ", routeId=" + routeId +
                ", flightDate=" + flightDate +
                ", planeName='" + planeName + '\'' +
                ", planeCapacity=" + planeCapacity +
                ", fullSeatCount=" + fullSeatCount +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public Integer getFlightPlanId() {
        return flightPlanId;
    }

    public void setFlightPlanId(Integer flightPlanId) {
        this.flightPlanId = flightPlanId;
    }

    public Integer getAirwayId() {
        return airwayId;
    }

    public void setAirwayId(Integer airwayId) {
        this.airwayId = airwayId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Timestamp getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Timestamp flightDate) {
        this.flightDate = flightDate;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public Integer getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(Integer planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public Integer getFullSeatCount() {
        return fullSeatCount;
    }

    public void setFullSeatCount(Integer fullSeatCount) {
        this.fullSeatCount = fullSeatCount;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
