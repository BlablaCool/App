<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="header-top">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a class="logo" href="/">
                    <img src="/assets/img/logo-white.png">
                </a>
            </div>
            <div class="col-md-3 col-md-offset-2">
                <form class="main-header-search">
                    <div class="form-group form-group-icon-left">
                        <i class="fa fa-search input-icon"></i>
                        <input type="text" class="form-control">
                    </div>
                </form>
            </div>
            <div class="col-md-4">
                <div class="top-user-area clearfix">
                    <ul class="top-user-area-list list list-horizontal list-border">
                        <li class="top-user-area-avatar">
                            <s:url var="url_profile" value="/users/1"/>
                            <a href="${url_profile}">
                                <img class="origin round" src="/assets/img/amaze_40x40.jpg" alt="Image Alternative text" title="AMaze" />Hi, John</a>
                        </li>
                        <li><a href="index-7.html#">Sign Out</a>
                        </li>
                        <li class="nav-drop"><a href="index-7.html#">USD $<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i></a>
                            <ul class="list nav-drop-menu">
                                <li><a href="index-7.html#">EUR<span class="right">€</span></a>
                                </li>
                                <li><a href="index-7.html#">GBP<span class="right">£</span></a>
                                </li>
                                <li><a href="index-7.html#">JPY<span class="right">円</span></a>
                                </li>
                                <li><a href="index-7.html#">CAD<span class="right">$</span></a>
                                </li>
                                <li><a href="index-7.html#">AUD<span class="right">A$</span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="top-user-area-lang nav-drop">
                            <a href="index-7.html#">
                                <img src="/assets/img/flags/32/uk.png" data-no-retina>ENG<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i>
                            </a>
                            <ul class="list nav-drop-menu">
                                <li>
                                    <a title="German" href="index-7.html#">
                                        <img src="/assets/img/flags/32/de.png" data-no-retina><span class="right">GER</span>
                                    </a>
                                </li>
                                <li>
                                    <a title="Japanise" href="index-7.html#">
                                        <img src="/assets/img/flags/32/jp.png" data-no-retina><span class="right">JAP</span>
                                    </a>
                                </li>
                                <li>
                                    <a title="Italian" href="index-7.html#">
                                        <img src="/assets/img/flags/32/it.png" data-no-retina><span class="right">ITA</span>
                                    </a>
                                </li>
                                <li>
                                    <a title="French" href="index-7.html#">
                                        <img src="/assets/img/flags/32/fr.png" data-no-retina><span class="right">FRE</span>
                                    </a>
                                </li>
                                <li>
                                    <a title="Russian" href="index-7.html#">
                                        <img src="/assets/img/flags/32/ru.png" data-no-retina><span class="right">RUS</span>
                                    </a>
                                </li>
                                <li>
                                    <a title="Korean" href="index-7.html#">
                                        <img src="/assets/img/flags/32/kr.png" data-no-retina><span class="right">KOR</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>