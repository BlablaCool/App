<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
        <script src="/assets/js/jquery.geocomplete.min.js"></script>
        <script src="/assets/js/trips.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Créer un itinéraire</h1>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12" style="margin-bottom: 32px;">
                    <h4>Paramètres</h4>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Basic panel example
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <h4><i class="fa fa-flag"></i> Point de départ</h4>
                    <div class="form-group form-group-icon-left">
                        <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                        <label>Adresse, POI, ...</label>
                        <input class="form-control" type="text" id="departureAddress" name="departureAddress" placeholder="Avenue des Champs-Elysées, Paris">
                    </div>
                    <div id="departureAddressMap" style="height: 360px;"></div>
                    <form id="departureAddressHiddenForm" class="placeContainer">
                        <input type="hidden" name="type" value="departure">
                        <input type="hidden" name="name">
                        <input type="hidden" name="lat">
                        <input type="hidden" name="lng">
                        <input type="hidden" name="location">
                        <input type="hidden" name="formatted_address">
                        <input type="hidden" name="street_number">
                        <input type="hidden" name="postal_code">
                        <input type="hidden" name="locality">
                        <input type="hidden" name="country">
                        <input type="hidden" name="country_short">
                        <input type="hidden" name="administrative_area_level_1">
                        <input type="hidden" name="place_id">
                    </form>
                </div>

                    <div class="col-xs-12 col-md-6">
                        <h4><i class="fa fa-flag-checkered"></i> Point d'arrivée</h4>
                        <div class="form-group form-group-icon-left">
                            <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                            <label>Adresse, POI, ...</label>
                            <input class="form-control" type="text" id="arrivalAddress" name="arrivalAddress" placeholder="Avenue des Champs-Elysées, Paris">
                        </div>
                        <div id="arrivalAddressMap" style="height: 360px;"></div>
                        <form id="arrivalAddressHiddenForm" class="placeContainer">
                            <input type="hidden" name="type" value="arrival">
                            <input type="hidden" name="name">
                            <input type="hidden" name="lat">
                            <input type="hidden" name="lng">
                            <input type="hidden" name="location">
                            <input type="hidden" name="formatted_address">
                            <input type="hidden" name="street_number">
                            <input type="hidden" name="postal_code">
                            <input type="hidden" name="locality">
                            <input type="hidden" name="country">
                            <input type="hidden" name="country_short">
                            <input type="hidden" name="administrative_area_level_1">
                            <input type="hidden" name="place_id">
                        </form>
                    </div>

                <button type="button" id="createTrip">Créer</button>

            </div>

        </div>

        <div class="gap"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>