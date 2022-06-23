<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<section class="book" id="book">



    <div class="row">

        <div class="image">
            <img src="images/book-img.svg" alt="">
        </div>

        <form action="RegisterServlet" method="POST">
            <h1 class="heading"> Register </h1>  
            <div class="responsive">
                <label>Full Name:</label> <span><input type="text" name="fullName" required class="box"/></span>
                <label>Age:</label><span><input type="text" name="age" required class="box" /></span>
                <label>Birthday:</label><span><input  type="text" name="dob" required  class="box"/></span>
                <label>Address:</label><span><input type="text" name="address" required class="box"/></span>
                <label>Phone number:</label><span><input type="text" name="tel" pattern="0[0-9]{3} [0-9]{6}" required class="box"/></span>
                <label>Email:</label><span><input type="text" name="email" required class="box"/></span>
                <label>Identity number:</label><span><input type="text" name="cccd" required class="box"/></span>
                <label>Career:</label><span><input type="text" name="career" required class="box"/></span>
                <label>Health insurance number:</label><span><input type="text" name="bhyt" required class="box"/></span>
                <label>Gender:</label></br>
                <label>Male</label><span><input type="radio" name="gender" value="male" id="male" class="box"></span>
                <label>Female</label><span><input type="radio" name="gender" value="female" id="female" class="box"></span>     
                <label>Password:</label><span><input type="password" name="password" required class="box"/></span>
                <label>Confirm password:</label><span><input type="repassword" name="repassword" required class="box"/></span>
                <input type="submit" value="Register" class="btn">
            </div>
        </form>

    </div>

</section>
</body>
</html>