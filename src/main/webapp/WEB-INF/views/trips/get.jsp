<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

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
                  <div class="col-md-6">

                    <img src="http://placehold.it/500x500" class="pull-left img-thumbnail" width="120px" style="margin-right: 20px;" />


                    <h4>À propos du conducteur :</h4>


                  </div>
                  <div class="col-md-6">
                    <h4>Informations sur le trajet :</h4>
                    <h5>Étapes</h5>
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Etape</th>
                          <th>Date et heure</th>
                        </tr>
                      </thead>
                      <tbody>

                      </tbody>
                      <tfoot>

                      </tfoot>
                    </table>
                    <c:forEach items="${trip.steps}" var="step">
                      ${step.place.address}
                    </c:forEach>
                  </div>
                </div>
              </form>
            </div>
          </div>
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