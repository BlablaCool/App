<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplate">
    <tiles:putAttribute name="body">

        <!-- TOP AREA -->
        <div class="top-area show-onload">
            <div class="bg-holder full">
                <div class="bg-front full-height bg-front-mob-rel">
                    <div class="container full-height">
                        <div class="rel full-height">
                            <div class="tagline visible-lg" id="tagline"><span>It's time to</span>
                                <ul>
                                    <li>relax</li>
                                    <li>play</li>
                                    <li class="active">discover</li>
                                    <li>find new friends</li>
                                    <li>have fun</li>
                                    <li>explore</li>
                                    <li>go</li>
                                    <li>live</li>
                                    <li>meet</li>
                                    <li>run away</li>
                                    <li>being lost</li>
                                </ul>
                            </div>
                            <div class="search-tabs search-tabs-bg search-tabs-bottom mb50">
                                <div class="tabbable">
                                    <ul class="nav nav-tabs" id="myTab">
                                        <li class="active"><a href="index-7.html#tab-1" data-toggle="tab"><i class="fa fa-building-o"></i> <span >Hotels</span></a>
                                        </li>
                                        <li><a href="index-7.html#tab-2" data-toggle="tab"><i class="fa fa-plane"></i> <span >Flights</span></a>
                                        </li>
                                        <li><a href="index-7.html#tab-3" data-toggle="tab"><i class="fa fa-home"></i> <span >Rentals</span></a>
                                        </li>
                                        <li><a href="index-7.html#tab-4" data-toggle="tab"><i class="fa fa-car"></i> <span >Cars</span></a>
                                        </li>
                                        <li><a href="index-7.html#tab-5" data-toggle="tab"><i class="fa fa-bolt"></i> <span >Activities</span></a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade in active" id="tab-1">
                                            <h2>Search and Save on Hotels</h2>
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                            <label>Where are you going?</label>
                                                            <input class="typeahead form-control" placeholder="City, Airport, Point of Interest or U.S. Zip Code" type="text" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="input-daterange" data-date-format="M d, D">
                                                            <div class="row">
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-in</label>
                                                                        <input class="form-control" name="start" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-out</label>
                                                                        <input class="form-control" name="end" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Rooms</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
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
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Guests</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
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
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Hotels</button>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade" id="tab-2">
                                            <h2>Search for Cheap Flights</h2>
                                            <form>
                                                <div class="tabbable">
                                                    <ul class="nav nav-pills nav-sm nav-no-br mb10" id="flightChooseTab">
                                                        <li class="active"><a href="index-7.html#flight-search-1" data-toggle="tab">Round Trip</a>
                                                        </li>
                                                        <li><a href="index-7.html#flight-search-2" data-toggle="tab">One Way</a>
                                                        </li>
                                                    </ul>
                                                    <div class="tab-content">
                                                        <div class="tab-pane fade in active" id="flight-search-1">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="form-control" name="start" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Returning</label>
                                                                                    <input class="form-control" name="end" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
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
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane fade" id="flight-search-2">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                                <label>From</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                                <label>To</label>
                                                                                <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="input-daterange" data-date-format="M d, D">
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                                    <label>Departing</label>
                                                                                    <input class="date-pick form-control" data-date-format="M d, D" type="text" />
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="form-group form-group-lg form-group-select-plus">
                                                                                    <label>Passngers</label>
                                                                                    <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                                        <label class="btn btn-primary active">
                                                                                            <input type="radio" name="options" />1</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />2</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3</label>
                                                                                        <label class="btn btn-primary">
                                                                                            <input type="radio" name="options" />3+</label>
                                                                                    </div>
                                                                                    <select class="form-control hidden">
                                                                                        <option>1</option>
                                                                                        <option>2</option>
                                                                                        <option>3</option>
                                                                                        <option selected="selected">4</option>
                                                                                        <option>5</option>
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
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Flights</button>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade" id="tab-3">
                                            <h2>Find Your Perfect Home</h2>
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                            <label>Where are you going?</label>
                                                            <input class="typeahead form-control" placeholder="City, Airport, Point of Interest or U.S. Zip Code" type="text" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="input-daterange" data-date-format="M d, D">
                                                            <div class="row">
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-in</label>
                                                                        <input class="form-control" name="start" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Check-out</label>
                                                                        <input class="form-control" name="end" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Rooms</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
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
                                                                <div class="col-md-3">
                                                                    <div class="form-group form-group-lg form-group-select-plus">
                                                                        <label>Guests</label>
                                                                        <div class="btn-group btn-group-select-num" data-toggle="buttons">
                                                                            <label class="btn btn-primary active">
                                                                                <input type="radio" name="options" />1</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />2</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3</label>
                                                                            <label class="btn btn-primary">
                                                                                <input type="radio" name="options" />3+</label>
                                                                        </div>
                                                                        <select class="form-control hidden">
                                                                            <option>1</option>
                                                                            <option>2</option>
                                                                            <option>3</option>
                                                                            <option selected="selected">4</option>
                                                                            <option>5</option>
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
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Vacation Rentals</button>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade" id="tab-4">
                                            <h2>Search for Cheap Rental Cars</h2>
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                    <label>Pick-up Location</label>
                                                                    <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                                    <label>Drop-off Location</label>
                                                                    <input class="typeahead form-control" placeholder="City, Airport, U.S. Zip" type="text" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="input-daterange" data-date-format="M d, D">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Pick-up Date</label>
                                                                        <input class="form-control" name="start" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>Drop-ff Date</label>
                                                                        <input class="form-control" name="end" type="text" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Rental Cars</button>
                                            </form>
                                        </div>
                                        <div class="tab-pane fade" id="tab-5">
                                            <h2>Search for Activities</h2>
                                            <form>
                                                <div class="row">
                                                    <div class="col-md-8">
                                                        <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-map-marker input-icon"></i>
                                                            <label>Where are you going?</label>
                                                            <input class="typeahead form-control" placeholder="City, Airport, Point of Interest or U.S. Zip Code" type="text" />
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="input-daterange" data-date-format="M d, D">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>From</label>
                                                                        <input class="form-control" name="start" type="text" />
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="form-group form-group-lg form-group-icon-left"><i class="fa fa-calendar input-icon input-icon-highlight"></i>
                                                                        <label>To</label>
                                                                        <input class="form-control" name="end" type="text" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button class="btn btn-primary btn-lg" type="submit">Search for Activities</button>
                                            </form>
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