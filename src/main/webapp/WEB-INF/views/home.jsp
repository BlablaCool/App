<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
        <script src="/assets/js/jquery.geocomplete.min.js"></script>
        <script src="/assets/js/page.home.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <!-- TOP AREA -->
        <div class="top-area show-onload">
            <div class="bg-holder full">
                <div class="bg-front full-height bg-front-mob-rel">
                    <div class="container full-height">
                        <div class="rel full-height">
                            <div class="tagline visible-lg" id="tagline"><span>Il est temps de</span>
                                <ul>
                                    <li>se détendre</li>
                                    <li>s'amuser</li>
                                    <li class="active">découvrir</li>
                                    <li>se faire des amis</li>
                                    <li>partir</li>
                                    <li>vivre</li>
                                    <li>s'enfuir</li>
                                </ul>
                            </div>
                            <div class="search-tabs search-tabs-bg search-tabs-bottom mb50">
                                <div class="tabbable">
                                    <ul class="nav nav-tabs" id="myTab">
                                        <li class="active"><a href="index-7.html#tab-4" data-toggle="tab" style="padding-top: 10px;"><i class="fa fa-car"></i> <span>Rechercher un covoiturage</span></a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade in active" id="tab-4">
                                        <h2>N'attendez plus, covoiturez dès aujourd'hui !</h2>
                                            <div class="row">
                                                <form id="infosForm">
                                                    <div class="col-md-9">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                    <label>Point de départ</label>
                                                                    <input class="form-control" type="text" id="departureAddress" name="departureAddress" />
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
                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                    <label>Point d'arrivée</label>
                                                                    <input class="form-control" type="text" id="arrivalAddress" name="arrivalAddress" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="input-daterange">
                                                            <div class="form-group form-group-lg form-group-icon-left">
                                                                <i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                <label>Date de départ</label>
                                                                <input class="form-control date-pick" name="departureTime" type="text" />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <form id="departureForm" style="display: none;">
                                                <input type="hidden" name="name"><input type="hidden" name="lat"><input type="hidden" name="lng"><input type="hidden" name="location"><input type="hidden" name="formatted_address"><input type="hidden" name="street_number"><input type="hidden" name="postal_code"><input type="hidden" name="locality"><input type="hidden" name="country"><input type="hidden" name="country_short"><input type="hidden" name="administrative_area_level_1"><input type="hidden" name="place_id">
                                            </form>
                                            <form id="arrivalForm" style="display: none;">
                                                <input type="hidden" name="name"><input type="hidden" name="lat"><input type="hidden" name="lng"><input type="hidden" name="location"><input type="hidden" name="formatted_address"><input type="hidden" name="street_number"><input type="hidden" name="postal_code"><input type="hidden" name="locality"><input type="hidden" name="country"><input type="hidden" name="country_short"><input type="hidden" name="administrative_area_level_1"><input type="hidden" name="place_id">
                                            </form>
                                            <form id="geolocationForm" style="display: none;">
                                                <input type="hidden" name="latitude"><input type="hidden" name="longitude">
                                            </form>

                                            <button id="goSearch" class="btn btn-primary btn-lg" type="button">En avant toute !</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="owl-carousel owl-slider owl-carousel-area visible-lg" id="owl-carousel-slider" data-nav="false">
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url('/assets/img/196_365_2048x1365.jpg');"></div>
                    </div>
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url('/assets/img/el_inevitable_paso_del_tiempo_2048x2048.jpg');"></div>
                    </div>
                    <div class="bg-holder full">
                        <div class="bg-mask"></div>
                        <div class="bg-img" style="background-image:url('/assets/img/viva_las_vegas_2048x1365.jpg');"></div>
                    </div>
                </div>
                <div class="bg-img hidden-lg" style="background-image:url('/assets/img/196_365_2048x1365.jpg');"></div>
                <div class="bg-mask hidden-lg"></div>
            </div>
        </div>
        <!-- END TOP AREA  -->

        <div class="gap"></div>

        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="row row-wrap" data-gutter="120">
                        <div class="col-md-4">
                            <div class="thumb">
                                <header class="thumb-header"><i class="fa fa-briefcase box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title"><a class="text-darken" href="index-7.html#">Combine & Save</a></h5>
                                    <p class="thumb-desc">Faucibus tristique felis potenti ultrices ornare rhoncus semper hac facilisi</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumb">
                                <header class="thumb-header"><i class="fa fa-dollar box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title"><a class="text-darken" href="index-7.html#">Best Price Guarantee</a></h5>
                                    <p class="thumb-desc">Rutrum tellus lorem sem velit nisi non pharetra in dui</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumb">
                                <header class="thumb-header"><i class="fa fa-lock box-icon-black round box-icon-big animate-icon-top-to-bottom"></i>
                                </header>
                                <div class="thumb-caption">
                                    <h5 class="thumb-title"><a class="text-darken" href="index-7.html#">Trust & Safety</a></h5>
                                    <p class="thumb-desc">Nostra sodales pharetra lacus sit sapien tristique luctus class magnis</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="gap gap-small"></div>
        </div>
        <div class="bg-holder">
            <div class="bg-mask"></div>
            <div class="bg-img" style="background-image:url('/assets/img/hotel_porto_bay_liberdade_2048x1293.jpg');"></div>
            <div class="bg-content">
                <div class="container">
                    <div class="gap gap-big text-center text-white">
                        <h2 class="text-uc mb20">Last Minute Deal</h2>
                        <ul class="icon-list list-inline-block mb0 last-minute-rating">
                            <li><i class="fa fa-star"></i>
                            </li>
                            <li><i class="fa fa-star"></i>
                            </li>
                            <li><i class="fa fa-star"></i>
                            </li>
                            <li><i class="fa fa-star"></i>
                            </li>
                            <li><i class="fa fa-star"></i>
                            </li>
                        </ul>
                        <h5 class="last-minute-title">The Peninsula - New York</h5>
                        <p class="last-minute-date">Fri 14 Mar - Sun 16 Mar</p>
                        <p class="mb20"><b>$120</b> / person</p><a class="btn btn-lg btn-white btn-ghost" href="index-7.html#">Book Now <i class="fa fa-angle-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="gap"></div>
            <h2 class="text-center">Top Destinations</h2>
            <div class="gap">
                <div class="row row-wrap">
                    <div class="col-md-3">
                        <div class="thumb">
                            <header class="thumb-header">
                                <a class="hover-img curved" href="index-7.html#">
                                    <img src="/assets/img/people_on_the_beach_800x600.jpg" alt="Image Alternative text" title="people on the beach" />
                                </a>
                            </header>
                            <div class="img-left">
                                <img src="/assets/img/flags/32/gr.png" alt="Image Alternative text" title="Image Title" />
                            </div>
                            <div class="thumb-caption">
                                <h4 class="thumb-title"><a class="text-darken" href="index-7.html#">Crete</a></h4>
                                <div class="thumb-caption">
                                    <p class="thumb-desc">Interdum arcu lacus parturient mattis phasellus</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumb">
                            <header class="thumb-header">
                                <a class="hover-img curved" href="index-7.html#">
                                    <img src="/assets/img/196_365_800x600.jpg" alt="Image Alternative text" title="196_365" />
                                </a>
                            </header>
                            <div class="img-left">
                                <img src="/assets/img/flags/32/fr.png" alt="Image Alternative text" title="Image Title" />
                            </div>
                            <div class="thumb-caption">
                                <h4 class="thumb-title"><a class="text-darken" href="index-7.html#">Paris</a></h4>
                                <div class="thumb-caption">
                                    <p class="thumb-desc">Est cubilia est nulla sed aptent</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumb">
                            <header class="thumb-header">
                                <a class="hover-img curved" href="index-7.html#">
                                    <img src="/assets/img/el_inevitable_paso_del_tiempo_800x600.jpg" alt="Image Alternative text" title="El inevitable paso del tiempo" />
                                </a>
                            </header>
                            <div class="img-left">
                                <img src="/assets/img/flags/32/hu.png" alt="Image Alternative text" title="Image Title" />
                            </div>
                            <div class="thumb-caption">
                                <h4 class="thumb-title"><a class="text-darken" href="index-7.html#">Budapest</a></h4>
                                <div class="thumb-caption">
                                    <p class="thumb-desc">Ornare lobortis rhoncus pulvinar consectetur feugiat</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="thumb">
                            <header class="thumb-header">
                                <a class="hover-img curved" href="index-7.html#">
                                    <img src="/assets/img/upper_lake_in_new_york_central_park_800x600.jpg" alt="Image Alternative text" title="Upper Lake in New York Central Park" />
                                </a>
                            </header>
                            <div class="img-left">
                                <img src="/assets/img/flags/32/us.png" alt="Image Alternative text" title="Image Title" />
                            </div>
                            <div class="thumb-caption">
                                <h4 class="thumb-title"><a class="text-darken" href="index-7.html#">New York</a></h4>
                                <div class="thumb-caption">
                                    <p class="thumb-desc">Hendrerit aliquet ornare rutrum fermentum facilisis</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>