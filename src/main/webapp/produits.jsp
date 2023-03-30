<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'accueil</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
	<br/>
	<%@include file="Header.jsp"%>
	<div class="container-fluid" style="max-width: 100%;">
			
			<div class="card text-bg-secondary" style="max-width: 100%;" >
  				<div class="card-header">Recherche des produits</div>
  				<div class="card-body">
   					<form action="chercher.do" method="get">
   					
   						<div class="row g-3 align-items-center">
 							<div class="col-auto">
    								<label class="col-form-label">Entrez le mot clé</label>
  							</div>
  							<div class="col-auto">
   							 	<input type="text" name="motCLe" value="${model.motCle}"   class="form-control">
 							</div>
						</div>
  
  						<button type="submit" class="btn btn-primary">Submit</button>
					</form><br/>
					
					<table class="table table-light table-hover">
							<thead>
    							<tr>
     								 <th scope="col">id</th>
     								 <th scope="col">Designation</th>
      								 <th scope="col">Prix</th>
    							     <th scope="col">Quantité</th>
   								 </tr>
  						    </thead>
 						    <tbody>
 						    <c:forEach items="${model.produits}" var="p"> 
 						    		<tr>
   								   	    <th scope="row"><c:out value="${p.id}"/></th>
     							  		     <td><c:out value="${p.designation}"/></td>
     							  		     <td><c:out value="${p.prix}"/></td>
     							 		     <td><c:out value="${p.quantite}"/></td>
     							 		     <td><a onclick="return confirm('etes vous sur?')" href="Supprimer.do?id=${p.id}">Supprimer</a></td>
     							 		     <td><a href="Edit.do?id=${p.id}">Edit</a></td>
   							   		 </tr>

 						    </c:forEach>
 						    </tbody>
 					</table>
				</div>
			</div>
	</div>
</body>
</html>