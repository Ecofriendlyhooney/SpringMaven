
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>SKB Admin Page</h1>
<table border="2" width="100%" padding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Edit</th>
		<th>Delete</th>
		<!-- th>Edit</th><th>Delete</th> -->
	</tr>
	<c:forEach var="skb" items="${list}">
		<tr>
			<td>${skb.id}</td>
			<td>${skb.name}</td>
			<td><a href="admin/editskb/${skb.id}">Edit</a></td>
			<td><a href="admin/deleteskb/${skb.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="admin/skbform">Add Schdule</a>