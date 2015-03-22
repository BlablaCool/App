<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplateFull">

    <tiles:putAttribute name="header-custom-css">
        <link rel="stylesheet" href="/assets/plugins/formValidation/css/formValidation.min.css">
        <style>
            .has-error .help-block {
                color: white !important;
            }
        </style>
    </tiles:putAttribute>

    <tiles:putAttribute name="footer-custom-js">
        <script src="/assets/plugins/formValidation/js/formValidation.min.js"></script>
        <script src="/assets/plugins/formValidation/js/framework/bootstrap.min.js"></script>
        <script src="/assets/plugins/formValidation/js/language/fr_FR.js"></script>
        <script src="/assets/js/login-register.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="full-center">
            <div class="container">
                <div class="row row-wrap" data-gutter="60">
                    <div class="col-md-3">
                        <div class="visible-lg">
                            <h3 class="mb15">Bienvenue sur BlablaCool !</h3>
                            <p>
                                BlablaCool est un nouveau service de covoiturage qui privilégie...
                            </p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <h3 class="mb15">Se connecter</h3>
                        <form action="/j_spring_security_check" method="POST">
                            <c:if test="${param.containsKey('error') && param.get('error').contentEquals('login')}">
                                <div class="alert alert-danger">
                                    Nous n'avons pas réussi à vous connecter au service. Merci de bien vouloir réessayer...
                                </div>
                            </c:if>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-user input-icon input-icon-show"></i>
                                <label>Adresse email</label>
                                <input class="form-control" type="text" id="email" name="email" />
                            </div>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-lock input-icon input-icon-show"></i>
                                <label>Mot de passe</label>
                                <input class="form-control" type="password" id="password" name="password" />
                            </div>
                            <p style="margin-top: 26px;">
                                <input class="btn btn-primary" type="submit" value="Se connecter" />
                            </p>
                        </form>
                    </div>

                    <div class="col-md-5">
                        <h3 class="mb15">Créer un compte</h3>
                        <form:form action="/auth/login-register" method="POST" modelAttribute="newUser" id="registration-form">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-heart input-icon input-icon-show"></i>
                                        <label>Pseudo</label>
                                        <form:input path="nickname" id="nickname" cssClass="form-control" />
                                        <form:errors path="nickname" cssClass="error-form" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-user input-icon input-icon-show"></i>
                                        <label>Prénom</label>
                                        <form:input path="firstname" id="firstname" cssClass="form-control" />
                                        <form:errors path="firstname" cssClass="error-form" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-user input-icon input-icon-show"></i>
                                        <label>Nom</label>
                                        <form:input path="lastname" id="lastname" cssClass="form-control" />
                                        <form:errors path="lastname" cssClass="error-form" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-envelope-o input-icon input-icon-show"></i>
                                <label>Adresse email</label>
                                <form:input path="email" id="email" cssClass="form-control" />
                                <form:errors path="email" cssClass="error-form" />
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-lock input-icon input-icon-show"></i>
                                        <label>Mot de passe</label>
                                        <form:password path="password" id="password" cssClass="form-control" />
                                        <form:errors path="password" cssClass="error-form" />
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-lock input-icon input-icon-show"></i>
                                        <label>Confirmation</label>
                                        <form:password path="passwordConfirmation" id="passwordConfirmation" cssClass="form-control" />
                                        <form:errors path="passwordConfirmation" cssClass="error-form" />
                                    </div>
                                </div>
                            </div>
                            <p style="margin-top: 15px;">
                                <input class="btn btn-primary" type="submit" value="Créer un compte" />
                            </p>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>