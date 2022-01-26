package com.mapsit.tanitTraining.BaseTva;

import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Mark entity.\n@author The Moo3in team.
 */
@ApiModel(description = "BaseTva entity.\n@author The Moo3in team.")
@Entity
@Table(name = "baseTva")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BaseTva implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//    @SequenceGenerator(name = "sequenceGenerator")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "percentage", nullable = false)
    private Double percentage;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "base", nullable = false)
    private Double base;



    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPercentage() {
        return percentage;
    }

    public BaseTva percentage(Double percentage) {
        this.percentage = percentage;
        return this;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }


    public Double getAmount() {
        return amount;
    }

    public BaseTva amount(Double amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBase() {
        return base;
    }

    public BaseTva base(Double base) {
        this.base = base;
        return this;
    }

    public void setBase(Double base) {
        this.base = base;
    }



    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseTva)) {
            return false;
        }
        return id != null && id.equals(((BaseTva) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BaseTva{" +
            "id=" + getId() +
            ", percentage='" + getPercentage() + "'" +
            ", amount='" + getAmount() + "'" +
            ", base='" + getBase() + "'" +
            "}";
    }
}
