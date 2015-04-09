<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="header-custom-css">
        <link type="text/css" rel="stylesheet" href="/assets/css/spinkit.css">
        <link type="text/css" rel="stylesheet" href="/assets/css/fade.css">
    </tiles:putAttribute>

    <tiles:putAttribute name="footer-custom-js">
        <script src="/assets/js/cars.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Ajouter une voiture</h1>
        </div>
                <spring:url var="addCarUrl" value="/cars/create" />
        <div class="container">
                <form:form action="${addCarUrl}" method="POST" modelAttribute="newCar" class="form-horizontal" id="carForm">
                <fieldset>
                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="brand" id="brand">Marque</label>
                        <div class="col-md-5">
                            <form:select path="brand" id="brands" name="brand" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="model" id="model">Modele</label>
                        <div class="col-md-5">
                            <form:select path="model" id="models" name="model" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="year">Année</label>
                        <div class="col-md-5">
                            <form:select path="year" id="year" name="year" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="model">Portes</label>
                        <div class="col-md-5">
                            <form:select path="doors" id="doors" name="doors" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="capacity">Places</label>
                        <div class="col-md-5">
                            <form:select path="capacity" id="capacity" name="capacity" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="fuel">Carburant</label>
                        <div class="col-md-5">
                            <%--<form:select path="fuel" id="fuel" name="fuel" cssClass="form-control" disabled="true">--%>
                            <%--</form:select>--%>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="horsePower">Puissance</label>
                        <div class="col-md-5">
                            <form:select path="horsePower" id="horsePower" name="horsePower" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="type">Type</label>
                        <div class="col-md-4">
                            <form:select path="type" id="type" name="type" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="model">Version</label>
                        <div class="col-md-5">
                            <form:select path="trim" id="trim" name="trim" cssClass="form-control" disabled="true">
                            </form:select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="registration">Immatriculation</label>
                        <div class="col-md-4">
                            <form:input path="registration" cssClass="form-control"></form:input>
                        </div>
                    </div>

                    <form:hidden path="apiId" id="apiId" cssClass="form-control" disabled="true"></form:hidden>

                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <input class="btn btn-success" type="submit" value="Ajouter" />
                        </div>
                    </div>

                </fieldset>
            </form:form>
            <div class="spinner sk-spinner sk-spinner-wandering-cubes" id="spinner">
                <div class="sk-cube1"></div>
                <div class="sk-cube2"></div>
            </div>
        </div>
        <div class="gap"></div>

    </tiles:putAttribute>
</tiles:insertDefinition>