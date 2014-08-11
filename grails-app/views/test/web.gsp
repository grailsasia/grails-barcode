<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<g:each in="${101..105}" var="number">
    <div>This is the barcode for the number: ${number}</div>
    <div><g:img dir="test" file="showBarcode?barcode=${number}"/></div>
    <hr/>
</g:each>
</body>
</html>