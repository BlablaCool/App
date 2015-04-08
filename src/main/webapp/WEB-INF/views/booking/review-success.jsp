<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<fmt:setLocale value="fr_FR" />

<%--@elvariable id="booking" type="info.fges.blablacool.models.Booking"--%>
<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>

<tiles:insertDefinition name="blablacoolTemplate">

  <tiles:putAttribute name="footer-custom-js">
    <script src="/assets/js/booking.review.js"></script>
  </tiles:putAttribute>

  <tiles:putAttribute name="body">
    <div class="gap"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-md-offset-1 text-center">
          <i class="fa fa-thumbs-up box-icon-huge box-icon-center box-icon-success box-icon-to-success animate-icon-border-fadein mb30"></i>
          <h2>C'est noté. Merci !</h2>
          <p class="lead">
            Chez BlablaCool nous attachons une attention particulière à vos remarques.<br>
            Vos évaluations permettent à la communauté de grandir dans les meilleures conditions.
          </p>
          <p>
            <a href="/users/passenger" class="btn btn-primary">Retour à mon Compte</a>
          </p>
        </div>
      </div>
      <div class="gap"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>