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
        </div>
      </div>
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>