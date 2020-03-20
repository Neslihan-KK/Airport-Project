package nes.project.airport.model;

import javax.persistence.*;

@Entity
@Table(name = "route", schema = "airport")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_id_seq")
    @SequenceGenerator(name = "route_id_seq", sequenceName = "route_id_seq", allocationSize = 1)
    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "from_airport_id")
    private Integer fromAirportId;
    @Column(name = "to_airport_id")
    private Integer toAirportId;

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", fromAirportId=" + fromAirportId +
                ", toAirportId=" + toAirportId +
                '}';
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getFromAirportId() {
        return fromAirportId;
    }

    public void setFromAirportId(Integer fromAirportId) {
        this.fromAirportId = fromAirportId;
    }

    public Integer getToAirportId() {
        return toAirportId;
    }

    public void setToAirportId(Integer toAirportId) {
        this.toAirportId = toAirportId;
    }
}
