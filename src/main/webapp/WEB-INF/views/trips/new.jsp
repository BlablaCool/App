<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
            <div class="row">
                <div class="col-md-5" style="margin-bottom: 32px;">
                    <h4>Paramètres</h4>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Basic panel example
                        </div>
                    </div>
                </div>

                <div class="col-md-7">
                    <div class="row">
                        <div class="col-md-12 step-wrapper">
                            <h5><i class="fa fa-flag"></i> &nbsp;Point de départ</h5>
                            <div class="form-group">
                                <input class="form-control" type="text" id="departureAddress" name="departureAddress" placeholder="Avenue des Champs-Elysées, Paris">
                            </div>

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
                            <i class="addMiddleStep fa fa-plus box-icon-to-normal box-icon-center box-icon-gray box-icon-to-success box-icon-border-dashed animate-icon-border-rise round" style="cursor: pointer;"></i>
                        </div>

                        <div class="col-md-12 step-wrapper" style="margin-top: -18px;">
                            <h5><i class="fa fa-flag-checkered"></i> Point d'arrivée</h5>
                            <div class="form-group">
                                <input class="form-control" type="text" id="arrivalAddress" name="arrivalAddress" placeholder="Avenue des Champs-Elysées, Paris">
                            </div>
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
                    </div>
                </div>
            </div>

            <div class="row">
                <button type="button" id="createTrip">Créer</button>
            </div>

        </div>

        <div class="container">
            <div id="globalMap" style="height: 520px;"></div>
            <div id="controls"></div>
        </div>

        <div class="gap"></div>

        <div id="step-wrapper-model" class="col-md-12 step-wrapper" style="margin-top: -18px;">
            <h5><i class="fa fa-flag-o"></i> &nbsp;Point intermédiaire</h5>
            <div class="input-group" style="margin-bottom: 15px;">
                <span class="input-group-btn">
                    <button class="btn btn-link" type="button"><i class="fa fa-times"></i></button>
                </span>
                <input type="text" class="form-control addressToFind">
            </div>
            <form class="placeContainer-model">
                <input type="hidden" name="type" value="middle">
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
            <i class="addMiddleStep fa fa-plus box-icon-to-normal box-icon-center box-icon-gray box-icon-to-success box-icon-border-dashed animate-icon-border-rise round" style="cursor: pointer;"></i>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>