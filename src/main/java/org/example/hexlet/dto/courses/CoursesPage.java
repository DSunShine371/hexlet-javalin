package org.example.hexlet.dto.courses;

import java.util.List;

import lombok.AllArgsConstructor;
import org.example.hexlet.model.Course;

import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
}
