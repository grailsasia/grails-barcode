<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<g:each in="${items}" var="item">
    <div>This is the barcode for the number: ${item.number}</div>
    <div><rendering:inlineJpeg bytes="${item.bytes}" width="170"/></div>
    <hr/>
</g:each>
</body>
</html>