<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="user" type="info.fges.blablacool.models.User"--%>
<%--@elvariable id="userPreferences" type="info.fges.blablacool.models.UserPreference"--%>

<tiles:insertDefinition name="blablacoolTemplate">
    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Paramètres</h1>
        </div>
        <div class="container">
            <div class="row">
                <jsp:include page="/WEB-INF/views/users/blocks/sidebar.jsp"/>
                <div class="col-md-9">
                    <div class="row">
                        <form:form action="/users/updateUser" modelAttribute="user">
                            <div class="col-md-6">
                                <h4>Informations personnelles</h4>
                                <form:hidden path="id"></form:hidden>
                                <div class="form-group form-group-icon-left"><i class="fa fa-user input-icon"></i>
                                    <label>Pseudo</label>
                                    <form:input path="nickname" cssClass="form-control" readonly="true"></form:input>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group form-group-icon-left"><i class="fa fa-user input-icon"></i>
                                            <label>Prénom</label>
                                            <form:input path="firstname" cssClass="form-control"></form:input>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group form-group-icon-left"><i class="fa fa-user input-icon"></i>
                                            <label>Nom</label>
                                            <form:input path="lastname" cssClass="form-control"></form:input>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-envelope input-icon"></i>
                                    <label>E-mail</label>
                                    <form:input path="email" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-phone input-icon"></i>
                                    <label>Numéro de Téléphone</label>
                                    <form:input path="phoneNumber" cssClass="form-control"></form:input>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <h4>Coordonnées</h4>
                                <div class="form-group">
                                    <label>Addresse</label>
                                    <form:input path="address" cssClass="form-control"></form:input>
                                </div>

                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label>Code Postal</label>
                                            <form:input path="postcode" cssClass="form-control"></form:input>
                                        </div>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <label>Ville</label>
                                            <form:input path="city" cssClass="form-control"></form:input>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>State/Province/Region</label>
                                    <form:input path="state" cssClass="form-control"></form:input>
                                </div>

                                <div class="form-group">
                                    <label>Pays</label>
                                    <form:input path="country" cssClass="form-control"></form:input>
                                </div>
                            </div>
                            <div class="col-md-12 text-center mt20">
                                <button type="submit" class="btn btn-lg btn-success">Mettre à jour mes coordonnées</button>
                            </div>
                        </form:form>
                    </div>
                    <div class="row" style="margin-top: 62px;">
                        <div class="col-md-6">
                            <form:form action="/users/updateUserPreferences" modelAttribute="userPreferences" cssClass="form-horizontal">
                                <h4>Traits de caractère</h4>

                                <form:hidden path="idUserPreference"></form:hidden>

                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Je possède un animal ?</label>
                                            <div class="radio-inline">
                                                <label>
                                                    <form:radiobutton path="likeAnimals" value="1" cssClass="i-radio" /> Oui
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label>
                                                    <form:radiobutton path="likeAnimals" value="0" cssClass="i-radio" /> Non
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label>Je fume ?</label>
                                            <div class="radio-inline">
                                                <label>
                                                    <form:radiobutton path="likeSmoking" value="1" cssClass="i-radio" /> Oui
                                                </label>
                                            </div>
                                            <div class="radio-inline">
                                                <label>
                                                    <form:radiobutton path="likeSmoking" value="0" cssClass="i-radio" /> Non
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label>Mon style de <strong>musique</strong>...</label>
                                            <form:select path="musicStyle" cssClass="form-control">
                                                <form:option value="none" label="Choisir......"/>
                                                <form:options items="${musicStyles}" />
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="col-md-5 col-md-offset-1">
                                        <div class="form-group">
                                            <label>Mon style de <strong>conduite</strong>...</label>
                                            <form:select path="drivingStyle" cssClass="form-control">
                                                <form:option value="none" label="Choisir..."/>
                                                <form:options items="${drivingStyles}" />
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label>Mon tempérament</label>
                                            <form:select path="temperament" cssClass="form-control">
                                                <form:option value="none" label="Choisir un tempérament..."/>
                                                <form:options items="${temperaments}" />
                                            </form:select>
                                        </div>
                                    </div>
                                    <div class="col-md-5 col-md-offset-1">
                                        <div class="form-group">
                                            <label>J'aime parler...</label>
                                            <form:select path="talkingLevel" cssClass="form-control">
                                                <form:option value="none" label="Choisir..."/>
                                                <form:options items="${talkingLevels}" />
                                            </form:select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>Informations supplémentaires:</label>
                                    <textarea class="form-control" rows="5" name="description"></textarea>
                                </div>

                                <p class="text-center mt20">
                                    <input type="submit" class="btn btn-lg btn-success" value="Enregister">
                                </p>
                            </form:form>
                        </div>
                        <div class="col-md-5 col-md-offset-1">
                            <h4>Modifier le mot de passe</h4>
                            <form>
                                <div class="form-group form-group-icon-left"><i class="fa fa-lock input-icon"></i>
                                    <label>Ancien mot de passe</label>
                                    <input class="form-control" type="password" />
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-lock input-icon"></i>
                                    <label>Nouveau mot de passe</label>
                                    <input class="form-control" type="password" />
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-lock input-icon"></i>
                                    <label>Confirmation</label>
                                    <input class="form-control" type="password" />
                                </div>
                                <hr />
                                <input class="btn btn-primary" type="submit" value="Modifier" />
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="gap"></div>
   </tiles:putAttribute>
</tiles:insertDefinition>


