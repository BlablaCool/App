<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="trip" type="info.fges.blablacool.models.Trip"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script>
      var locations = ${trip.stepsInJson};
      var idTrip = ${trip.idTrip};
    </script>
    <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
    <script src="/assets/js/maplace.min.js"></script>
    <script src="/assets/js/trips.get.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">

    <div id="bigMapOnTripPage"></div>

    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="page-title clearfix">
            <span class="pull-left"><strong>${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</strong></span>
            <span class="pull-right">
              <%--<fmt:formatNumber value="${trip.price}" type="currency"/>--%>
              <button class="btn btn-lg btn-primary" data-toggle="modal" data-target="#bookingModal">Réserver</button>
            </span>
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-10 col-md-offset-1">
          <div class="panel panel-default">
            <div class="panel-body" style="padding-top: 14px;">
              <form id="infosForm" class="form-horizontal">
                <div class="row">
                  <div class="col-md-4">
                    <h4 style="text-align: center; font-weight: 600; text-transform: uppercase;">Le Conducteur</h4>
                  </div>
                  <div class="col-md-8">
                    <h4 style="text-align: center; font-weight: 600; text-transform: uppercase;">Le Voyage</h4>
                    <h5>Étapes</h5>
                    <table class="table">
                      <thead>
                        <tr>
                          <th style="width: 70%;">Etape</th>
                          <th style="width: 30%;">Date et heure</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${trip.steps}" var="step">
                          <tr>
                            <td>${step.place.address}</td>
                            <td><joda:format value="${step.estimatedTime}" pattern="dd/MM/yyyy à HH:mm:ss" /></td>
                          </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>

      <div class="row" style="margin: 21px 0;">
        <div class="col-md-8 col-md-offset-2">
          <h4 style="font-weight: 600; text-transform: uppercase; display: inline;">Participants</h4>
          <ul id="participantsList">
            <li><img src="http://lorempixel.com/420/420/people/" class="img-circle img-thumbnail" style="max-width: 84px; max-height: 84px;"></li>
            <li><img src="http://lorempixel.com/420/420/people/" class="img-circle img-thumbnail" style="max-width: 84px; max-height: 84px;"></li>
          </ul>
        </div>
      </div>

      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <h4 style="font-weight: 600; text-transform: uppercase; display: inline;">Messages</h4>
          <ul class="comments-list">
            <li>
              <div class="article comment" inline_comment="comment">
                <div class="comment-author">
                  <img src="/assets/img/gamer_chick_50x50.jpg" alt="Image Alternative text" title="Gamer Chick"/>
                </div>
                <div class="comment-inner">
                  <span class="comment-author-name">Alison Mackenzie</span>
                  <p class="comment-content">
                    Sociosqu mi nascetur sapien magna vitae aenean nulla auctor imperdiet primis risus at tempor tempor congue lacinia adipiscing dis vestibulum nunc ultricies tristique dignissim ornare diam praesent
                  </p>
                  <span class="comment-time">15 seconds ago</span><a class="comment-reply" href="feature-elements.html#"><i class="fa fa-reply"></i> Reply</a><a class="comment-like" href="feature-elements.html#"><i class="fa fa-heart"></i> 22</a>
                </div>
              </div>
            </li>
            <li>
              <div class="article comment" inline_comment="comment">
                <div class="comment-author">
                  <img src="/assets/img/4_strokes_of_fun_50x50.jpg" alt="Image Alternative text" title="4 Strokes of Fun"/>
                </div>
                <div class="comment-inner">
                  <span class="comment-author-name">Brandon Burgess</span>
                  <p class="comment-content">
                    Hendrerit dolor aenean hac gravida nisl ornare viverra nullam ac ante integer morbi tempor fusce sociosqu vestibulum dictum commodo ac duis in lacinia conubia cum lorem ultrices ullamcorper commodo
                  </p>
                  <span class="comment-time">15 seconds ago</span><a class="comment-reply" href="feature-elements.html#"><i class="fa fa-reply"></i> Reply</a><a class="comment-like" href="feature-elements.html#"><i class="fa fa-heart"></i> 44</a>
                </div>
              </div>
            </li>
            <li>
              <div class="article comment" inline_comment="comment">
                <div class="comment-author">
                  <img src="/assets/img/spidy_50x50.jpg" alt="Image Alternative text" title="Spidy"/>
                </div>
                <div class="comment-inner">
                  <span class="comment-author-name">Brandon Burgess</span>
                  <p class="comment-content">
                    Sed urna neque primis sociosqu class elit sociosqu ut taciti eros ullamcorper mus feugiat suspendisse sagittis phasellus auctor purus sed rhoncus dolor curabitur
                  </p>
                  <span class="comment-time">15 seconds ago</span><a class="comment-reply" href="feature-elements.html#"><i class="fa fa-reply"></i> Reply</a><a class="comment-like" href="feature-elements.html#"><i class="fa fa-heart"></i> 30</a>
                </div>
              </div>
              <ul>
                <li>
                  <div class="article comment" inline_comment="comment">
                    <div class="comment-author">
                      <img src="/assets/img/good_job_50x50.jpg" alt="Image Alternative text" title="Good job"/>
                    </div>
                    <div class="comment-inner">
                      <span class="comment-author-name">Dylan Taylor</span>
                      <p class="comment-content">
                        Magnis metus dis consequat sed tristique lorem magna dis lectus nascetur arcu mauris condimentum auctor morbi congue habitasse blandit dictum semper cursus dis per vivamus ac
                      </p>
                      <span class="comment-time">15 seconds ago</span><a class="comment-reply" href="feature-elements.html#"><i class="fa fa-reply"></i> Reply</a><a class="comment-like" href="feature-elements.html#"><i class="fa fa-heart"></i> 15</a>
                    </div>
                  </div>
                  <ul>
                    <li>
                      <div class="article comment" inline_comment="comment">
                        <div class="comment-author">
                          <img src="/assets/img/ana_29_50x50.jpg" alt="Image Alternative text" title="Ana 29"/>
                        </div>
                        <div class="comment-inner">
                          <span class="comment-author-name">Cheryl Gustin</span>
                          <p class="comment-content">
                            Ultricies phasellus augue amet curabitur primis gravida purus ultrices fermentum ac pellentesque faucibus phasellus
                          </p>
                          <span class="comment-time">15 seconds ago</span><a class="comment-reply" href="feature-elements.html#"><i class="fa fa-reply"></i> Reply</a><a class="comment-like" href="feature-elements.html#"><i class="fa fa-heart"></i> 22</a>
                        </div>
                      </div>
                      <ul>
                      </ul>
                  </ul>
              </ul>
          </ul>
        </div>
      </div>

      <div class="gap"></div>
    </div>

    <div class="modal fade" id="bookingModal" tabindex="-1" role="dialog" style="margin-top: 120px;">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Réserver ${trip.departureStep.place.city} <i class="fa fa-angle-right fa-fw"></i>${trip.arrivalStep.place.city}</h4>
          </div>
          <div class="modal-body">
            <p class="lead">Le montant du trajet est estimé à <strong><fmt:formatNumber value="${trip.price}" type="currency"/></strong>.</p>
            <p style="margin-bottom: 0;"><strong class="text-success">Vous êtes sur le point d'envoyer une demande à ${trip.driver.nickname} afin qu'il ou elle valide votre réservation.</strong> Vous serez prévenu dès que le statut sera mis à jour.</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
            <button type="button" id="confirmBooking" class="btn btn-success btn-lg">Je veux une place !</button>
          </div>
        </div>
      </div>
    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>