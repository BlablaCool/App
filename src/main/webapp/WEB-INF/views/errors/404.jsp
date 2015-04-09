<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplateFull">

  <tiles:putAttribute name="header-custom-css">
    <link rel="stylesheet" href="/assets/plugins/formValidation/css/formValidation.min.css">
    <style>
      .has-error .help-block {
        color: white !important;
        font-weight: 700 !important;
        font-size: 14px !important;
      }
    </style>
  </tiles:putAttribute>

  <tiles:putAttribute name="footer-custom-js">

  </tiles:putAttribute>

  <tiles:putAttribute name="body">

    <div class="bg-img" style="background-image:url('/assets/img/background-full.jpg');"></div>
    <div class="bg-holder-content full text-white">
    <a class="logo-holder" href="/">
      <img src="/assets/img/logo-white.png" />
    </a>

    <div class="full-center">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-offset-3">
            <p class="text-hero">404</p>
            <h1>Page non trouvée</h1>
            <p>
              La ressource demandée n'à pas été trouvée.
            </p><br />
            <a class="btn btn-white btn-ghost btn-lg mt5" href="/"><i class="fa fa-long-arrow-left"></i> Revenir à l'Accueil</a>
          </div>
        </div>
      </div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>