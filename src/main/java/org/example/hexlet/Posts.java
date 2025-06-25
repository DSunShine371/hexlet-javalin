package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.List;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

public class Posts {
    private static final List<Map<String, String>> POSTS = Data.getPosts();
    private static final List<Course> COURSES = Data.getCourses();

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.render("index.jte"));

        app.get("/courses", ctx -> {
            var header = "Курсы по программированию";
            var page = new CoursesPage(COURSES, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/users/{id}", ctx -> {
            String requestedUserName = ctx.pathParam("id");

            Map<String, String> foundPost = POSTS.stream()
                    .filter(post -> post.get("userName").equalsIgnoreCase(requestedUserName))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User/Post by name = " + requestedUserName + " not found"));

            String postId = foundPost.get("id");
            String userName = foundPost.get("userName");

            ctx.result(String.format("ID: %s, Username: %s", postId, userName));
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String requestedUserName = ctx.pathParam("id");
            String requestedPostName = ctx.pathParam("postId");

            Map<String, String> foundPost = POSTS.stream()
                    .filter(post -> post.get("userName").equalsIgnoreCase(requestedUserName) &&
                            post.get("postName").equalsIgnoreCase(requestedPostName))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("Post by user '" + requestedUserName + "' and post name '" + requestedPostName + "' not found"));

            String postId = foundPost.get("id");
            String userName = foundPost.get("userName");
            String postName = foundPost.get("postName");

            ctx.result(String.format("ID: %s, Username: %s, Postname: %s", postId, userName, postName));
        });

        app.get("/posts", ctx -> ctx.json(POSTS));

        app.start(7070);
    }
}
