<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3">
    <aside class="user-profile-sidebar">
        <div class="user-profile-avatar text-center">
            <h5><c:out value="${viewedUser.firstname} ${viewedUser.lastname}"/></h5>
        </div>
        <ul class="list user-profile-nav">
            <s:url var="url_profile" value="/users/1"/>
            <li><a href="${url_profile}"><i class="fa fa-user"></i>Profil</a></li>
            <s:url var="url_profile_driver" value="/users/driver"/>
            <c:if test="${viewedUser.id==user.id}">
            <li><a href="${url_profile_driver}"><i class="fa fa-car"></i>Mon profil Conducteur</a></li>
            <s:url var="url_profile_history" value="/users/1/history"/>
            <li><a href="${url_profile_history}"><i class="fa fa-clock-o"></i>Historique des trajets</a></li>
            <s:url var="url_profile_cars" value="/users/cars"/>
            <li><a href="${url_profile_cars}"><i class="fa fa-car"></i>Mes voitures</a></li>
            <s:url var="url_profile_plans" value="/users/plans"/>
            <li><a href="${url_profile_plans}"><i class="fa fa-credit-card"></i>Abonnements</a></li>
                <s:url var="url_profile_update" value="/users/update"/>
                <li><a href="${url_profile_update}"><i class="fa fa-cog"></i>Paramètres</a></li>
            </c:if>
        </ul>
    </aside>
</div>
