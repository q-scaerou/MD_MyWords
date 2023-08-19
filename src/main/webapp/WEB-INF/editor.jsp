<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MDMW_TextEditor</title>
	
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
	
	<!-- Create the toolbar container -->
	<div id="toolbar">
	  <button class="ql-bold">Bold</button>
	  <button class="ql-italic">Italic</button>
	  <button class="ql-header">Header</button>
	</div>

	<!-- Create the editor container -->
	<div id="editor">
	  <p>Hello World!</p>
	</div>
	<button type="button" onclick="alert(document.getElementById('editor').innerHTML)">Clic!</button>
	<!-- Include the Quill library -->
	<script src="https://cdn.quilljs.com/1.0.0/quill.js"></script>
	
	<!-- Initialize Quill editor -->
	<script>
	  var editor = new Quill('#editor', {
	    modules: { toolbar: '#toolbar' },
	    theme: 'snow',
	  });
	</script>
</body>
</html>