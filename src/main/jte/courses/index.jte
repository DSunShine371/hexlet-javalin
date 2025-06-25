@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Хекслет - Курсы</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f7f6;
            color: #333;
            line-height: 1.6;
        }
        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 40px;
            font-size: 2.5em;
        }
        .course-container {
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);
            margin-bottom: 25px;
            padding: 25px 30px;
            transition: transform 0.2s ease-in-out;
            max-width: 800px; /* Ограничиваем ширину контейнера */
            margin-left: auto;
            margin-right: auto;
        }
        .course-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.12);
        }
        h2 {
            font-size: 1.8em;
            margin-top: 0;
            margin-bottom: 10px;
        }
        h2 a {
            color: #3498db;
            text-decoration: none;
            transition: color 0.2s ease-in-out;
        }
        h2 a:hover {
            color: #2980b9;
            text-decoration: underline;
        }
        p {
            font-size: 1.1em;
            color: #555;
            margin-bottom: 0;
        }
        .no-courses-message {
            text-align: center;
            font-size: 1.2em;
            color: #777;
            padding: 50px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
            max-width: 600px;
            margin: 50px auto;
        }
    </style>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<h1>${page.getHeader()}</h1>
@if(page.getCourses().isEmpty())
    <div class="no-courses-message">
        <p>Пока не добавлено ни одного курса</p>
    </div>
@else
    @for(var course : page.getCourses())
        <div class="course-container">
            <h2><a href="/courses/${course.getId()}">${course.getName()}</a></h2>
            <p>${course.getDescription()}</p>
        </div>
    @endfor
@endif
</body>
</html>