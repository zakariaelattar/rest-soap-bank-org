package com.ensapay.bank.entities;


import com.ensapay.bank.Security.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Agent extends User {

    private String first_name;
    private String last_name;
    private String cin;
    private Date birth_date;
    private String adress;

    private String commercial_register_number;
    private String patent_number;



}
