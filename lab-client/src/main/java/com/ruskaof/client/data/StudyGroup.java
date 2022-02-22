package com.ruskaof.client.data;


import com.ruskaof.client.exceptions.IdAlreadyPresentException;

import java.util.HashSet;
import java.util.Objects;



public class StudyGroup implements Comparable<StudyGroup> {
    public StudyGroup(String name,
                      Coordinates coordinates,
                      Integer studentsCount,
                      FormOfEducation formOfEducation,
                      Semester semesterEnum,
                      Person groupAdmin,
                      Integer id) throws IdAlreadyPresentException {
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
        this.creationDate = java.time.LocalDate.now();


        if(StudyGroup.usedIDs.contains(id)) {
            throw new IdAlreadyPresentException("Please use another id for this init. Entered id was already used");
        }
        this.id = id;
    }


    public StudyGroup(String name,
                      Coordinates coordinates,
                      Integer studentsCount,
                      FormOfEducation formOfEducation,
                      Semester semesterEnum,
                      Person groupAdmin) {
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
        this.creationDate = java.time.LocalDate.now();

        this.id = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!usedIDs.contains(i)) {
                this.id = i;
                break;
            }
        }
    }



    public static HashSet<Integer> usedIDs = new HashSet<>();


    private int id; // >0, unique, automatic generation

    private final String name; //not null, not empty
    private final Coordinates coordinates; //not null
    private final java.time.LocalDate creationDate; //not null, automatic generation
    private final Integer studentsCount; // >0, null-able
    private final FormOfEducation formOfEducation; //not null
    private final Semester semesterEnum; // null-able
    private final Person groupAdmin; //not null

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Integer getStudentsCount() {
        return studentsCount;
    }

    @Override
    public int compareTo(StudyGroup o) {
        Integer oValue = o.getStudentsCount();
        Integer thisValue = this.getStudentsCount();

        // null handling
        if (oValue == null) {
            oValue = -1;
        }
        if (thisValue == null) {
            thisValue = -1;
        }

        if (oValue - thisValue != 0) {
            return thisValue - oValue;
        } else {
            return this.getId() - o.getId();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyGroup that = (StudyGroup) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(studentsCount, that.studentsCount) && formOfEducation == that.formOfEducation && semesterEnum == that.semesterEnum && Objects.equals(groupAdmin, that.groupAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, studentsCount, formOfEducation, semesterEnum, groupAdmin);
    }
}