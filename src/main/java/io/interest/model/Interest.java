package io.interest.model;

import io.interest.AccountTypes;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("interest")
public class Interest {

    @Id
    private ObjectId id;
    private AccountTypes type;
    private double rate;

    public Interest() {
      //No argument constructor
    }

    public Interest(ObjectId id, AccountTypes type, double rate) {
        this.id = id;
        this.type = type;
        this.rate = rate;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public AccountTypes getType() {
        return type;
    }

    public void setType(AccountTypes type) {
        this.type = type;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
