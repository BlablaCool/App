<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="blablacoolTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">
                <c:choose>
                    <c:when test="${viewedUser.id==user.id}">
                        <a class="booking-item-review-person-avatar round" href="rentals-details.html#">
                            <img src="/assets/img/good_job_100x100.jpg" alt="Image Alternative text" title="Afro">
                        </a>
                        Profile
                    </c:when>
                    <c:when test="${viewedUser.id!=user.id}">
                        <a class="booking-item-review-person-avatar round" href="rentals-details.html#">
                            <img src="/assets/img/good_job_100x100.jpg" alt="Image Alternative text" title="Afro">
                        </a>
                        <c:out value="${viewedUser.firstname} ${viewedUser.lastname}"/>
                    </c:when>
                </c:choose>
            </h1>
        </div>
        <div class="container">
            <div class="row">
                <c:if test="${viewedUser.id==user.id}">
                    <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
                </c:if>
                <div class="col-md-9">
                    <h4>Statistiques</h4>
                    <ul class="list list-inline user-profile-statictics mb30">
                        <li><i class="fa fa-dashboard user-profile-statictics-icon"></i>
                            <h5>12540</h5>
                            <p>Kilometres parcourus</p>
                        </li>
                        <li><i class="fa fa-car user-profile-statictics-icon"></i>
                            <h5>21</h5>
                            <p>Trajets Passager</p>
                        </li>
                        <li><i class="fa fa-car user-profile-statictics-icon"></i>
                            <h5>15</h5>
                            <p>Trajets Conducteur</p>
                        </li>
                        <li><i class="fa fa-smile-o user-profile-statictics-icon"></i>
                            <h5>4.5/5</h5>
                            <p>Satisfaction</p>
                        </li>
                    </ul>
                    <div class="gap gap-small"></div>
                    <h3 class="mb20">Avis covoitureurs</h3>
                    <div class="row row-wrap">
                        <div class="col-md-12">
                            <ul class="booking-item-reviews list">
                                <li>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="booking-item-review-person">
                                                <p class="booking-item-review-person-name"><a href="rentals-details.html#">John Doe</a>
                                                </p>
                                                <p class="booking-item-review-person-loc">Palm Beach, FL</p><small><a href="rentals-details.html#">98 Reviews</a></small>
                                            </div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="booking-item-review-content">
                                                <h5>"Tempus vestibulum mus imperdiet nibh sem"</h5>
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
                                                <p>Pharetra quis netus vel vehicula class vestibulum nisl donec hendrerit fermentum magna sed amet purus sit nec class sit fringilla tellus volutpat per eget molestie<span class="booking-item-review-more"> Platea suspendisse eget tortor pharetra magna nam senectus tristique cursus ut odio sollicitudin venenatis natoque dis maecenas magna dignissim sociosqu et sociis accumsan interdum dictum netus quis enim phasellus suscipit nunc donec purus dui himenaeos nulla sociosqu rhoncus dictumst fusce ultricies congue sapien porttitor maecenas fringilla ipsum nam lorem aliquam rhoncus elit himenaeos</span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="booking-item-review-person">
                                                <p class="booking-item-review-person-name"><a href="rentals-details.html#">Minnie Aviles</a>
                                                </p>
                                                <p class="booking-item-review-person-loc">Palm Beach, FL</p><small><a href="rentals-details.html#">64 Reviews</a></small>
                                            </div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="booking-item-review-content">
                                                <h5>"Varius massa maecenas et id dictumst mattis"</h5>
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
                                                <p>Donec fringilla ac parturient posuere id phasellus erat elementum nullam lacus cursus rhoncus parturient vitae praesent quisque nascetur molestie quis dignissim vel sit odio metus tristique auctor dictumst primis ad viverra quisque etiam in rutrum donec cras non<span class="booking-item-review-more"> Dis suscipit risus ridiculus lacus mus cursus luctus donec pellentesque rhoncus sem quam vulputate mus hendrerit risus ultrices a elementum massa est at aenean parturient in egestas senectus lectus convallis lectus dui neque sit dignissim facilisis fames feugiat laoreet pharetra felis vitae ornare lacus sodales non sapien curae nisl nec habitant velit semper pretium et ipsum dolor in amet nunc vestibulum lacus nulla dis sollicitudin diam luctus dolor ante</span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="booking-item-review-person">
                                                <p class="booking-item-review-person-name"><a href="rentals-details.html#">Cyndy Naquin</a>
                                                </p>
                                                <p class="booking-item-review-person-loc">Palm Beach, FL</p><small><a href="rentals-details.html#">80 Reviews</a></small>
                                            </div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="booking-item-review-content">
                                                <h5>"Curabitur senectus blandit parturient quam fames sem"</h5>
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
                                                <p>Nec interdum id torquent litora nibh curae morbi cum etiam duis malesuada viverra ultricies pellentesque vestibulum sed mattis augue penatibus venenatis malesuada nam semper facilisis taciti posuere convallis curae auctor non sodales iaculis blandit taciti pellentesque faucibus id<span class="booking-item-review-more"> Nam scelerisque sapien ultricies euismod viverra diam dictum curabitur laoreet facilisi conubia purus taciti malesuada eget cum malesuada nunc libero vestibulum aptent aliquam eros facilisi purus mus odio praesent facilisi molestie</span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="row">
                                        <div class="col-md-2">
                                            <div class="booking-item-review-person">
                                                <p class="booking-item-review-person-name"><a href="rentals-details.html#">Carol Blevins</a>
                                                </p>
                                                <p class="booking-item-review-person-loc">Palm Beach, FL</p><small><a href="rentals-details.html#">71 Reviews</a></small>
                                            </div>
                                        </div>
                                        <div class="col-md-10">
                                            <div class="booking-item-review-content">
                                                <h5>"Parturient cursus sem"</h5>
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
                                                <p>Tempor ligula a at ultrices commodo nibh potenti feugiat morbi molestie litora leo eu ullamcorper montes consectetur eros fringilla per placerat velit<span class="booking-item-review-more"> Tincidunt aptent vulputate gravida curae lacinia imperdiet tempus erat vulputate posuere mollis quisque magna facilisi sagittis ridiculus consequat a nisl tincidunt nisl dapibus leo dignissim dapibus odio eu eu mi quam nibh erat tortor habitasse fringilla porttitor a sapien vivamus praesent arcu turpis malesuada tortor rutrum ante hac fringilla inceptos ante molestie nostra nulla est maecenas sodales per mi dictum nisl eros dignissim commodo a</span>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="gap"></div>
   </tiles:putAttribute>
</tiles:insertDefinition>





