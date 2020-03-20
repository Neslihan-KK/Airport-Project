package nes.project.airport.model;

import javax.persistence.*;

@Entity
@Table(name = "airports", schema = "airport")
public class Airports {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_id_seq")
    @SequenceGenerator(name = "airport_id_seq", sequenceName = "airport_id_seq", allocationSize = 1)
    @Column(name = "airport_id")
    private Integer airportId;

    @Column(name = "airport_name")
    private String airportName;
    @Column(name = "airport_location")
    private String airportLocation;

    @Override
    public String toString() {
        return "Airports{" +
                "airportId=" + airportId +
                ", airportName='" + airportName + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                '}';
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }
}
