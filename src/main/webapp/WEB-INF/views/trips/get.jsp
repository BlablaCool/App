<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>
<%--@elvariable id="message" type="info.fges.blablacool.models.Message"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script>
      var locations = ${trip.stepsInJson};
      var idTrip = ${trip.idTrip};
    </script>
    <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
    <script src="/assets/js/maplace.min.js"></script>
    <script src="/assets/js/trips.get.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">

    <div id="bigMapOnTripPage"></div>

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="page-title clearfix">
            <span class="pull-left"><strong>${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</strong></span>
            <span class="pull-right">
              <%--<fmt:formatNumber value="${trip.price}" type="currency"/>--%>
              <button class="btn btn-lg btn-primary" data-toggle="modal" data-target="#bookingModal">Réserver</button>
            </span>
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <div class="panel panel-default">
            <div class="panel-body" style="padding-top: 14px;">
              <form id="infosForm" class="form-horizontal">
                <div class="row">
                  <div class="col-md-4">
                    <h4 style="text-align: center; font-weight: 600; text-transform: uppercase;">Le Conducteur</h4>
                  </div>
                  <div class="col-md-8">
                    <h4 style="text-align: center; font-weight: 600; text-transform: uppercase;">Le Voyage</h4>
                    <h5>Étapes</h5>
                    <table class="table">
                      <thead>
                        <tr>
                          <th style="width: 70%;">Etape</th>
                          <th style="width: 30%;">Date et heure</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${trip.steps}" var="step">
                          <tr>
                            <td>${step.place.address}</td>
                            <td><joda:format value="${step.estimatedTime}" pattern="dd/MM/yyyy à HH:mm:ss" /></td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <div class="row" style="margin: 21px 0;">
        <div class="col-md-8 col-md-offset-2">
          <h4 style="font-weight: 600; text-transform: uppercase; display: inline;">Participants</h4>
          <c:choose>
            <c:when test="${trip.hasAcceptedBookings()}">
              <ul id="participantsList">
              <c:forEach items="${trip.acceptedBookings}" var="booking">
                <li><a href="/users/${booking.user.id}"><img src="${booking.user.gravatarUrl}" class="img-circle img-thumbnail" style="max-width: 84px; max-height: 84px;" /></a></li>
              </c:forEach>
              </ul>
            </c:when>
            <c:otherwise>
              <p class="lead text-center;" style="display: inline; margin-left: 42px;">Aucun participant pour le moment...</p>
            </c:otherwise>
          </c:choose>
        </div>
      </div>

      <div class="row mt15">
        <div class="col-md-8 col-md-offset-2">
          <h4 class="ml10" style="font-weight: 600; text-transform: uppercase; display: inline;">Messages</h4>

          <form class="form-horizontal mt20" method="POST" action="/trips/${trip.idTrip}/add-message" accept-charset="UTF-8">
            <fieldset>
              <div class="form-group">
                <div class="col-md-12">
                  <textarea class="form-control" id="message" name="message" style="height: 84px;"></textarea>
                </div>
              </div>
              <button id="send" name="send" class="btn btn-success pull-right">Envoyer</button>
            </fieldset>
          </form>

          <ul id="messagesList" class="comments-list mt10">
            <c:forEach items="${trip.messages}" var="message">
              <li>
                <div class="article comment" inline_comment="comment">
                  <div class="comment-author">
                    <img src="${message.sender.gravatarUrl}" style="max-width: 42px; max-height: 42px;" />
                  </div>
                  <div class="comment-inner">
                    <span class="comment-author-name">${message.sender.nickname}</span>
                    <p class="comment-content">
                      ${message.message}
                    </p>
                    <span class="comment-time">le <joda:format value="${message.createdAt}" pattern="dd/MM/yyyy à HH:mm:ss" /></span>
                  </div>
                </div>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>

      <div class="gap"></div>
    </div>

    <div class="modal fade" id="bookingModal" tabindex="-1" role="dialog" style="margin-top: 120px;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Réserver ${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</h4>
          </div>
          <div class="modal-body">
            <p class="lead">Le montant du trajet est estimé à <strong><fmt:formatNumber value="${trip.price}" type="currency"/></strong>.</p>
            <p style="margin-bottom: 0;"><strong class="text-success">Vous êtes sur le point d'envoyer une demande à ${trip.driver.nickname} afin qu'il ou elle valide votre réservation.</strong> Vous serez prévenu dès que le statut sera mis à jour.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
            <button type="button" id="confirmBooking" class="btn btn-success btn-lg">Je veux une place !</button>
          </div>
        </div>
      </div>
    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>