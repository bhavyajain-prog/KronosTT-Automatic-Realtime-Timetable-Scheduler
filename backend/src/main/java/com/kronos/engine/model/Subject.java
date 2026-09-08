package com.kronos.engine.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Subject {
    private long id;
    private String name;
    private int weight; // lectures per week
    private int slotDuration; // no of slots per instance
    private SubjectType subjectType;
}
