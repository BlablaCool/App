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

                <form method="POST" action="/trips/new">
                    <div class="col-xs-12 col-md-6">
                        <h4><i class="fa fa-flag"></i> Point de départ</h4>
                        <div class="form-group form-group-icon-left">
                            <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                            <label>Adresse, POI, ...</label>
                            <input class="form-control" type="text" id="departureAddress" name="departureAddress" placeholder="Avenue des Champs-Elysées, Paris">
                        </div>
                        <div id="departureAddressMap" style="height: 360px;"></div>
                        <div id="departureAddressHiddenForm">
                            <label>Name</label>
                            <spring:bind path="departureAddress.namePublic">
                                <input type="text" name="name">
                            </spring:bind>

                            <label>POI Name</label>
                            <input name="point_of_interest" type="text" value="">

                            <label>Latitude</label>
                            <input name="lat" type="text" value="">

                            <label>Longitude</label>
                            <input name="lng" type="text" value="">

                            <label>Location</label>
                            <input name="location" type="text" value="">

                            <label>Location Type</label>
                            <input name="location_type" type="text" value="">

                            <label>Formatted Address</label>
                            <input name="formatted_address" type="text" value="">

                            <label>Bounds</label>
                            <input name="bounds" type="text" value="">

                            <label>Viewport</label>
                            <input name="viewport" type="text" value="">

                            <label>Route</label>
                            <input name="route" type="text" value="">

                            <label>Street Number</label>
                            <input name="street_number" type="text" value="">

                            <label>Postal Code</label>
                            <input name="postal_code" type="text" value="">

                            <label>Locality</label>
                            <input name="locality" type="text" value="">

                            <label>Sub Locality</label>
                            <input name="sublocality" type="text" value="">

                            <label>Country</label>
                            <input name="country" type="text" value="">

                            <label>Country Code</label>
                            <input name="country_short" type="text" value="">

                            <label>State</label>
                            <input name="administrative_area_level_1" type="text" value="">

                            <label>Place ID</label>
                            <input name="place_id" type="text" value="">

                            <label>ID</label>
                            <input name="id" type="text" value="">

                            <label>Reference</label>
                            <input name="reference" type="text" value="">

                            <label>URL</label>
                            <input name="url" type="text" value="">

                            <label>Website</label>
                            <input name="website" type="text" value="">
                        </div>
                    </div>

                    <div class="col-xs-12 col-md-6">
                        <h4><i class="fa fa-flag-checkered"></i> Point d'arrivée</h4>
                        <div class="form-group form-group-icon-left">
                            <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                            <label>Adresse, POI, ...</label>
                            <input class="form-control" type="text" id="arrivalAddress" name="arrivalAddress" placeholder="Avenue des Champs-Elysées, Paris">
                        </div>
                        <div id="arrivalAddressMap" style="height: 360px;"></div>
                        <div id="arrivalAddressHiddenForm">
                            <label>Name</label>
                            <input name="name" type="text" value="">

                            <label>POI Name</label>
                            <input name="point_of_interest" type="text" value="">

                            <label>Latitude</label>
                            <input name="lat" type="text" value="">

                            <label>Longitude</label>
                            <input name="lng" type="text" value="">

                            <label>Location</label>
                            <input name="location" type="text" value="">

                            <label>Location Type</label>
                            <input name="location_type" type="text" value="">

                            <label>Formatted Address</label>
                            <input name="formatted_address" type="text" value="">

                            <label>Bounds</label>
                            <input name="bounds" type="text" value="">

                            <label>Viewport</label>
                            <input name="viewport" type="text" value="">

                            <label>Route</label>
                            <input name="route" type="text" value="">

                            <label>Street Number</label>
                            <input name="street_number" type="text" value="">

                            <label>Postal Code</label>
                            <input name="postal_code" type="text" value="">

                            <label>Locality</label>
                            <input name="locality" type="text" value="">

                            <label>Sub Locality</label>
                            <input name="sublocality" type="text" value="">

                            <label>Country</label>
                            <input name="country" type="text" value="">

                            <label>Country Code</label>
                            <input name="country_short" type="text" value="">

                            <label>State</label>
                            <input name="administrative_area_level_1" type="text" value="">

                            <label>Place ID</label>
                            <input name="place_id" type="text" value="">

                            <label>ID</label>
                            <input name="id" type="text" value="">

                            <label>Reference</label>
                            <input name="reference" type="text" value="">

                            <label>URL</label>
                            <input name="url" type="text" value="">

                            <label>Website</label>
                            <input name="website" type="text" value="">
                        </div>
                    </div>

                    <button type="submit">Créer</button>

                </form>

                
            </div>

        </div>

        <div class="gap"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>