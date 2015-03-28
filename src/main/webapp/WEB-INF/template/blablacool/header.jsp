<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="header-top">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a class="logo" href="/">
                    <img src="/assets/img/logo-white.png">
                </a>
            </div>
            <div class="col-md-4 col-md-offset-5">
                <div class="top-user-area clearfix">
                    <ul class="top-user-area-list list list-horizontal list-border">
                        <li class="top-user-area-avatar">
                            <s:url var="url_profile" value="/users/1"/>
                            <a href="${url_profile}">
                                Compte de John
                            </a>
                        </li>
                        <li><a href="/auth/logout">Se déconnecter</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>