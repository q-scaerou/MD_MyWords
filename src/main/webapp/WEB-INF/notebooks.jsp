<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MDMW - My Notebooks</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
	<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
	<link rel="icon" type="image/x-icon" href="./resources/tempFavicon.ico">
	<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"><img alt="Logo MarkDown MyWord" title="MarkDown MyWords" src="resources/assets/logo.png" id="logo"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="editor">New
							notebook</a></li>
					<li class="nav-item"><a class="nav-link active" href="notebooks">My
							Notebooks</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Recent
							notebooks </a>
						<ul class="dropdown-menu">
							<c:forEach items="${recentNB}" var="nb">
								<li><a class="dropdown-item" href="#">${nb.title}</a></li>
							</c:forEach>
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
	<h1>My Notebooks</h1>
	<div class="col-8 justify-content-center mx-auto">
		<table class="table table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creation Date</th>
					<th scope="col">Group</th>
					<th scope="col">Last modification</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notebooks}" var="notebook">
					<tr>
						<td>${notebook.title}</td>
						<fmt:parseDate value="${notebook.creationDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${pageScope.parsedDateTime}" />
						</td>
						
						<td>${notebook.id}</td>
						<fmt:parseDate value="${notebook.modificationDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy' @ 'HH:mm" value="${pageScope.parsedDateTime}" />
						</td>
						<td>
							<form>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-book"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-pencil-square"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-download"></i></button>
								<button class="btn btn-outline-primary rounded-circle"><i class="bi bi-share"></i></button>
								<button class="btn btn-outline-danger rounded-circle"><i class="bi bi-trash3"></i></button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>