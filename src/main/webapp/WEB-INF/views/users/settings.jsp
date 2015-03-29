<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                        <div class="col-md-5">
                            <form:form action="/users/update" modelAttribute="user">
                                <h4>Informations personelles</h4>
                                <div class="form-group form-group-icon-left"><i class="fa fa-user input-icon"></i>
                                    <label>Prénom</label>
                                    <form:input path="firstname" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-user input-icon"></i>
                                    <label>Nom</label>
                                    <form:input path="lastname" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-envelope input-icon"></i>
                                    <label>E-mail</label>
                                    <form:input path="email" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group form-group-icon-left"><i class="fa fa-phone input-icon"></i>
                                    <label>Numéro de Téléphone</label>
                                    <form:input path="phoneNumber" cssClass="form-control"></form:input>
                                </div>
                                <div class="gap gap-small"></div>
                                <h4>Coordonnées</h4>
                                <div class="form-group">
                                    <label>Addresse</label>
                                    <form:input path="address" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group">
                                    <label>Ville</label>
                                    <form:input path="city" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group">
                                    <label>State/Province/Region</label>
                                    <form:input path="state" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group">
                                    <label>Code Postal</label>
                                    <form:input path="postcode" cssClass="form-control"></form:input>
                                </div>
                                <div class="form-group">
                                    <label>Pays</label>
                                    <form:input path="country" cssClass="form-control"></form:input>
                                </div>
                                <div class="gap gap-small"></div>
                                <h4>Traits de caractère</h4>
                                <div class="form-group">
                                    <label>Possède un animal</label>
                                    <div class="radio-inline">
                                        <label>
                                            <form:radiobutton path="preferences.likeAnimals" value="1" cssClass="i-radio" /> Oui
                                        </label>
                                    </div>
                                    <div class="radio-inline">
                                        <label>
                                            <form:radiobutton path="preferences.likeAnimals" value="0" cssClass="i-radio" /> Non
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Style de musique</label>
                                    <form:select path="preferences.musicStyle" cssClass="form-control">
                                        <form:option value="none" label="Choisir un style de musique..."/>
                                        <form:options items="${musicStyles}" />
                                    </form:select>
                                </div>
                                <div class="form-group">
                                    <label>Fumeur</label>
                                    <div class="radio-inline">
                                        <label>
                                            <form:radiobutton path="preferences.likeSmoking" value="1" cssClass="i-radio" /> Oui
                                        </label>
                                    </div>
                                    <div class="radio-inline">
                                        <label>
                                            <form:radiobutton path="preferences.likeSmoking" value="0" cssClass="i-radio" /> Non
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Tempérament</label>
                                    <select name="personnality" class="form-control">
                                        <option value="calme">Calme</option>
                                        <option value="avenant">Avenant</option>
                                        <option value="decontracte">Decontracté</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>J'ai tendance a beaucoup parler</label>
                                    <div class="radio-inline">
                                        <label>
                                            <input class="i-radio" type="radio" name="talkative" />Oui</label>
                                    </div>
                                    <div class="radio-inline">
                                        <label>
                                            <input class="i-radio" type="radio" name="talkative" />Non</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Style de conduite</label>
                                    <select name="drivingStyle" class="form-control">
                                        <option value="calme">Calme</option>
                                        <option value="sprotif">Sptortif</option>
                                        <option value="prudent">Prudent</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Informations supplémentaires:</label>
                                    <textarea class="form-control" rows="5" name="description"></textarea>
                                </div>
                                <hr>
                                <input type="submit" class="btn btn-primary" value="Savegarder">
                            </form:form>
                        </div>
                        <div class="col-md-4 col-md-offset-1">
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


