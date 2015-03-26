<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="blablacoolTemplate">

    <tiles:putAttribute name="footer-custom-js">
        <script src="//maps.googleapis.com/maps/api/js?libraries=places"></script>
        <script src="/assets/js/jquery.geocomplete.min.js"></script>
        <script src="/assets/js/maplace.min.js"></script>
        <script src="/assets/js/trips.new.js"></script>
    </tiles:putAttribute>

    <tiles:putAttribute name="body">
        <div class="container">
            <h1 class="page-title">Créer un itinéraire</h1>
        </div>

        <div class="container">

            <div class="row" style="">
                <div class="col-md-12">
                    <h3 style="margin-bottom: 20px;">1. Paramètres</h3>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Basic panel example
                        </div>
                    </div>
                </div>
            </div>

            <hr>

            <div class="row">
                <div class="col-md-6">
                    <h3 style="margin-bottom: 20px;">2. Etapes du parcours</h3>
                    <div class="row">
                        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
                            <jsp:param name="pointNameLong" value="de Départ" />
                            <jsp:param name="pointName" value="departure" />
                            <jsp:param name="flag" value="fa-flag" />
                            <jsp:param name="canAddAfter" value="yes" />
                        </jsp:include>
                        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
                            <jsp:param name="pointNameLong" value="d'Arrivée" />
                            <jsp:param name="pointName" value="arrival" />
                            <jsp:param name="flag" value="fa-flag-checkered" />
                        </jsp:include>
                    </div>
                </div>
                <div class="col-md-6" style="margin-bottom: 32px;">
                    <div id="globalMap" style="height: 520px;"></div>
                </div>
            </div>
            <div class="row">
                <button type="button" id="createTrip">Créer</button>
            </div>
        </div>

        <div class="gap"></div>

        <jsp:include page="/WEB-INF/views/blocks/trips/new-input.jsp">
            <jsp:param name="pointNameLong" value="intermédiaire" />
            <jsp:param name="pointName" value="placeholder" />
            <jsp:param name="flag" value="fa-flag-o" />
            <jsp:param name="canAddAfter" value="yes" />
            <jsp:param name="isModel" value="yes" />
        </jsp:include>

    </tiles:putAttribute>
</tiles:insertDefinition>