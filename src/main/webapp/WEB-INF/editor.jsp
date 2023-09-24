<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MDMW - TextEditor</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
	
	<!-- Main Quill library -->
	<script src="//cdn.quilljs.com/1.0.0/quill.js"></script>
	<script src="//cdn.quilljs.com/1.0.0/quill.min.js"></script>
	
	<!-- Theme included stylesheets -->
	<link href="//cdn.quilljs.com/1.0.0/quill.snow.css" rel="stylesheet" />
	<link href="//cdn.quilljs.com/1.0.0/quill.bubble.css" rel="stylesheet" />
	
	<!-- Core build with no theme, formatting, non-essential modules -->
	<link href="//cdn.quilljs.com/1.0.0/quill.core.css" rel="stylesheet" />
	<script src="//cdn.quilljs.com/1.0.0/quill.core.js"></script>
	
	<link rel="stylesheet" type="text/css" href="./resources/css/style.css" />
	<link rel="icon" type="image/x-icon" href="./resources/tempFavicon.ico">
	<script src="./resources/js/editor.js" defer></script>
	
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
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="editor">New
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
	<div id="quill-space" class="col-10 mx-auto justify-content-center">
	
	
		<!-- Create the editor container -->
		<div id="editor">
		  <p>Hello World!</p>
		</div>
		
		<button class="btn btn-secondary" type="button" onclick="getEditorContent()">Clic!</button>
	
	</div>
	
	<!-- Include the Quill library -->
	<script src="https://cdn.quilljs.com/1.0.0/quill.js"></script>
	
	<!-- Initialize Quill editor -->
	<script>
		var toolbarOptions = [
			  ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
			  ['blockquote', 'code-block'],
	
			  [{ 'list': 'ordered'}, { 'list': 'bullet' }],
	
			  [{ 'header': [1, 2, 3, 4, false] }],
			  
			  ['clean']                                         // remove formatting button
			];
		
		var options = {
		  debug: 'info',
		  modules: {
		    toolbar: toolbarOptions
		  },
		  readOnly: false,
		  theme: 'snow'
		};
		var editor = new Quill('#editor', options);
		
		elements = document.getElementsByClassName("ql-toolbar");
		var toolbarClass = elements[0].getAttribute("class");
		toolbarClass += " px-5";
		elements[0].setAttribute("class", toolbarClass);	
	</script>
</body>
</html>