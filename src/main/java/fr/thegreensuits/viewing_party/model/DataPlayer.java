package fr.thegreensuits.viewing_party.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.ebean.Model;
import io.ebean.annotation.Index;
import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;

@Entity
@Table(name = "mc_DataPlayer")
public class DataPlayer extends Model {
    @Id
    long id;

    @NotNull @Length(255) @Index
    UUID uniqueId;
}
