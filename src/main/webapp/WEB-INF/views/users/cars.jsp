<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>
<%--@elvariable id="car" type="info.fges.blablacool.models.Car"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script src="/assets/js/users.pending-booking.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="container">
      <h1 class="page-title">Mes voitures</h1>
    </div>
    <div class="container">
      <div class="row">
        <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
        <div class="col-md-9">
          <c:choose>
            <c:when test="${user.cars.size() > 0}">
              <table class="table">
                <thead>
                <tr>
                  <th>Immatriculation</th>
                  <th>Marque</th>
                  <th>Modèle</th>
                  <th>Place disponibles</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${user.cars}" var="car">
                  <tr>
                    <td><strong>${car.registration}</strong></td>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.capacity}</td>
                  </tr>
                </c:forEach>
                </tbody>
              </table>
              <p class="lead text-center" style="margin-top: 42px;">
                <a href="/cars/new" class="btn btn-lg btn-success">Enregistrer une nouvelle voiture</a>
              </p>
            </c:when>
            <c:otherwise>
              <p class="lead text-center" style="margin-top: 42px;">
                Aucune voiture<br /><br />
                <a href="/cars/new" class="btn btn-lg btn-success">Enregistrer une nouvelle voiture</a>
              </p>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
    <div class="gap"></div>
  </tiles:putAttribute>
</tiles:insertDefinition>