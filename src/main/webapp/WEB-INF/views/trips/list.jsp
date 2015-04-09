<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script>
      <c:if test="${filterMinPrice != null}">
        var filterMinPrice = ${filterMinPrice};
      </c:if>
      <c:if test="${filterMaxPrice != null}">
        var filterMaxPrice = ${filterMaxPrice};
      </c:if>
    </script>
    <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
    <script src="/assets/js/jquery.geocomplete.min.js"></script>
    <script src="/assets/js/trips.list.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="container" style="margin-top: 42px;">
      <form id="infosForm" class="booking-item-dates-change mb40">
        <div class="row">
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group form-group-icon-left" style="margin-bottom: 2px;">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Départ</label>
                  <input class="form-control" type="text" name="departureAddress" id="departureAddress" />
                  <p class="help-block" style="font-weight: bold; font-size: 16px; margin-bottom: 0; margin-left: 10px;">
                    <input type="checkbox" name="enableGeolocation" id="enableGeolocation">
                    <label for="enableGeolocation" style="display: inline; font-weight: bold; cursor: pointer;"> &nbsp;Trouver un point autour de moi &nbsp;
                      <i class="fa fa-map-marker geolocationDone"></i>
                      <i class="fa fa-exclamation-triangle geolocationError"></i>
                      <i class="fa fa-refresh fa-spin geolocationWaiting"></i>
                    </label>
                  </p>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group form-group-icon-left">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Arrivée</label>
                  <input class="form-control" type="text" name="arrivalAddress" id="arrivalAddress" />
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-2">
            <div class="form-group form-group-icon-left">
              <i class="fa fa-calendar input-icon input-icon-hightlight"></i>
              <label>Date</label>
              <input class="form-control date-pick" name="departureTime" type="text"/>
            </div>
          </div>
          <div class="col-md-2 text-center" style="margin-top: 26px;">
            <button id="goSearch" class="btn btn-success" type="button"><i class="fa fa-search"></i> Rechercher</button>
          </div>
        </div>
      </form>
      
      <form id="departureForm" style="display: none;">
        <input type="hidden" name="name"><input type="hidden" name="lat"><input type="hidden" name="lng"><input type="hidden" name="location"><input type="hidden" name="formatted_address"><input type="hidden" name="street_number"><input type="hidden" name="postal_code"><input type="hidden" name="locality"><input type="hidden" name="country"><input type="hidden" name="country_short"><input type="hidden" name="administrative_area_level_1"><input type="hidden" name="place_id">
      </form>
      <form id="arrivalForm" style="display: none;">
        <input type="hidden" name="name"><input type="hidden" name="lat"><input type="hidden" name="lng"><input type="hidden" name="location"><input type="hidden" name="formatted_address"><input type="hidden" name="street_number"><input type="hidden" name="postal_code"><input type="hidden" name="locality"><input type="hidden" name="country"><input type="hidden" name="country_short"><input type="hidden" name="administrative_area_level_1"><input type="hidden" name="place_id">
      </form>
      <form id="geolocationForm" style="display: none;">
        <input type="hidden" name="latitude"><input type="hidden" name="longitude">
      </form>
      
      <div class="row">
        <div class="col-md-3">
          <aside class="booking-filters text-white">
            <h3>Filtrer :</h3>

            <form id="filterForm">
              <input type="hidden" name="filters" value="1">
              <ul class="list booking-filters-list">
                <li>
                  <h5 class="booking-filters-title">Prix</h5>
                  <input type="text" id="price-filter" name="price">
                </li>
                <%--<li>--%>
                  <%--<h5 class="booking-filters-title">Star Rating</h5>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>5 star (220)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>4 star (112)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>3 star (75)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>2 star (60)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>1 star (20)</label>--%>
                  <%--</div>--%>
                <%--</li>--%>
                <%--<li>--%>
                  <%--<h5 class="booking-filters-title">Bedrooms</h5>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>1 Bedroom (100)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>2 Bedrooms (112)</label>--%>
                  <%--</div>--%>
                  <%--<div class="checkbox">--%>
                    <%--<label>--%>
                      <%--<input class="i-check" type="checkbox"/>2+ Bedrooms (75)</label>--%>
                  <%--</div>--%>
                <%--</li>--%>
              </ul>
            </form>


          </aside>
        </div>
        <div class="col-md-9">

          <c:if test="${trips.size() == 0}">
            <p class="lead text-center" style="margin-top: 72px;">Aucun résultat trouvé :(</p>
          </c:if>
          <c:if test="${trips.size() > 0}">
            <ul class="booking-list">
              <c:forEach items="${trips}" var="trip">
                <li class="trip-element" data-url="/trips/${trip.idTrip}">
                  <div class="booking-item">
                    <div class="row">
                      <div class="col-md-2">
                        <div class="booking-item-img-wrap">
                          <img src="${trip.driver.gravatarUrl}" class="img-rounded" style="max-width: 100%; max-height: 120px;"/>
                        </div>
                      </div>
                      <div class="col-md-7">
                        <div class="booking-item-rating">
                          <a class="trip-driver-link" href="/users/${trip.driver.id}">${trip.driver.nickname}</a>
                          <ul class="icon-group booking-item-rating-stars" style="float: right; margin-left: 10px;">
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                            <li><i class="fa fa-star"></i></li>
                          </ul>
                        </div>
                        <h5 class="booking-item-title">
                            ${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i> ${trip.arrivalStep.place.city}
                        </h5>
                        <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                          <li rel="tooltip" data-placement="bottom" title="Places disponibles">
                            <i class="fa fa-male"></i><span class="booking-item-feature-sign">${trip.leftSeats}/${trip.capacity}</span>
                          </li>
                          <li rel="tooltip" data-placement="bottom" title="Bagages autorisés">
                            <i class="fa fa-suitcase"></i>
                            <span class="booking-item-feature-sign">2</span>
                          </li>
                          <li rel="tooltip" data-placement="bottom" title="Animaux autorisés">
                            <i class="fa fa-paw isActivated-${trip.allowAnimals}"></i>
                            <c:choose>
                              <c:when test="${trip.allowAnimals eq true}">
                                <span class="booking-item-feature-sign isActivated-${trip.allowAnimals}">OUI</span>
                              </c:when>
                              <c:otherwise>
                                <span class="booking-item-feature-sign isActivated-${trip.allowAnimals}">NON</span>
                              </c:otherwise>
                            </c:choose>
                          </li>
                          <li rel="tooltip" data-placement="bottom" title="Fumeurs autorisés">
                            <i class="fa fa-cloud isActivated-${trip.allowSmoking}"></i>
                            <c:choose>
                              <c:when test="${trip.allowSmoking eq true}">
                                <span class="booking-item-feature-sign isActivated-${trip.allowSmoking}">OUI</span>
                              </c:when>
                              <c:otherwise>
                                <span class="booking-item-feature-sign isActivated-${trip.allowSmoking}">NON</span>
                              </c:otherwise>
                            </c:choose>
                          </li>
                        </ul>
                      </div>
                      <div class="col-md-3 text-center">
                        <span class="booking-item-price"><fmt:formatNumber value="${trip.price}" type="currency"/></span>
                        <p style="margin-top: 5px; margin-bottom: 0;">
                          <button class="btn btn-success btn-lg"><i class="fa fa-check"></i> Réserver</button>
                        </p>
                      </div>
                    </div>
                  </div>
                </li>
              </c:forEach>
            </ul>
          </c:if>


        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>