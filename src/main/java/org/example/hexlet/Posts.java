package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Posts {
    private static final List<Map<String, String>> POSTS = Data.getPosts();

    public static void main(String[] args) {
        var app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());

        app.get("/users/{id}", ctx -> {
            String requestedUserName = ctx.pathParam("id");

            Optional<Map<String, String>> foundPost = POSTS.stream()
                    .filter(post -> post.get("userName").equalsIgnoreCase(requestedUserName))
                    .findFirst();

            if (foundPost.isPresent()) {
                Map<String, String> postData = foundPost.get();
                String postId = postData.get("id");
                String userName = postData.get("userName");

                ctx.result(String.format("ID: %s, Username: %s", postId, userName));
            } else {
                throw new NotFoundResponse("User/Post by name = " + requestedUserName + " not found");
            }
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String requestedUserName = ctx.pathParam("id");
            String requestedPostName = ctx.pathParam("postId");

            Optional<Map<String, String>> foundPost = POSTS.stream()
                    .filter(post -> post.get("userName").equalsIgnoreCase(requestedUserName) &&
                            post.get("postName").equalsIgnoreCase(requestedPostName))
                    .findFirst();

            if (foundPost.isPresent()) {
                Map<String, String> postData = foundPost.get();
                String postId = postData.get("id");
                String userName = postData.get("userName");
                String postName = postData.get("postName");

                ctx.result(String.format("ID: %s, Username: %s, Postname: %s", postId, userName, postName));
            } else {
                throw new NotFoundResponse("Post by user '" + requestedUserName + "' and post name '" + requestedPostName + "' not found");
            }
        });

        app.get("/posts", ctx -> ctx.json(POSTS));

        app.start(7070);
    }
}