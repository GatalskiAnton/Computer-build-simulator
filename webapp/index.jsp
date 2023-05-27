<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 4/14/2023
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    hello
    <button onclick="myfunc1()">press</button>
    <button onclick="myfunc1()">press2</button>
<script>
    async function myfunc1() {
        const response = await fetch("http://localhost:9090/PCBuilder_war_exploded/da/da/da",
            {
                mode: 'cors',
                method: "POST",
                headers: {
                    Accept: "application/json",
                    "Content-Type": "application/json",
                    requestType: "componentRequest",
                    'Access-Control-Allow-Origin': '*',
                },
                body: JSON.stringify({
                    "operation": 'changePass',
                    "login": 'java1@mail.com',
                    "newPassword": 'qwerty1',
                })
            }).then(response => {
            if (!response.ok) {
                console.log(response.status);
                console.log(response);
                console.log(response.headers.get("errorType"))
            }
            else {
                console.log("success");
            }
        })
            .catch(error => {
                console.log(error);
            }).finally();
    }
</script>
</body>
</html>
