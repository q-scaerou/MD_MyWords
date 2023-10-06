<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MD MyWords - Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
<link rel="icon" type="image/x-icon" href="./resources/assets/MDMW_favicon.ico">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><img alt="Logo MarkDown MyWord" title="MarkDown MyWords" src="resources/assets/MDMW_logo.png" id="logo"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="editor">New
							notebook</a></li>
					<li class="nav-item"><a class="nav-link" href="notebooks">My
							Notebooks</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Recent
							notebooks </a>
						<ul class="dropdown-menu">
							<c:forEach items="${recentNB}" var="nb">
								<li><a class="dropdown-item" href="#">${nb.title}</a></li>
							</c:forEach>
							<c:if test="${empty recentNB}">
								<li class="text-danger">No notebook found</li>
							</c:if>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="notebooks">All notebooks</a></li>
						</ul></li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-3" type="search"
						placeholder="Search notebook" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">
						<i class="bi bi-search"></i>
					</button>
				</form>
			</div>
		</div>
	</nav>

</body>
</html>