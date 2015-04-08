<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication var="userFromSecurity" property="principal" />

<%--@elvariable id="userFromSecurity" type="info.fges.blablacool.models.User"--%>

<div class="col-md-3">
    <aside class="user-profile-sidebar">
        <div class="user-profile-avatar text-center">
            <h5>${userFromSecurity.nickname}</h5>
        </div>
        <ul class="list user-profile-nav">
            <s:url var="url_profile" value="/users/1"/>
            <li><a href="${url_profile}"><i class="fa fa-user"></i>Mon profil</a></li>
            <s:url var="url_profile_driver" value="/users/driver"/>
            <li><a href="${url_profile_driver}"><i class="fa fa-car"></i>Mon profil Conducteur</a></li>
            <s:url var="url_profile_passenger" value="/users/passenger"/>
            <li><a href="${url_profile_passenger}"><i class="fa fa-male"></i>Mon profil Passager</a></li>
            <s:url var="url_profile_cars" value="/users/cars"/>
            <li><a href="${url_profile_cars}"><i class="fa fa-car"></i>Mes voitures</a></li>
            <s:url var="url_profile_plans" value="/users/plans"/>
            <li><a href="${url_profile_plans}"><i class="fa fa-credit-card"></i>Abonnements</a></li>
            <s:url var="url_profile_settings" value="/users/settings"/>
            <li><a href="${url_profile_settings}"><i class="fa fa-cog"></i>Paramètres</a></li>
        </ul>
    </aside>
</div>
