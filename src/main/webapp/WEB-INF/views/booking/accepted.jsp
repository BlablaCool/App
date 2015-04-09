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
          <i class="fa fa-thumbs-up round box-icon-large box-icon-center box-icon-success mb30"></i>
          <h2 class="text-center">Bienvenue à bord ${user.firstname} !</h2>
          <h5 class="text-center mb30">Votre demande de réservation a été validée par <em>${booking.trip.driver.nickname}</em>, en avant toute !</h5>

          <p class="lead text-center mb10">
            Montant estimé : <fmt:formatNumber value="${booking.trip.price}" type="currency"/>
          </p>

          <form action="/payments/charge-booking/${booking.id}" method="POST" class="mb50" style="text-align: center;">
            <script
                    src="https://checkout.stripe.com/checkout.js"
                    class="stripe-button"
                    data-key="${stripePublicKey}"
                    data-email="${booking.user.email}"
                    data-allow-remember-me="false"
                    data-label="Payer mon trajet en avance"
                    data-panel-label="Payer"
                    data-currency="EUR"
                    data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                    data-name="BlablaCool"
                    data-description="Covoiturage ${booking.trip.departureStep.place.city} > ${booking.trip.arrivalStep.place.city}"
                    data-amount="${booking.trip.price.multiply(100)}"
                    defer>
            </script>
          </form>

          <ul class="order-payment-list list mb30">
            <li>
              <div class="row">
                <div class="col-xs-9">
                  <h5><i class="fa fa-car"></i> Départ de ${booking.step.place.city}</h5>
                  <p><small>le <joda:format value="${booking.step.estimatedTime}" pattern="dd/MM/yy" /> à <joda:format value="${booking.step.estimatedTime}" pattern="HH:mm" /></small>
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
              </div>
            </li>
          </ul>

          <ul class="list list-inline list-center">
            <li>
              <form name="cancelBooking" method="POST" action="/booking/${booking.id}/delete">
                <button type="submit" id="cancelBooking" class="btn btn-danger" name="cancelBooking" value="yes" data-booking="${booking.id}" ><i class="fa fa-times"></i> Annuler ma réservation</button>
              </form>
              <p class="text-center lh1em mt5"><small>possible jusqu'à deux heures<br>avant l'heure de départ</small></p>
            </li>
          </ul>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>