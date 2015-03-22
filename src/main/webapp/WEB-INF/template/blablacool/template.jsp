<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Traveler - Index 7</title>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <meta name="keywords" content="Template, html, premium, themeforest" />
        <meta name="description" content="Traveler - Premium template for travel companies">
        <meta name="author" content="BlablaCool">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='//fonts.googleapis.com/css?family=Roboto:400,300,100,500,700' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="/assets/css/bootstrap.css">
        <link rel="stylesheet" href="/assets/css/font-awesome.css">
        <link rel="stylesheet" href="/assets/css/icomoon.css">
        <link rel="stylesheet" href="/assets/css/styles.css">
        <link rel="stylesheet" href="/assets/css/schemes/de-york.css" />
        <link rel="stylesheet" href="/assets/css/mystyles.css">
        <script src="/assets/js/modernizr.js"></script>
    </head>
    <body>
        <div class="global-wrap">
            <header id="main-header">
                <tiles:insertAttribute name="header" />
                <tiles:insertAttribute name="top-menu" />
            </header>
            <tiles:insertAttribute name="body" />
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>