<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="/assets/js/cars.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Ajouter une voiture</h1>
        </div>
                <spring:url var="addCarUrl" value="/car/add" />
        <div class="container">
                <form:form action="${addCarUrl}" method="POST" modelAttribute="newCar" class="form-horizontal">
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
                        <label class="col-md-4 control-label" for="type">Type</label>
                        <div class="col-md-4">
                            <form:select path="type" id="type" name="type" cssClass="form-control">
                                <form:option value="Citadine">Citadine</form:option>
                                <form:option value="Berline">Berline</form:option>
                                <form:option value="Break">Break</form:option>
                                <form:option value="Monospace">Monospace</form:option>
                                <form:option value="SUV">SUV</form:option>
                                <form:option value="Coupé">Coupé</form:option>
                                <form:option value="Cabriolet">Cabriolet</form:option>
                            </form:select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="registration">Immatriculation</label>
                        <div class="col-md-4">
<%--
                            <input id="registration" name="registration" type="text" placeholder="AA-111-AA" class="form-control input-md" required="">
--%>
                            <form:input path="registration" cssClass="form-control"></form:input>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="spots">Places</label>
                        <div class="col-md-2">
                            <form:select  path="capacity" id="capacity" name="capacity" class="form-control">
                                <form:option value="1">1</form:option>
                                <form:option value="2">2</form:option>
                                <form:option value="3">3</form:option>
                                <form:option value="4">4</form:option>
                                <form:option value="5">5</form:option>
                                <form:option value="6">6</form:option>
                                <form:option value="7">7</form:option>
                            </form:select>
                        </div>
                    </div>

                    <!-- File Button -->
<%--                    <div class="form-group">
                        <label class="col-md-4 control-label" for="image">Image</label>
                        <div class="col-md-4">
                            <input id="image" name="image" class="input-file" type="file">
                        </div>
                    </div>--%>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <input class="btn btn-success" type="submit" value="Ajouter" />
                        </div>
                    </div>

                </fieldset>
            </form:form>
        </div>

        <div class="gap"></div>

    </tiles:putAttribute>
</tiles:insertDefinition>