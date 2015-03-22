<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="blablacoolTemplateFull">
    <tiles:putAttribute name="body">
        <div class="full-center">
            <div class="container">
                <div class="row row-wrap" data-gutter="60">
                    registered!
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>