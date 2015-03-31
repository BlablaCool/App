<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.isModel eq 'yes'}">
    <div id="placeholderContainer" class="col-md-12 step-wrapper">
</c:if>
<c:if test="${param.isModel != 'yes'}">
    <div class="col-md-12 step-wrapper">
</c:if>
    <h5><i class="fa ${param.flag}"></i> &nbsp;Point ${param.pointNameLong}</h5>

    <c:choose>
        <c:when test="${param.isModel eq 'yes'}">
            <form id="${param.pointName}Form"
                data-fv-framework="bootstrap"
                data-fv-icon-valid="glyphicon glyphicon-ok"
                data-fv-icon-invalid="glyphicon glyphicon-remove"
                data-fv-icon-validating="glyphicon glyphicon-refresh">
        </c:when>
        <c:otherwise>
            <form id="${param.pointName}Form" class="placeContainer">
        </c:otherwise>
    </c:choose>

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Adresse, P.O.I., etc...</label>
                    <input class="form-control" type="text" id="${param.pointName}Address" name="addressTyped">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-filled">
                    <label>Date</label>
                    <input class="date-pick form-control" type="text" id="${param.pointName}Date" name="date">
                </div>
            </div>
            <div class="col-md-3">
                <div class="form-group form-group-filled">
                    <label>Heure</label>
                    <input class="time-pick form-control" type="text" id="${param.pointName}Time" name="time">
                </div>
            </div>
        </div>
        <input type="hidden" name="type" value="${param.pointName}">
        <input type="hidden" name="name">
        <input type="hidden" name="lat">
        <input type="hidden" name="lng">
        <input type="hidden" name="location">
        <input type="hidden" name="formatted_address">
        <input type="hidden" name="street_number">
        <input type="hidden" name="postal_code">
        <input type="hidden" name="locality">
        <input type="hidden" name="country">
        <input type="hidden" name="country_short">
        <input type="hidden" name="administrative_area_level_1">
        <input type="hidden" name="place_id">
    </form>

    <c:if test="${param.canAddAfter eq 'yes'}">
        <i class="addMiddleStep fa fa-plus box-icon-to-normal box-icon-center box-icon-gray box-icon-to-success box-icon-border-dashed animate-icon-border-rise round" style="cursor: pointer; margin-top: 10px;"></i>
    </c:if>

</div>