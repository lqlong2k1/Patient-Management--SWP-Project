<%@page contentType="text/html" errorPage="error.jsp" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="witdth=device-width, initial-scale=1.0">
	<title></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://kit.fontawesome.com/9ee78b02b3.js" crossorigin="anonymous"></script>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
</head>
<body>
	<header class="header">
	
	<div class="head">
		<div class="signupAndResgister">
			<nav class="navbar1">
				<a href="LogoutServlet">Log out</a>             
			</nav>
		</div>
	</div>
	<div class="head2">
		
	<nav class="navbar">
        <a href="#home">home</a>
        <a href="/PatientMAnagement2/ViewMedicalRecordServlet?action=viewlistMR&userID=${acc.user}">My Medical Records</a>
         <a href="ViewAndUpdateServlet">My Profile</a>
        <a href="/PatientMAnagement2/ViewListPatientServlet?action=viewpatients">View List Patients</a>
        <a href="/PatientMAnagement2/ViewScheduleServlet?action=viewschedules">My Schedules</a>
        <a href="#about">My Notifications</a>
        <a href="/PatientMAnagement2/ViewDoctorServlet?action=viewdoctors">Doctors</a>
    </nav>
</div>
</header>