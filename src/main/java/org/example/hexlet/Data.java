package org.example.hexlet;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Locale;
import net.datafaker.Faker;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.stream.LongStream;

public class Data {
    private static final int POSTS_COUNT = 30;
    private static final int COURSES_COUNT = 10;

    private static int idCounter = POSTS_COUNT;

    public static List<Map<String, String>> getPosts() {
        Random random = new Random(123);
        Faker faker = new Faker(new Locale("en"), random);

        List<String> ids = IntStream
                .range(1, POSTS_COUNT + 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Map<String, String>> posts = new ArrayList<>();

        for (int i = 0; i < POSTS_COUNT; i++) {
            Map<String, String> post = new LinkedHashMap<>();
            post.put("id", ids.get(i));
            post.put("userName", faker.name().fullName());
            post.put("postName", faker.vehicle().manufacturer());
            posts.add(post);
        }

        return posts;
    }

    public static List<Course> getCourses() {
        Random random = new Random(371);
        Faker faker = new Faker(new Locale("en"), random);

        List<Long> ids = LongStream.rangeClosed(1, COURSES_COUNT)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(ids, random);

        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < COURSES_COUNT; i++) {
            Long id = ids.get(i);
            String name = faker.programmingLanguage().name();
            String description = faker.lorem().sentence(15);
            courses.add(new Course(id, name, description));
        }
        return courses;
    }

    public static String getNextId() {
        int id = ++idCounter;
        return Integer.toString(id);
    }
}
