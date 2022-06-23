<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<section class="book" id="book">
    <div class="row">

        <div class="image">
            <img src="images/book-img.svg" alt="">
        </div>

        <form action="LoginServlet" method="POST">
        	<h1 class="heading"> LOG IN </h1>  
            <input type="text" placeholder="YourUSERID" class="box" name="UserID">
            <input type="password" placeholder="yourPASSWORD" class="box" name="Password">
            <br>${MSG}<br>
            <input type="submit" value="LOG IN" class="btn">
        </form>

    </div>

</section>
</body>
</html>