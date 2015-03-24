<%--
  Created by IntelliJ IDEA.
  User: Hugo
  Date: 24/03/2015
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/template/blablacool/header.jsp" />
<jsp:include page="/WEB-INF/template/blablacool/header-meta.jsp" />

<div class="container">
    <h1 class="page-title">Liste des trajets</h1>
</div>
<div class="container">
    <form>
        <div class="input-daterange" data-date-format="MM d, D">
            <div class="row">
                <div class="col-md-3">
                    <div class="form-group form-group-icon-left"><i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                        <label>Lieu de départ</label>
                        <input class="typeahead form-control" placeholder="Ville ou aéroport" type="text" />
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group form-group-icon-left"><i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                        <label>Lieu d'arrivée</label>
                        <input class="typeahead form-control"  placeholder="Ville ou aéroport" type="text" />
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="row">
                            <div class="form-group form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-hightlight"></i>
                                <label>Jour</label>
                                <input class="form-control" name="start" type="text" />
                            </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group form-group-icon-left"><i class="fa fa-clock-o input-icon input-icon-hightlight"></i>
                                <label>Heure de départ</label>
                                <input class="time-pick form-control" value="12:00 AM" type="text" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-group-icon-left"><i class="fa fa-clock-o input-icon input-icon-hightlight"></i>
                                <label>Heure d'arrivée</label>
                                <input class="time-pick form-control" value="12:00 AM" type="text" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input class="btn btn-primary mt10" type="submit" value="Chercher un trajet" />
    </form>
    <div class="gap"></div>
    <div class="row row-wrap">
        <c:forEach items="${lTrips}" var="trip">
            <div class="col-md-3">
                <div class="thumb">
                    <header class="thumb-header">
                        <a href="car-search-default=true.html#">
                            <img src="assets/img/Volvo-V40.png" alt="Image Alternative text" title="Image Title" />
                        </a>
                    </header>
                    <div class="thumb-caption">
                        <h5 class="thumb-title">
                            <a class="text-darken" href="car-search-default=true.html#">
                                ${trip.getTripHasPlaces().get(0).getPlace().getPublicName()} - ${trip.getTripHasPlaces().get(1).getPlace().getPublicName()}
                            </a>
                        </h5>
                        <small>${trip.getDriver().getNickname()}</small>
                        <ul class="booking-item-features booking-item-features-small booking-item-features-sign clearfix mt5">
                            <li rel="tooltip" data-placement="top" title="Passengers"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x ${trip.getCapacity()}</span>
                            </li>
                            <li rel="tooltip" data-placement="top" title="Doors"><i class="im im-car-doors"></i><span class="booking-item-feature-sign">x 5</span>
                            </li>
                            <li rel="tooltip" data-placement="top" title="Baggage Quantity"><i class="fa fa-briefcase"></i><span class="booking-item-feature-sign">x 1</span>
                            </li>
                            <li rel="tooltip" data-placement="top" title="Automatic Transmission"><i class="im im-shift-auto"></i><span class="booking-item-feature-sign">auto</span>
                            </li>
                            <li rel="tooltip" data-placement="top" title="Electric Vehicle"><i class="im im-electric"></i>
                            </li>
                        </ul>
                        <p class="text-darken mb0 text-color">$41<small> /day</small>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/template/blablacool/footer.jsp" />
<jsp:include page="/WEB-INF/template/blablacool/footer-js.jsp" />