<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="register" method="post" modelAttribute="user">
<div>
<table>
<tr><td style="color: red;"><form:errors path="name"/></td></tr>
<tr><td style="color: red;"><form:errors path="mailId"/></td></tr>
<tr><td style="color: red;"><form:errors path="password"/></td></tr>
</table>
</div>
<table width="500">
<tr>
<th align="left">Name</th><td><form:input type="text" path="name" /></td>
</tr>
<tr>
<th align="left">MailId</th><td><form:input type="text" path="mailId"/></td>
</tr>
<tr>
<th align="left">Password</th><td><form:input type="password" path="password"/>
</tr>
<tr>
<th align="left"></th><td><input type="submit" value="Register" /></td>
</tr>
</table>
</form:form>