<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html class="full">
    <head>
        <title>Se connecter / S'enregistrer – BlablaCool</title>
        <tiles:insertAttribute name="header-meta" />
        <tiles:insertAttribute name="header-custom-css" ignore="true" />
    </head>
    <body class="full">
    <div class="global-wrap">
        <div class="full-page">
            <div class="bg-holder full">
                <div class="bg-mask"></div>

                    <tiles:insertAttribute name="body" />

                    <ul class="footer-links">
                        <li><a href="/about">Á Propos</a></li>
                        <li><a href="/help">Aide</a></li>
                        <li><a href="/contact">Nous contacter</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer-js" />
    <tiles:insertAttribute name="footer-custom-js" ignore="true" />
    </body>
</html>