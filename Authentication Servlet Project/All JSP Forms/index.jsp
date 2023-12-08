<%
//In your servlet
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setHeader("Expires", "0"); // Proxies

 if(session.getAttribute("name")==null){
	response.sendRedirect("login.jsp");
 }

 session.setAttribute("pass", null);

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    
    <link rel="stylesheet" href="css/stylo.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Agbalumo&family=Nunito&family=Poppins:wght@300&display=swap" rel="stylesheet">
    
    <script type ="text/javascript">

    window.history.pushState(null, null, 'login.jsp');

    </script>

    
</head>
<body>
    <body>
    <div class="navbar">
        <div class="logo">The Andro Guide</div>
        <div> <a href= " logout "class="btn">Logout</a></div>
    </div>
    <div class="mainbox">
        <div class="font"><h1>Hello <%=session.getAttribute("name") %>, <br>This is a Landing Page that i've created just to show the Authentication.</h1></div>
       
        <div class="ghbtn"> <a href= "https://github.com/Jatinm1/My-Projects/tree/main/Expenser"class="ghbutton">Expense Tracker App in JAVA<img src="css/icons8-github.svg" alt=""> </a></div>
    </div>
    
</body>
</body>
</html>