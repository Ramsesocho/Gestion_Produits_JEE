<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>voir le produit</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
		<br/>
	<%@include file="Header.jsp"%>
	<div class="container-fluid" style="max-width: 90%;">
			
			<div class="card text-bg-secondary " style="max-width: 100%;">
  				<div class="card-header">Ce produit a éte ajouté</div>
  				<div class="card-body">
  					
  					<div class="form-control">
   						 <label  class="form-label">ID:</label>
   						 <label  class="form-label">${produit.id}</label>		 
 					 </div>
 					 <div class="form-control">
   						 <label  class="form-label">Designation:</label>
   						 <label  class="form-label">${produit.designation}</label>		 
 					 </div>
 					 <div class="form-control">
   						 <label  class="form-label">Prix:</label>
   						 <label  class="form-label">${produit.prix}</label>		 
 					 </div>
 					  <div class="form-control">
   						 <label  class="form-label">Quantite:</label>
   						 <label  class="form-label">${produit.quantite}</label>		 
 					 </div>
   					
   				</div>
  			</div>
  			
	</div>

		
</body>
</html>