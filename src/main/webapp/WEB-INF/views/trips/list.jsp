<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="blablacoolTemplate">
  <tiles:putAttribute name="body">
    <div class="container" style="margin-top: 42px;">
      <form class="booking-item-dates-change mb40">
        <div class="row">
          <div class="col-md-6">
            <div class="row">
              <div class="col-md-6">
                <div class="form-group form-group-icon-left">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Depuis</label>
                  <input class="typeahead form-control" value="United States, New York" placeholder="City, Hotel Name or U.S. Zip Code" type="text"/>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group form-group-icon-left">
                  <i class="fa fa-map-marker input-icon input-icon-hightlight"></i>
                  <label>Jusqu'à</label>
                  <input class="typeahead form-control" value="United States, New York" placeholder="City, Hotel Name or U.S. Zip Code" type="text"/>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="input-daterange" data-date-format="MM d, D">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group form-group-icon-left">
                    <i class="fa fa-calendar input-icon input-icon-hightlight"></i>
                    <label>Check in</label>
                    <input class="form-control" name="start" type="text"/>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group form-group-icon-left">
                    <i class="fa fa-calendar input-icon input-icon-hightlight"></i>
                    <label>Check out</label>
                    <input class="form-control" name="end" type="text"/>
                  </div>
                </div>
              </div>
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
              <li>
                <h5 class="booking-filters-title">Suitability</h5>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Wheelchair Access (65)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Elder Access (215)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Suitable for Children (295)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Pet Friendly (20)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Smoking Allowed (35)</label>
                </div>
              </li>
              <li>
                <h5 class="booking-filters-title">Amenities</h5>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Air Conditioning (300)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Wi-Fi (320)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Internet (257)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>High Definition TV (185)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Washer/Dryer (156)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Other Outdoor Space (86)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Grill (61)</label>
                </div>
                <div class="checkbox">
                  <label>
                    <input class="i-check" type="checkbox"/>Parking (33)</label>
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
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/lhotel_porto_bay_sao_paulo_suite_lhotel_living_room_800x600.jpg" alt="Image Alternative text" title="LHOTEL PORTO BAY SAO PAULO suite lhotel living room"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>29
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
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
                      <span class="booking-item-rating-number"><b>4.8</b> of 5</span><small>(400 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Cozy Apartment Manhattan East 20s</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Jamaica, NY (Kennedy Airport (JFK))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$481</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_1_800x600.jpg" alt="Image Alternative text" title="hotel 1"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>21
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-half-empty"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>4.4</b> of 5</span><small>(983 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Times Square 50th Gem</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Ozone Park, NY (Kennedy Airport (JFK))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 4</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$403</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_2_800x600.jpg" alt="Image Alternative text" title="hotel 2"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>26
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.6</b> of 5</span><small>(1177 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Duplex Greenwich</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Queens (LaGuardia Airport (LGA))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 5</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$447</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_serra_golf_living_room_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY SERRA GOLF living room"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>23
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.6</b> of 5</span><small>(1430 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">NYC One Badroom in Midtown East</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> New York, NY (Times Square)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 4</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$338</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/the_pool_800x600.jpg" alt="Image Alternative text" title="The pool"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>10
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.9</b> of 5</span><small>(1002 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">The Meatpacking Suites - Luxury Lofts, Hot Location</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> New York, NY (Times Square)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$419</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/lhotel_porto_bay_sao_paulo_lobby_800x600.jpg" alt="Image Alternative text" title="LHOTEL PORTO BAY SAO PAULO lobby"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>29
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.6</b> of 5</span><small>(849 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">East Village Apartment</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Long Island City, NY (Long Island City - Astoria)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$358</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_serra_golf_suite2_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY SERRA GOLF suite2"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>21
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.8</b> of 5</span><small>(1171 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Luxury Studio in Manhattan NYC</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Ozone Park, NY (Kennedy Airport (JFK))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 6</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$490</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/lhotel_porto_bay_sao_paulo_luxury_suite_800x600.jpg" alt="Image Alternative text" title="LHOTEL PORTO BAY SAO PAULO luxury suite"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>6
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
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
                      <span class="booking-item-rating-number"><b>4.7</b> of 5</span><small>(552 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">NyCityStay Greenwich Village</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Jamaica, NY (Kennedy Airport (JFK))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 6</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$309</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_liberdade_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY LIBERDADE"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>15
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
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
                      <span class="booking-item-rating-number"><b>4.8</b> of 5</span><small>(1249 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Midtown Manhattan Oversized</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> East Elmhurst, NY (LaGuardia Airport (LGA))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 4</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$197</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_the_cliff_bay_spa_suite_800x600.jpg" alt="Image Alternative text" title="hotel THE CLIFF BAY spa suite"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>16
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
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
                      <span class="booking-item-rating-number"><b>5</b> of 5</span><small>(857 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Elegance & Style Near the Empire State Building</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Brooklyn, NY (Brooklyn)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 4</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$340</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_serra_golf_suite_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY SERRA GOLF suite"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>26
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.6</b> of 5</span><small>(243 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Soho Art Gallery Massive Luxurious Loft</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> New York, NY (Times Square)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 4</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$369</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_rio_internacional_de_luxe_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY RIO INTERNACIONAL de luxe"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>12
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-half-empty"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>4.4</b> of 5</span><small>(1101 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Manhattan Beautiful Loft Excellent Loc</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> New York, NY (Downtown - Wall Street)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$411</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_serra_golf_library_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY SERRA GOLF library"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>11
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.6</b> of 5</span><small>(882 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">NYC Waterfront Artist Studio</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> East Elmhurst, NY (LaGuardia Airport (LGA))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$495</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_eden_mar_suite_800x600.jpg" alt="Image Alternative text" title="hotel EDEN MAR suite"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>16
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-half-empty"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>4.1</b> of 5</span><small>(1101 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Luxury Apartment Theatre District</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> New York, NY (Times Square)
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 3</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$391</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
            <li>
              <a class="booking-item" href="rentals-search-results-3.html#">
                <div class="row">
                  <div class="col-md-3">
                    <div class="booking-item-img-wrap">
                      <img src="/assets/img/hotel_porto_bay_rio_internacional_rooftop_pool_800x600.jpg" alt="Image Alternative text" title="hotel PORTO BAY RIO INTERNACIONAL rooftop pool"/>
                      <div class="booking-item-img-num">
                        <i class="fa fa-picture-o"></i>11
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="booking-item-rating">
                      <ul class="icon-group booking-item-rating-stars">
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star"></i>
                        </li>
                        <li><i class="fa fa-star-o"></i>
                        </li>
                      </ul>
                      <span class="booking-item-rating-number"><b>3.8</b> of 5</span><small>(1208 reviews)</small>
                    </div>
                    <h5 class="booking-item-title">Styish, Chic, Best of West Village</h5>
                    <p class="booking-item-address">
                      <i class="fa fa-map-marker"></i> Queens (LaGuardia Airport (LGA))
                    </p>
                    <ul class="booking-item-features booking-item-features-rentals booking-item-features-sign">
                      <li rel="tooltip" data-placement="top" title="Sleeps"><i class="fa fa-male"></i><span class="booking-item-feature-sign">x 6</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bedrooms"><i class="im im-bed"></i><span class="booking-item-feature-sign">x 2</span>
                      </li>
                      <li rel="tooltip" data-placement="top" title="Bathrooms"><i class="im im-shower"></i><span class="booking-item-feature-sign">x 1</span>
                      </li>
                    </ul>
                  </div>
                  <div class="col-md-3">
                    <span class="booking-item-price">$367</span><span>/night</span><span class="btn btn-primary">Book Now</span>
                  </div>
                </div>
              </a>
            </li>
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