<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="/assets/js/cars.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Ajouter une voiture</h1>
        </div>

        <div class="container">
            <form class="form-horizontal">
                <fieldset>
                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="brand" id="brand">Marque</label>
                        <div class="col-md-5">
                            <select id="brands" name="brand" class="form-control" disabled>
                            </select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="model" id="model">Modele</label>
                        <div class="col-md-5">
                            <select id="models" name="model" class="form-control" disabled>
                            </select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="type">Type</label>
                        <div class="col-md-4">
                            <select id="type" name="type" class="form-control">
                                <option value="Citadine">Citadine</option>
                                <option value="Berline">Berline</option>
                                <option value="Break">Break</option>
                                <option value="Monospace">Monospace</option>
                                <option value="SUV">SUV</option>
                                <option value="Coupé">Coupé</option>
                                <option value="Cabriolet">Cabriolet</option>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="registration">Immatriculation</label>
                        <div class="col-md-4">
                            <input id="registration" name="registration" type="text" placeholder="AA-111-AA" class="form-control input-md" required="">

                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="spots">Places</label>
                        <div class="col-md-2">
                            <select id="spots" name="spots" class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                            </select>
                        </div>
                    </div>

                    <!-- File Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="image">Image</label>
                        <div class="col-md-4">
                            <input id="image" name="image" class="input-file" type="file">
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submitBtn"></label>
                        <div class="col-md-4">
                            <button id="submitBtn" name="submitBtn" class="btn btn-primary">Submit</button>
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>

        <div class="gap"></div>

    </tiles:putAttribute>
</tiles:insertDefinition>