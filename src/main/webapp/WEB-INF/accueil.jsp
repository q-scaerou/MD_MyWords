<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="editor">New
							notebook</a></li>
					<li class="nav-item"><a class="nav-link" href="notebooks">My
							Notebooks</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Recent
							notebooks </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">nb 1</a></li>
							<li><a class="dropdown-item" href="#">nb 2</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">All nb</a></li>
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
	<div class="justify-content-center" style="border:solid 1px red;">
		<div class="w-75 mx-auto my-5" style="border:solid 1px green;">
			<div class="text-center">
				<h2>Concept</h2>
			</div>
			<div class="pl-5">
				<p>MarkDown My Words aims to provide a simple writing experience.</p>
				<p>
					Using the quill API, it provides a text editor to simply write notes online and group them in a notebook.
					The purpose of this application is also to be able to download theses notes and/or notebooks in the MarkDown format.
				</p>
				<p>
					The application also aims to offer an efficient and easy to use MarkDown reader for uploaded files.
				</p>
				<p>
					To me, it's a very useful tool to take and organize my notes as well as an interesting exercise to develop 
					my skills when using Strings.
				</p>
			</div>
		</div>
	</div>
</body>
</html>