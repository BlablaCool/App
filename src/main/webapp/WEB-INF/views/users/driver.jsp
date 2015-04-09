<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>
<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script src="/assets/js/users.pending-booking.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="container">
      <h1 class="page-title">Mon profil Conducteur</h1>
    </div>
    <div class="container">
      <div class="row">
        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
        <div class="col-md-9">
          <div class="panel panel-default">
            <div class="panel-body">
              <h4>Réservations en attente...</h4>
              <table id="pendingBookingTable" class="table table-bordered table-striped table-booking-history">
                <thead>
                <tr>
                  <th width="20%">Date</th>
                  <th width="20%">Membre</th>
                  <th width="35%">Trajet</th>
                  <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pendingBooking}" var="booking">
                  <tr>
                    <td><strong><joda:format value="${booking.createdTime}" pattern="dd/MM/yyyy - HH:mm:ss" /></strong></td>
                    <td><a href="/users/${booking.user.id}" target="_blank">${booking.user.nickname}</a></td>
                    <td><a href="/trips/${booking.trip.idTrip}" target="_blank">${booking.step.place.city} <i class="fa fa-angle-right fa-fw"></i>${booking.trip.arrivalStep.place.city}</a></td>
                    <td style="text-align: center;">
                      <div class="btn-group btn-group-sm" style="margin: 9px 0;">
                        <button class="btn btn-success accept-booking" data-booking="${booking.id}">Accepter</button>
                        <button class="btn btn-danger decline-booking" data-booking="${booking.id}">Refuser</button>
                      </div>
                    </td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-md-6">
              <h5><i class="fa fa-smile-o"></i> Voyages à venir</h5>
              <c:choose>
                <c:when test="${user.driverUpcomingTrips.size() > 0}">
                  <table class="table">
                    <tbody>
                    <c:forEach items="${user.driverUpcomingTrips}" var="trip">
                      <tr>
                        <td><joda:format value="${trip.departureStep.estimatedTime}" pattern="dd/MM/yyyy" /></td>
                        <td>${trip.departureStep.place.city}<i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</td>
                        <td><a href="/trips/copy/${trip.idTrip}" class="btn btn-success btn-xs">Copier</a></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </c:when>
                <c:otherwise>
                  <p class="lead text-center" style="margin-top: 42px;">
                    Aucun voyage à l'horizon !<br /><br />
                    <a href="/trips/new" class="btn btm-lg btn-success">Créer un voyage !</a> </p>
                </c:otherwise>
              </c:choose>
            </div>
            <div class="col-md-6">
              <h5><i class="fa fa-history" style="margin-bottom: 20px;"></i> Voyages passés</h5>
              <c:choose>
                <c:when test="${user.driverLastTrips.size() > 0}">
                  <table class="table">
                    <tbody>
                    <c:forEach items="${user.driverLastTrips}" var="trip">
                      <tr>
                        <td style="vertical-align: middle;"><joda:format value="${trip.departureStep.estimatedTime}" pattern="dd/MM/yyyy" /></td>
                        <td style="vertical-align: middle;">${trip.departureStep.place.city}<i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</td>
                        <td style="vertical-align: middle;"><a href="/trips/copy/${trip.idTrip}" class="btn btn-success btn-sm  ">Copier...</a></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </c:when>
                <c:otherwise>
                  <p class="lead text-center" style="margin-top: 42px;">
                    Aucun voyage réalisé !
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>