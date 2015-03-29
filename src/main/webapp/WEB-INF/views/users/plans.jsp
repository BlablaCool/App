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
        </div>
      </div>
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>