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
    <%--<script src="/assets/js/users.pending-booking.js"></script>--%>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="container">
      <h1 class="page-title">Mon profil Passager</h1>
    </div>
    <div class="container">
      <div class="row">
        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
        <div class="col-md-9">
            <div class="panel panel-default">
              <div class="panel-body">
                <h4><i class="fa fa-star"></i> &nbsp;Voyages en attente d'évaluation : </h4>
                <c:choose>
                  <c:when test="${bookingWaitingReviews.size() == 0}">
                    <p class="lead text-center text-success mt20">
                      Aucun voyage
                    </p>
                  </c:when>
                  <c:otherwise>
                    <table id="pendingBookingTable" class="table table-bordered table-striped table-booking-history">
                      <thead>
                      <tr>
                        <th width="20%">Date</th>
                        <th width="35%">Trajet</th>
                        <th width="20%"></th>
                      </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${bookingWaitingReviews}" var="booking">
                        <tr>
                          <td><strong><joda:format value="${booking.createdTime}" pattern="dd/MM/yyyy" /></strong></td>
                          <td><a href="/trips/${booking.trip.idTrip}" target="_blank">${booking.step.place.city} <i class="fa fa-angle-right fa-fw"></i>${booking.trip.arrivalStep.place.city}</a></td>
                          <td style="text-align: center;">
                            <div class="btn-group btn-group-sm" style="margin: 9px 0;">
                              <a href="/booking/${booking.id}/review" class="btn btn-success">Évaluer</a>
                            </div>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
            <hr>

            <div class="row mt40">
              <div class="col-md-10 col-md-offset-1">
                <h3>Réservations à venir</h3>
                <c:choose>
                  <c:when test="${user.booking.size() > 0}">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Heure</th>
                          <th>Trajet</th>
                          <th>État</th>
                          <th style="text-align: center;">Paiement</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:forEach items="${user.passengerUpcomingBookings}" var="booking">
                        <tr>
                          <td>
                            <joda:format value="${booking.createdTime}" pattern="dd/MM/yyyy" /><br />
                            à <joda:format value="${booking.createdTime}" pattern="HH:mm:ss" /><br />
                          </td>
                          <td style="vertical-align: middle; font-weight: bold;">
                            ${booking.trip.departureStep.place.city}<i class="fa fa-angle-right fa-fw"></i>${booking.trip.arrivalStep.place.city}
                          </td>
                          <td style="vertical-align: middle;">
                            <c:choose>
                              <c:when test="${booking.status == 'PENDING'}">
                                <a href="/booking/${booking.id}" class="btn btn-warning btn-xs">EN ATTENTE DE VALIDATION</a>
                              </c:when>
                              <c:when test="${booking.status == 'ACCEPTED'}">
                                <a href="/booking/${booking.id}" class="btn btn-success btn-xs">CONFIRMÉE</a>
                              </c:when>
                              <c:when test="${booking.status == 'DECLINED'}">
                                <a href="/booking/${booking.id}" class="btn btn-danger btn-xs">REFUSÉE</a>
                              </c:when>
                              <c:when test="${booking.status == 'PAID'}">
                                <a href="/booking/${booking.id}" class="btn btn-primary btn-xs">PAYÉE</a>
                              </c:when>
                              <c:when test="${booking.status == 'CANCELLED'}">
                                <a href="/booking/${booking.id}" class="btn btn-default btn-xs">ANNULÉE</a>
                              </c:when>
                            </c:choose>
                          </td>
                          <td style="vertical-align: middle; text-align: center;">
                            <c:if test="${booking.payments.size() == 1}">
                              <i class="fa fa-check-square-o fa-2x text-success"></i>
                            </c:if>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>
                    </table>
                  </c:when>
                  <c:otherwise>
                    <p class="lead text-center" style="margin-top: 42px;">
                      Aucune réservation !<br /><br />
                      <a href="/trips/" class="btn btm-lg btn-success">Parcourir les voyages disponibles !</a> </p>
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