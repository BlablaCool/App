<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<%--@elvariable id="viewedUser" type="info.fges.blablacool.models.User"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>
<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>
<%--@elvariable id="review" type="info.fges.blablacool.models.Review"--%>

<tiles:insertDefinition name="blablacoolTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">
                <c:choose>
                    <c:when test="${viewedUser.id == user.id}">
                        <a class="booking-item-review-person-avatar round" href="rentals-details.html#">
                            <img src="/assets/img/good_job_100x100.jpg">&nbsp;
                        </a>
                        Mon compte
                    </c:when>
                    <c:when test="${viewedUser.id != user.id}">
                        <a class="booking-item-review-person-avatar round" href="rentals-details.html#">
                            <img src="/assets/img/good_job_100x100.jpg">&nbsp;
                        </a>
                        ${viewedUser.nickname}
                    </c:when>
                </c:choose>
            </h1>
        </div>
        <div class="container">
            <div class="row">
                <c:choose>
                    <c:when test="${viewedUser.id == user.id}">
                        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
                        <div class="col-md-9">
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-8 col-md-offset-2">
                    </c:otherwise>
                </c:choose>

                    <div class="text-center">
                        <ul class="list list-inline user-profile-statictics mb30">
                            <li><i class="fa fa-dashboard user-profile-statictics-icon"></i>
                                <h5>12 540</h5>
                                <p><strong>kilomètres</strong> parcourus</p>
                            </li>
                            <li><i class="fa fa-car user-profile-statictics-icon"></i>
                                <h5>${viewedUser.booking.size()}</h5>
                                <p>trajets comme <strong>passager</strong></p>
                            </li>
                            <li><i class="fa fa-car user-profile-statictics-icon"></i>
                                <h5>${viewedUser.trips.size()}</h5>
                                <p>trajets comme <strong>conducteur</strong></p>
                            </li>
                            <li>
                                <i class="fa fa-smile-o user-profile-statictics-icon"></i>
                                <h5>4.5/5</h5>
                                <p><strong>satisfaction</strong> des autres membres</p>
                            </li>
                            <li>
                                <c:if test="${viewedUser.hasActiveSubscription()}">
                                    <i class="fa fa-trophy user-profile-statictics-icon"></i>
                                    <h5>VIP</h5>
                                    <p>possède un <strong>abonnement</strong></p>
                                </c:if>
                                <c:if test="${!viewedUser.hasActiveSubscription()}">
                                    <i class="fa fa-star-half-o user-profile-statictics-icon"></i>
                                    <h5>Membre</h5>
                                    <p>ne possède pas d'abonnement</p>
                                </c:if>
                            </li>
                        </ul>
                    </div>

                    <div class="gap gap-small"></div>

                    <h3 class="mb20">Prochains voyages</h3>
                    <div class="row">
                        <c:choose>
                            <c:when test="${viewedUser.driverUpcomingTrips.size() == 0}">
                                <p class="lead text-center">Aucun voyage à l'horizon !</p>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${viewedUser.driverUpcomingTrips}" var="trip">
                                    <div class="col-md-4">
                                        <div class="panel panel-default">
                                            <div class="panel-body">
                                                <p class="mb0">
                                                    <a href="/trips/${trip.idTrip}"><strong>${trip.departureStep.place.city} <em> vers</em> ${trip.arrivalStep.place.city}</strong></a><br />
                                                    <small>le <joda:format value="${trip.departureStep.estimatedTime}" pattern="dd/MM/yyyy" /></small>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="gap gap-small"></div>

                    <h3 class="mb20">Avis des membres</h3>

                    <div class="row row-wrap">
                        <div class="col-md-12">
                            <ul class="booking-item-reviews list">
                                <c:forEach items="${user.reviewsReceived}" var="review">
                                    <li>
                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="booking-item-review-person">
                                                    <p class="booking-item-review-person-name"><a href="/users/${review.reviewer.id}">${review.reviewer.nickname}</a></p>
                                                    <p class="booking-item-review-person-loc"><i class="fa fa-car"> ${review.reviewer.trips.size()} voyage(s) </i></p>
                                                    <p class="booking-item-review-person-loc"><i class="fa fa-users"> ${review.reviewer.booking.size()} voyage(s)</i></p>
                                                    <p class="booking-item-review-person-loc"><i class="fa fa-star"> ${review.reviewer.reviewsReceived.size()} avis reçu(s)</i></p>
                                                    <small><joda:format value="${review.createdAt}" pattern="dd/MM/yyyy à HH:mm" /></small>
                                                </div>
                                            </div>
                                            <div class="col-md-10">
                                                <div class="booking-item-review-content">
                                                    <h5>${review.booking.trip.departureStep.place.city} <em> vers</em> ${review.booking.trip.arrivalStep.place.city}</h5>
                                                    <ul class="icon-group booking-item-rating-stars">
                                                        <c:forEach begin="1" end="5" varStatus="loop">
                                                            <c:choose>
                                                                <c:when test="${review.note >= loop.count}">
                                                                    <li><i class="fa fa-star"></i></li>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <li><i class="fa fa-star-o"></i></li>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </ul>
                                                    <p>
                                                        ${review.comment}
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="gap"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>





