<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplateFull">
    <tiles:putAttribute name="body">

        <div class="full-center">
            <div class="container">
                <div class="row row-wrap" data-gutter="60">
                    <div class="col-md-4">
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
                            <input class="btn btn-primary" type="submit" value="Se connecter" />
                        </form>
                    </div>
                    <div class="col-md-4">
                        <h3 class="mb15">Créer un compte</h3>
                        <form>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-user input-icon input-icon-show"></i>
                                <label>Full Name</label>
                                <input class="form-control" placeholder="e.g. John Doe" type="text" />
                            </div>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-envelope input-icon input-icon-show"></i>
                                <label>Emai</label>
                                <input class="form-control" placeholder="e.g. johndoe@gmail.com" type="text" />
                            </div>
                            <div class="form-group form-group-ghost form-group-icon-left"><i class="fa fa-lock input-icon input-icon-show"></i>
                                <label>Password</label>
                                <input class="form-control" type="password" placeholder="my secret password" />
                            </div>
                            <input class="btn btn-primary" type="submit" value="Sign up for Traveler" />
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>