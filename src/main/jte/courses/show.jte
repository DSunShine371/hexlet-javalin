@import org.example.hexlet.model.Course
@param Course page

<html>
<head>
    <meta charset="UTF-8">
    <title>${page.getName()}</title>
</head>
<body>
<main>
    <h1>${page.getName()}</h1>
    <p>${page.getDescription()}</p>
    <a href="/courses">Вернуться к списку курсов</a>
</main>
</body>
</html>
