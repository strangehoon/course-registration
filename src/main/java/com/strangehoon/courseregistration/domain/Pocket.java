package com.strangehoon.courseregistration.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.servlet.http.Part;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pocket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pocket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_class_id")
    private PartClass partClass;

    //==연관관계 메서드==//
    public void putStudent(Student student) {
        if (this.student != null) {
            this.student.getPockets().remove(this);
        }
        this.student = student;
        student.getPockets().add(this);
    }

    public void putPartClass(PartClass partClass) {
        if (this.partClass != null) {
            this.partClass.getPockets().remove(this);
        }
        this.partClass = partClass;
        partClass.getPockets().add(this);
    }

    //==생성 메서드==//
    public static Pocket createPocket(PartClass partClass, Student student) {
        Pocket pocket = new Pocket();
        pocket.putPartClass(partClass);
        pocket.putStudent(student);
        return pocket;
    }

}
