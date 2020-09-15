<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Pessoas do BD</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Celular</th>
			</tr>
			<%
				List<Pessoa> listaPessoas = (List<Pessoa>)request.getAttribute("listaDePessoas");
			
				for (Pessoa item : listaPessoas) {
			%>
					<tr>
						<td>
							<%=item.getId() %>
						</td>
						<td>
							<%=item.getNome() %>
						</td>
						<td>
							<%=item.getCel() %>
						</td>
					</tr>
			<%
				}
			%>
		</table>
	</div>
	<div id="msg" align="center">
		<%
			if(request.getAttribute("msg1") != null) {
		%>
				<p><%= request.getAttribute("msg1") %></p>
		<%
			}
		%>
	
	</div>
</body>
</html>