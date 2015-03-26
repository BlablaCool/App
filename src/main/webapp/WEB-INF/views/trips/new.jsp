<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
        <script src="/assets/js/jquery.geocomplete.min.js"></script>
        <script src="/assets/js/maplace.min.js"></script>
        <script src="/assets/js/trips.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Créer un itinéraire</h1>
        </div>

        <div class="container">

            <div class="row" style="">
                <div class="col-md-12">
                    <h3 style="margin-bottom: 20px;">1. Paramètres</h3>
                    <div class="panel panel-default">
                        <div class="panel-body" style="padding-top: 14px;">

                            <form class="form-horizontal">

                                <div class="row">
                                    <div class="col-md-4">
                                        <h5>Voiture</h5>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="car">Voiture</label>
                                            <div class="col-md-9">
                                                <select id="car" name="car" class="form-control">
                                                    <c:forEach items="${driver.cars}" var="car">
                                                        <option value="${car.id}" data-capacity="${car.capacity}">${car.brand}&nbsp;${car.model} (${car.registration})</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" for="availableSeats">Capacité</label>
                                            <div class="col-md-4">
                                                <input id="availableSeats" name="availableSeats" type="number" placeholder="" class="form-control input-md" required="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5>Options</h5>
                                        <div class="form-group">
                                            <div class="checkbox checkbox-switch" style="margin-left: 42px;">
                                                <label>
                                                    <input class="i-check" type="checkbox" /> Accepte les fumeurs
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="checkbox checkbox-switch" style="margin-left: 42px;">
                                                <label>
                                                    <input class="i-check" type="checkbox" /> Accepte les animaux
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="price">Prix</label>
                                            <div class="col-md-6">
                                                <div class="input-group input-group-lg">
                                                    <input id="price" name="price" class="form-control" placeholder="" type="text">
                                                    <span class="input-group-addon">euros</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>

            <hr>

            <div class="row">
                <div class="col-md-6">
                    <h3 style="margin-bottom: 20px;">2. Etapes du parcours</h3>
                    <div class="row">
                        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
                            <jsp:param name="pointNameLong" value="de Départ" />
                            <jsp:param name="pointName" value="departure" />
                            <jsp:param name="flag" value="fa-flag" />
                            <jsp:param name="canAddAfter" value="yes" />
                        </jsp:include>
                        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
                            <jsp:param name="pointNameLong" value="d'Arrivée" />
                            <jsp:param name="pointName" value="arrival" />
                            <jsp:param name="flag" value="fa-flag-checkered" />
                        </jsp:include>
                    </div>
                </div>
                <div class="col-md-6" style="margin-bottom: 32px;">
                    <div id="globalMap" style="height: 520px;"></div>
                </div>
            </div>
            <div class="row">
                <button type="button" id="createTrip">Créer</button>
            </div>
        </div>

        <div class="gap"></div>

        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
            <jsp:param name="pointNameLong" value="intermédiaire" />
            <jsp:param name="pointName" value="placeholder" />
            <jsp:param name="flag" value="fa-flag-o" />
            <jsp:param name="canAddAfter" value="yes" />
            <jsp:param name="isModel" value="yes" />
        </jsp:include>

    </tiles:putAttribute>
</tiles:insertDefinition>