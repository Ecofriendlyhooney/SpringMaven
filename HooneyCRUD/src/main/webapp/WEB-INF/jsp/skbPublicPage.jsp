
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>SKB 2019 Public</h1>
<table border="2" width="100%" padding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
	</tr>
	<c:forEach var="skb" items="${list}">
		<tr>
			<td>${skb.id}</td>
			<td>${skb.name}</td>
		</tr>
	</c:forEach>
</table>
<br />
