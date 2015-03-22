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
                <div class="bg-img" style="background-image:url('/assets/img/background-login-register.jpg');"></div>
                <div class="bg-holder-content full text-white">
                    <a class="logo-holder" href="/">
                        <img src="/assets/img/logo-white.png" />
                    </a>

                    <tiles:insertAttribute name="body" />

                    <ul class="footer-links">
                        <li><a href="login-register.html#">About</a>
                        </li>
                        <li><a href="login-register.html#">Help</a>
                        </li>
                        <li><a href="login-register.html#">Hot Deals</a>
                        </li>
                        <li><a href="login-register.html#">Popular Locations</a>
                        </li>
                        <li><a href="login-register.html#">Cheap Flights</a>
                        </li>
                        <li><a href="login-register.html#">Business</a>
                        </li>
                        <li><a href="login-register.html#">Media</a>
                        </li>
                        <li><a href="login-register.html#">Developers</a>
                        </li>
                        <li><a href="login-register.html#">Advertise</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer-js" />
    <tiles:insertAttribute name="footer-custom-js" ignore="true" />
    </body>
</html>