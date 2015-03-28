<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script>
      var locations = ${trip.stepsInJson};
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
            <span class="pull-right"><fmt:formatNumber value="${trip.price}" type="currency"/></span>
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

                    <div class="row">
                      <div class="col-md-4">
                        <img src="http://placehold.it/500x500" class="img-thumbnail" />
                      </div>
                      <div class="col-md-8">
                        <h5>À propos du conducteur :</h5>
                      </div>
                    </div>

                  </div>
                  <div class="col-md-6">
                    <h5>Informations sur le trajet :</h5>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>