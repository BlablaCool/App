<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>

<tiles:insertDefinition name="blablacoolTemplate">
  <tiles:putAttribute name="body">
    <div class="container">
      <h1 class="page-title">Réservations en attente de validation</h1>
    </div>
    <div class="container">
      <div class="row">
        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
        <div class="col-md-9">

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
                <td><a href="/users/${booking.user.id}">${booking.user.nickname}</a></td>
                <td>${booking.step.place.city} <i class="fa fa-angle-right fa-fw"></i>${booking.trip.arrivalStep.place.city}</td>
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
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>