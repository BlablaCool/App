<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="fr_FR" />

<tiles:insertDefinition name="blablacoolTemplate">
  <tiles:putAttribute name="body">
    <div class="container">
      <h1 class="page-title">Abonnements</h1>
    </div>
    <div class="container">
      <div class="row">
        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
        <div class="col-md-9">

          <c:choose>
            <c:when test="${user.hasActiveSubscription() eq true}">
              <p class="lead text-success"><strong>Vous disposez d'un abonnement en cours de validité !</strong><br>Vous pouvez donc accéder à toutes les fonctionnalités offertes par BlablaCool.</p>
            </c:when>
            <c:otherwise>
              <p class="lead text-danger"><strong>Votre abonnement est arrivé à échéance !</strong><br>Certaines fonctionnalités de BlablaCool sont donc restreintes...</p>
            </c:otherwise>
          </c:choose>

          <h4>Historique</h4>
          <table class="table table-bordered table-striped table-booking-history">
            <thead>
              <tr>
                <th>Code</th>
                <th>Date de début</th>
                <th>Date de fin</th>
                <th>Montant</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${user.subscriptions}" var="sub">
                <tr>
                  <td><strong>${sub.name}</strong></td>
                  <td><joda:format value="${sub.from}" pattern="dd/MM/yyyy" /></td>
                  <td><joda:format value="${sub.to}" pattern="dd/MM/yyyy" /></td>
                  <td><fmt:formatNumber value="${sub.amount}" type="currency"/></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>

          <h4 class="mt40">Ajouter un abonnement</h4>
          <div class="row">
            <div class="col-md-3">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title">CHOCOLAT</h3>
                </div>
                <div class="panel-body">
                  <p class="lead text-center mb0">
                    1 semaine<br>
                    <small>2,00 &euro;</small>
                  </p>
                </div>
                <div class="panel-footer">
                  <form action="/payments/charge-plan/chocolat" method="POST" style="text-align: center;">
                    <script
                            src="https://checkout.stripe.com/checkout.js"
                            class="stripe-button"
                            data-key="${stripePublicKey}"
                            data-email="${user.email}"
                            data-allow-remember-me="false"
                            data-label="Payer"
                            data-panel-label="Payer"
                            data-currency="EUR"
                            data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                            data-name="BlablaCool"
                            data-description="Abonnement Chocolat"
                            data-amount="200"
                            defer>
                    </script>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title" style="background: rgb(141, 94, 0); color: white;">BRONZE</h3>
                </div>
                <div class="panel-body">
                  <p class="lead text-center mb0">1 mois<br>
                    <small>5,90 &euro;</small></p>
                </div>
                <div class="panel-footer">
                  <form action="/payments/charge-plan/bronze" method="POST" style="text-align: center;">
                    <script
                            src="https://checkout.stripe.com/checkout.js"
                            class="stripe-button"
                            data-key="${stripePublicKey}"
                            data-email="${user.email}"
                            data-allow-remember-me="false"
                            data-label="Payer"
                            data-panel-label="Payer"
                            data-currency="EUR"
                            data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                            data-name="BlablaCool"
                            data-description="Abonnement Bronze"
                            data-amount="590"
                            defer>
                    </script>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title" style="background: rgb(135, 135, 135); color: white;">SILVER</h3>
                </div>
                <div class="panel-body">
                  <p class="lead text-center mb0">6 mois<br>
                    <small>29,90 &euro;</small></p>
                </div>
                <div class="panel-footer">
                  <form action="/payments/charge-plan/silver" method="POST" style="text-align: center;">
                    <script
                            src="https://checkout.stripe.com/checkout.js"
                            class="stripe-button"
                            data-key="${stripePublicKey}"
                            data-email="${user.email}"
                            data-allow-remember-me="false"
                            data-label="Payer"
                            data-panel-label="Payer"
                            data-currency="EUR"
                            data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                            data-name="BlablaCool"
                            data-description="Abonnement Silver"
                            data-amount="2990"
                            defer>
                    </script>
                  </form>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title" style="background: rgb(255, 221, 19);">GOLD</h3>
                </div>
                <div class="panel-body">
                  <p class="lead text-center mb0">1 an<br>
                    <small>59,90 &euro;</small></p>
                </div>
                <div class="panel-footer">
                  <form action="/payments/charge-plan/gold" method="POST" style="text-align: center;">
                    <script
                            src="https://checkout.stripe.com/checkout.js"
                            class="stripe-button"
                            data-key="${stripePublicKey}"
                            data-email="${user.email}"
                            data-allow-remember-me="false"
                            data-label="Payer"
                            data-panel-label="Payer"
                            data-currency="EUR"
                            data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
                            data-name="BlablaCool"
                            data-description="Abonnement Gold"
                            data-amount="5990"
                            defer>
                    </script>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>