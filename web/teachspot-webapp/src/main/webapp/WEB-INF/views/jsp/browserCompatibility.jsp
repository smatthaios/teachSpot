<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!doctype html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<c:url value="/styles/b.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/styles/generic.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/styles/ace.css" />" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/styles/app.css" />" />
        <title><fmt:message key="general.label.title" /></title>
    </head>
    <body>
        <div class="modal-header">
            <h3 class="red"><i class="icon-warning"></i>&nbsp;&nbsp;<fmt:message key="browserCompatibility.warning.title" /></h3>
        </div>
        <div class="modal-body">
            <h4 class="no-padding"><fmt:message key="browserCompatibility.warning.text" />:</h4>
            <br>
            <ul>
                <li class="red"><h4><a href='http://windows.microsoft.com/en-us/internet-explorer/download-ie'>Internet Explorer</a></h4></li>
                <li class="red"><h4><a href='http://www.mozilla.org/en-US/firefox/new/'>Mozilla Firefox</a></h4></li>
                <li class="red"><h4><a href='http://www.opera.com/computer/windows'>Opera</a></h4></li>
                <li class="red"><h4><a href='http://support.apple.com/kb/dl1531'>Safari</a></h4></li>
            </ul>
        </div>
    </body>
</html>
