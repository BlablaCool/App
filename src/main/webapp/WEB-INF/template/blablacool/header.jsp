<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<sec:authentication var="userFromSecurity" property="principal" />

<%--@elvariable id="userFromSecurity" type="info.fges.blablacool.models.User"--%>

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
                        <sec:authorize access="!isAuthenticated()">
                            <li>
                                <a href="/auth/login-register">Créer un compte / Se connecter</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li class="top-user-area-avatar">
                                <s:url var="url_profile" value="/users/me"/>
                                <a href="${url_profile}">
                                    Compte de <strong>${userFromSecurity.nickname}</strong>
                                </a>
                            </li>
                            <li>
                                <a href="/auth/logout">Se déconnecter</a>
                            </li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>