<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

<tiles:insertDefinition name="blablacoolTemplate">
  <tiles:putAttribute name="body">
    <div class="container" style="margin-top: 42px;">
      <form class="booking-item-dates-change mb40">
        <div class="row">
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group form-group-icon-left">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Départ</label>
                  <input class="typeahead form-control" value="United States, New York" placeholder="City, Hotel Name or U.S. Zip Code" type="text"/>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group form-group-icon-left">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Arrivée</label>
                  <input class="typeahead form-control" value="United States, New York" placeholder="City, Hotel Name or U.S. Zip Code" type="text"/>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-2">
            <div class="form-group form-group-icon-left">
              <i class="fa fa-calendar input-icon input-icon-hightlight"></i>
              <label>Date</label>
              <input class="form-control" name="start" type="text"/>
            </div>
          </div>
          <div class="col-md-2">
            <div class="form-group form-group- form-group-select-plus">
              <label>Guests</label>
              <div class="btn-group btn-group-select-num" data-toggle="buttons">
                <label class="btn btn-primary active">
                  <input type="radio" name="options"/>1</label>
                <label class="btn btn-primary">
                  <input type="radio" name="options"/>2</label>
                <label class="btn btn-primary">
                  <input type="radio" name="options"/>3</label>
                <label class="btn btn-primary">
                  <input type="radio" name="options"/>4</label>
                <label class="btn btn-primary">
                  <input type="radio" name="options"/>4+</label>
              </div>
              <select class="form-control hidden">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option selected="selected">5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
                <option>13</option>
                <option>14</option>
              </select>
            </div>
          </div>
        </div>
      </form>
      <div class="row">
        <div class="col-md-3">
          <aside class="booking-filters text-white">
            <h3>Filter By:</h3>
            <ul class="list booking-filters-list">
              <li>
                <h5 class="booking-filters-title">Price</h5>
                <input type="text" id="price-slider">
              </li>
              <li>
                <h5 class="booking-filters-title">Star Rating</h5>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>5 star (220)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>4 star (112)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>3 star (75)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>2 star (60)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>1 star (20)</label>
                </div>
              </li>
              <li>
                <h5 class="booking-filters-title">Bedrooms</h5>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>1 Bedroom (100)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>2 Bedrooms (112)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>2+ Bedrooms (75)</label>
                </div>
              </li>
            </ul>
          </aside>
        </div>
        <div class="col-md-9">
          <div class="nav-drop booking-sort">
            <h5 class="booking-sort-title"><a href="rentals-search-results-3.html#">Sort: Price (low to high)<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i></a></h5>
            <ul class="nav-drop-menu">
              <li><a href="rentals-search-results-3.html#">Price (hight to low)</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Ranking</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Bedrooms (Most to Least)</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Bedrooms (Least to Most)</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Number of Reviews</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Number of Photos</a>
              </li>
              <li><a href="rentals-search-results-3.html#">Just Added</a>
              </li>
            </ul>
          </div>
          <ul class="booking-list">

            <c:forEach items="${recentTrips}" var="trip">
              <li>
                <div class="booking-item">
                  <div class="row">
                    <div class="col-md-2">
                      <div class="booking-item-img-wrap">
                        <img src="http://placehold.it/420x420" />
                        <%--<div class="booking-item-img-num">--%>
                          <%--<i class="fa fa-picture-o"></i>29--%>
                        <%--</div>--%>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="booking-item-rating">
                        <a href="/users/${trip.driver.id}">${trip.driver.nickname}</a>
                        <ul class="icon-group booking-item-rating-stars" style="float: right; margin-left: 10px;">
                          <li><i class="fa fa-star"></i></li>
                          <li><i class="fa fa-star"></i></li>
                          <li><i class="fa fa-star"></i></li>
                        </ul>
                      </div>
                      <h5 class="booking-item-title">
                        <i class="fa fa-angle-right fa-fw"></i> ${trip.departureStep.place.city}<br />
                        <i class="fa fa-angle-double-right fa-fw"></i> ${trip.arrivalStep.place.city}
                      </h5>
                      <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                        <li rel="tooltip" data-placement="bottom" title="Places disponibles">
                          <i class="fa fa-male"></i><span class="booking-item-feature-sign">${trip.capacity}</span>
                        </li>
                        <li rel="tooltip" data-placement="bottom" title="Bagages autorisés">
                          <i class="fa fa-suitcase"></i><span class="booking-item-feature-sign">2</span>
                        </li>
                        <li rel="tooltip" data-placement="bottom" title="Animaux autorisés">
                          <i class="fa fa-paw isActivated-${trip.allowSmoking}""></i><span class="booking-item-feature-sign isActivated-${trip.allowSmoking}">OUI</span>
                        </li>
                        <li rel="tooltip" data-placement="bottom" title="Fumeurs autorisés">
                          <i class="fa fa-cloud isActivated-${trip.allowSmoking}""></i><span class="booking-item-feature-sign isActivated-${trip.allowSmoking}">NON</span>
                        </li>
                      </ul>
                    </div>
                    <div class="col-md-4">
                      <span class="booking-item-price"><fmt:formatNumber value="${trip.price}" type="currency"/></span><span>/passager</span><span class="btn btn-primary">Réserver</span>
                    </div>
                  </div>
                </div>
              </li>
            </c:forEach>
          </ul>
          <div class="row">
            <div class="col-md-6">
              <p>
                <small>320 vacation rentals found in New York. &nbsp;&nbsp;Showing 1 – 15</small>
              </p>
              <ul class="pagination">
                <li class="active"><a href="rentals-search-results-3.html#">1</a>
                </li>
                <li><a href="rentals-search-results-3.html#">2</a>
                </li>
                <li><a href="rentals-search-results-3.html#">3</a>
                </li>
                <li><a href="rentals-search-results-3.html#">4</a>
                </li>
                <li><a href="rentals-search-results-3.html#">5</a>
                </li>
                <li><a href="rentals-search-results-3.html#">6</a>
                </li>
                <li><a href="rentals-search-results-3.html#">7</a>
                </li>
                <li class="dots">...</li>
                <li><a href="rentals-search-results-3.html#">43</a>
                </li>
                <li class="next"><a href="rentals-search-results-3.html#">Next Page</a>
                </li>
              </ul>
            </div>
            <div class="col-md-6 text-right">
              <p>
                Not what you're looking for? <a class="popup-text" href="rentals-search-results-3.html#search-dialog" data-effect="mfp-zoom-out">Try your search again</a>
              </p>
            </div>
          </div>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>