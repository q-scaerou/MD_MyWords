<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MDMW - My Notebooks</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
	<link rel="icon" type="image/x-icon" href="./resources/tempFavicon.ico">
</head>
<body>
	<h1>My Notebooks</h1>
	<div class="col-8 justify-content-center mx-auto">
		<table class="table table-striped">
			<thead class="thead-light">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creation Date</th>
					<th scope="col">Group</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notebooks}" var="notebook">
					<tr>
						<td>${notebook.notebookName }</td>
						<td></td>
						<td>${notebook.idNotebook }</td>
						<td>
							<form>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-book"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-pencil-square"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-share"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-download"></i></button>
								<button class="btn btn-outline-dark rounded-circle"><i class="bi bi-trash3"></i></button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>