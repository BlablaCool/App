<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>
<%--@elvariable id="step" type="info.fges.blablacool.models.Step"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script>
      var locations = ${trip.stepsInJson};
      var idTripToCopy = ${trip.idTrip};
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
          <h1 class="page-title clearfix text-center">
            Copier : ${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="panel panel-default">
            <div class="panel-body" style="padding: 18px;">
              <h3>Étapes</h3>

              <c:forEach items="${trip.steps}" var="step">
                <form class="row stepContainer">
                  <input type="hidden" name="step" value="${step.idStep}" />
                  <div class="col-md-6">
                    <div class="form-group">
                      <label>Ville</label>
                      <input class="form-control" type="text" name="place" value="${step.place.address}" readonly>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <label>Date</label>
                      <input class="form-control date-pick" name="date" type="text">
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-group">
                      <label>Heure</label>
                      <input class="form-control time-pick" name="time" type="text">
                    </div>
                  </div>
                </form>
              </c:forEach>

              <p class="text-center mt20">
                <button type="button" id="createCopy" class="btn btn-lg btn-success">Créer une copie</button>
              </p>
            </div>
          </div>
        </div>
      </div>

      <div class="gap"></div>
    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>