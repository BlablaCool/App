<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html>
    <head>
        <tiles:insertAttribute name="header-meta" />
        <tiles:insertAttribute name="header-custom-css" ignore="true" />
    </head>
    <body>
        <div class="global-wrap">
            <header id="main-header">
                <tiles:insertAttribute name="header" />
                <%--<tiles:insertAttribute name="top-menu" />--%>
            </header>
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>
        <tiles:insertAttribute name="footer-js" />
        <tiles:insertAttribute name="footer-custom-js" ignore="true" />
    </body>
</html>