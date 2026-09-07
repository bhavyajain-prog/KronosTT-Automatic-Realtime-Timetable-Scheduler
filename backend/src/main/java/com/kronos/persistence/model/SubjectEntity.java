package com.kronos.persistence.model;

import com.kronos.enums.SubjectType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Data
public class SubjectEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String subjectCode;
    @Column(nullable = false)
    private String subjectName;
    @Column(nullable = false)
    private Integer weight;
    @Column(nullable = false)
    private int slotDuration;
    @Column(nullable = false)
    private SubjectType subjectType;
}
