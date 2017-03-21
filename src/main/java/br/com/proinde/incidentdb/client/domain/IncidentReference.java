package br.com.proinde.incidentdb.client.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Access(AccessType.FIELD)
public class IncidentReference implements Serializable {

    @Column(name = "reference_number")
    private Short number;

    @Column(name = "reference_year")
    private Short year;

    @Column(name = "reference_sub_number")
    private Short subNumber;

    public IncidentReference() {
    }

    public IncidentReference(Short number) {
        this(number, (short) LocalDate.now().getYear(), (short) 0);
    }

    public IncidentReference(Short number, Short year) {
        this(number, year, (short) 0);
    }

    public IncidentReference(Short number, Short year, Short subNumber) {
        this.number = number;
        this.year = year;
        this.subNumber = subNumber;
    }

    public Short getNumber() {
        return number;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Short getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(Short subNumber) {
        this.subNumber = subNumber;
    }

    @Override
    public String toString() {
        return number + "/" + year + "-" + subNumber;
    }
}
