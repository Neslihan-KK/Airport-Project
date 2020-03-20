package nes.project.airport.model;

import javax.persistence.*;

@Entity
@Table(name = "airways", schema = "airport")
public class Airways {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airway_id_seq")
    @SequenceGenerator(name = "airway_id_seq", sequenceName = "airway_id_seq", allocationSize = 1)
    @Column(name = "airway_id")
    private Integer airwayId;

    @Column(name = "airway_name")
    private String airwayName;

    @Override
    public String toString() {
        return "Airways{" +
                "airwayId=" + airwayId +
                ", airwayName='" + airwayName + '\'' +
                '}';
    }

    public Integer getAirwayId() {
        return airwayId;
    }

    public void setAirwayId(Integer airwayId) {
        this.airwayId = airwayId;
    }

    public String getAirwayName() {
        return airwayName;
    }

    public void setAirwayName(String airwayName) {
        this.airwayName = airwayName;
    }
}
