<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MDMW_TextEditor</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
	<!-- Main Quill library -->
	<script src="//cdn.quilljs.com/1.0.0/quill.js"></script>
	<script src="//cdn.quilljs.com/1.0.0/quill.min.js"></script>
	
	<!-- Theme included stylesheets -->
	<link href="//cdn.quilljs.com/1.0.0/quill.snow.css" rel="stylesheet" />
	<link href="//cdn.quilljs.com/1.0.0/quill.bubble.css" rel="stylesheet" />
	
	<!-- Core build with no theme, formatting, non-essential modules -->
	<link href="//cdn.quilljs.com/1.0.0/quill.core.css" rel="stylesheet" />
	<script src="//cdn.quilljs.com/1.0.0/quill.core.js"></script>
	
	<link rel="icon" type="image/x-icon" href="./resources/tempFavicon.ico">
</head>

<body>
	<h1>Text editor</h1>
	<div id="quill-space" class="col-10 mx-auto justify-content-center">
	
	
		<!-- Create the editor container -->
		<div id="editor">
		  <p>Hello World!</p>
		</div>
		
		<button class="btn btn-secondary" type="button" onclick="alert(document.getElementById('editor').innerHTML)">Clic!</button>
	
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
		  
		  [{ 'font': [] }],

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