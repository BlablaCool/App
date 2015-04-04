<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="body">
    <div class="gap"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <i class="fa fa-times round box-icon-large box-icon-center box-icon-black mb30"></i>
          <h2 class="text-center">Demande déclinée</h2>
          <h5 class="text-center mb30"><em>${booking.trip.driver.nickname}</em> ne souhaite pas donner suite à votre demande de réservation.<br>Ne vous en faites pas, nous on vous aime quand même !</h5>
          <ul class="order-payment-list list mb30">
            <li>
              <div class="row">
                <div class="col-xs-9">
                  <h5><i class="fa fa-car"></i> Départ de ${booking.step.place.city}</h5>
                  <p><small>le <joda:format value="${booking.step.estimatedTime}" pattern="dd/MM/yy" /> à <joda:format value="${booking.step.estimatedTime}" pattern="HH:mm" /></small>
                  </p>
                </div>
                <div class="col-xs-3">
                  <p class="text-right"><span class="text-lg">$150</span>
                  </p>
                </div>
              </div>
            </li>
            <li>
              <div class="row">
                <div class="col-xs-9">
                  <h5><i class="fa fa-car"></i> Arrivée à ${booking.trip.arrivalStep.place.city}</h5>
                  <p><small>le <joda:format value="${booking.trip.arrivalStep.estimatedTime}" pattern="dd/MM/yy" /> à <joda:format value="${booking.trip.arrivalStep.estimatedTime}" pattern="HH:mm" /></small>
                  </p>
                </div>
                <div class="col-xs-3">
                  <p class="text-right"><span class="text-lg">$187</span>
                  </p>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>