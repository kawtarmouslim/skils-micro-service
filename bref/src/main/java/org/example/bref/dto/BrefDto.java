package org.example.bref.dto;

import lombok.Value;
import org.example.bref.entity.Bref;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Bref}
 */
@Value
public class BrefDto implements Serializable {
    Long id;
    String titre;
    String description;
    Date debut;
    Date fin;
}