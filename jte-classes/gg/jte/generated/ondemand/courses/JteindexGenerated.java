package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,1,30,30,69,73,73,73,74,74,78,78,79,79,81,81,81,81,81,81,81,82,82,82,84,84,85,85,87,87,87,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\r\n<html>\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n    <title>Хекслет - Курсы</title>\r\n    <style>\r\n        body {\r\n            font-family: 'Inter', sans-serif;\r\n            margin: 0;\r\n            padding: 20px;\r\n            background-color: #f4f7f6;\r\n            color: #333;\r\n            line-height: 1.6;\r\n        }\r\n        h1 {\r\n            color: #2c3e50;\r\n            text-align: center;\r\n            margin-bottom: 40px;\r\n            font-size: 2.5em;\r\n        }\r\n        .course-container {\r\n            background-color: #ffffff;\r\n            border-radius: 12px;\r\n            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);\r\n            margin-bottom: 25px;\r\n            padding: 25px 30px;\r\n            transition: transform 0.2s ease-in-out;\r\n            max-width: 800px; ");
		jteOutput.writeContent("\r\n            margin-left: auto;\r\n            margin-right: auto;\r\n        }\r\n        .course-container:hover {\r\n            transform: translateY(-5px);\r\n            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.12);\r\n        }\r\n        h2 {\r\n            font-size: 1.8em;\r\n            margin-top: 0;\r\n            margin-bottom: 10px;\r\n        }\r\n        h2 a {\r\n            color: #3498db;\r\n            text-decoration: none;\r\n            transition: color 0.2s ease-in-out;\r\n        }\r\n        h2 a:hover {\r\n            color: #2980b9;\r\n            text-decoration: underline;\r\n        }\r\n        p {\r\n            font-size: 1.1em;\r\n            color: #555;\r\n            margin-bottom: 0;\r\n        }\r\n        .no-courses-message {\r\n            text-align: center;\r\n            font-size: 1.2em;\r\n            color: #777;\r\n            padding: 50px;\r\n            background-color: #fff;\r\n            border-radius: 8px;\r\n            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);\r\n            max-width: 600px;\r\n            margin: 50px auto;\r\n        }\r\n    </style>\r\n    ");
		jteOutput.writeContent("\r\n    <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap\" rel=\"stylesheet\">\r\n</head>\r\n<body>\r\n<h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getHeader());
		jteOutput.writeContent("</h1>\r\n");
		if (page.getCourses().isEmpty()) {
			jteOutput.writeContent("\r\n    <div class=\"no-courses-message\">\r\n        <p>Пока не добавлено ни одного курса</p>\r\n    </div>\r\n");
		} else {
			jteOutput.writeContent("\r\n    ");
			for (var course : page.getCourses()) {
				jteOutput.writeContent("\r\n        <div class=\"course-container\">\r\n            <h2><a href=\"/courses/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(course.getId());
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(course.getName());
				jteOutput.writeContent("</a></h2>\r\n            <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(course.getDescription());
				jteOutput.writeContent("</p>\r\n        </div>\r\n    ");
			}
			jteOutput.writeContent("\r\n");
		}
		jteOutput.writeContent("\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
