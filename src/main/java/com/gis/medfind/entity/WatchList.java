package com.gis.medfind.entity;

import lombok.Data;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import java.util.List;


@Data
@Entity
@Table(name = "watch_list")
public class WatchList{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "watchList_id")
    private int id;
    
    @Column(name = "creation_date")
    private String creationDate;
    
    @OneToOne
    @JoinColumn(name = "fk_owner")
    private User owner;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medicine> medicines = new ArrayList<>();

    public boolean addMedicine(Medicine med){
        return this.medicines.add(med);
    }

    public boolean removeMedicine(Medicine med){
        return this.medicines.remove(med);
    }
}