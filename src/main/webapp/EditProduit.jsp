<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertion</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
		<br/>
	<%@include file="Header.jsp"%>
	<div class="container-fluid" style="max-width: 90%;">
			
			<div class="card text-bg-secondary " style="max-width: 100%;">
  				<div class="card-header">Modifier un produit</div>
  				<div class="card-body">
  					<form action="UpdateProduit.do" method="post">
  					<div class="mb-3">
   							 <label  class="form-label">ID</label>
   							 <input type="text" name="id" value="${produit.id}" class="form-control" required="required" >
   								<span></span>
 						 </div>
  						<div class="mb-3">
   							 <label  class="form-label">Designation</label>
   							 <input type="text" name="designation" value="${produit.designation}" class="form-control" required="required" >
   								<span></span>
 						 </div>
 						 <div class="mb-3">
   							 <label  class="form-label">Prix</label>
   							 <input type="text" name="prix" value="${produit.prix}" class="form-control" >
   								<span></span>
 						 </div>
 						 <div class="mb-3">
   							 <label  class="form-label">Quantite</label>
   							 <input type="text" name="quantite" value="${produit.quantite}" class="form-control" >
   								<span></span>
 						 </div>
 						
  						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
  				
   				</div>
  			</div>
  			
	</div>

		
</body>
</html>