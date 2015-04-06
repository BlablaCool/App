<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script src="/assets/js/booking.review.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="gap"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <form name="submitReview" method="POST">
            <i class="fa fa-trophy box-icon-huge box-icon-center box-icon-warning box-icon-to-warning animate-icon-border-fadein mb30"></i>
            <h5 class="text-center mb30">Vous avez récemment participé à un voyage en tant que passager et<br />nous aimerions connaitre votre avis à ce sujet.</h5>
            <p class="lead text-center">
                ${booking.trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${booking.trip.arrivalStep.place.city}<br>
                  <small>le <joda:format value="${booking.trip.departureStep.estimatedTime}" pattern="dd/MM/yyyy" /></small>
            </p>

            <div id="bookingReviewStarsWrapper" class="row lead">
              <div id="stars-existing" class="starrr" data-rating='4'></div>
              <input type="hidden" name="rating" value="4" id="rating" />
            </div>

            <div class="row">
              <div class="col-md-8 col-md-offset-2 text-center">
                <textarea class="form-control" style="height: 84px;" placeholder="Un avis, une suggestion, une remarque..." name="comment"></textarea><br><br>
                <button type="submit" class="btn btn-success btn-lg">Évaluer mon voyage</button>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>