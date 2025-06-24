package org.example.hexlet;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;

public final class App {
    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());

        app.get("/users", ctx -> {
            Integer page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            if (page < 1) {
                page = 1;
            }

            Integer per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            if (per < 1) {
                per = 5;
            }

            int startIndex = (page - 1) * per;
            if (startIndex >= USERS.size()) {
                ctx.json(List.of());
                return;
            }
            int endIndex = page * per;
            if (endIndex > USERS.size()) {
                endIndex = USERS.size();
            }

            List<Map<String, String>> sortedUsers = USERS.subList(startIndex, endIndex);
            ctx.json(sortedUsers);

        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}
