<%@ include file="/WEB-INF/pages/includes.jsp"%>
<style><%@include file="/WEB-INF/css/style_v2.css"%></style>
<html>
<head>
    <title>RSS Feed</title>
</head>
<body>
<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar fixed-top nav-bar">

        <!-- Top Menu Items -->
        <c:if test="${!empty listItemDetails}">
            <ul class="nav top-nav">
                <li class="nav-item" ><p>Feed name: ${listFeedDetails.feedName}</p></li>
                <li class="nav-item"><p>Feed url: ${listFeedDetails.url}</p></li>
                <li class="nav-item"><p>Feed total article count ${listFeedDetails.articleCount}</p></li>
                <li class="nav-item"><p>Feed last update: ${listFeedDetails.lastUpdate}</p></li>
            </ul>
        </c:if>

        <div class="nav side-nav">
            <div class="add-feed">
                <form:form action="/feeds/add" method="POST" commandName="feedModel">
                    <div class="form-group">
                        <form:input class="form-control" placeholder="RSS Feed Url" path="url"/>
                    </div>
                    <div class="form-group">
                        <form:input class="form-control" placeholder="Feed Name" path="feedName"/>
                    </div>
                    <button type="submit" class="btn btn-info">Add Feed</button>
                </form:form>
            </div>

            <h3 class="list-feed-title">RSS Feed List:</h3>
            <div class="list-feeds-wraper">
            <c:if test="${!empty listFeeds}">
                <c:forEach items="${listFeeds}" var="feed">

                    <form:form action="/feeds/remove/${feed.id}" method="POST" >

                            <ul class="list-feeds">
                                <li  class="list-group-item">
                                    <a href="/feeds/get/${feed.id}">${feed.feedName}</a>
                                    <button type="submit" class="close" aria-label="Delete">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </li>

                            </ul>

                    </form:form>

                </c:forEach>
            </c:if>

            </div>

        </div>

    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <c:choose>
                <c:when test="${!empty listItemDetails}">
                    <div class="row" id="main" >
                        <div class="col-sm-12 col-md-12 well" id="content">
                            <div class="container">
                                <button class="update-btn btn btn-info" onclick="window.location.href = '/feeds/update/${listFeedDetails.id}';">Update</button>
                                <div class="row">
                                    <c:forEach items="${listItemDetails}" var="item">
                                        <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
                                            <div class="card card-inverse card-info">
                                                <img class="card-img-top" src="https://picsum.photos/200/150/?random">
                                                <div class="card-block">
                                                    <h4 class="card-title">${item.title}</h4>
                                                </div>
                                                <div class="card-footer">
                                                    <small>Last updated ${item.published}</small>
                                                    <button class="btn btn-info float-right btn-sm" onclick="window.location.href ='${item.link}';">More</button>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>

                    </div>
                </c:when>
                <c:otherwise>
                    <div>
                        <h3 class="list-feed-title"><i>Here you can see your RSS feeds. But looks like you have no RSS, please add a new one!</i></h3>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>


</div>
</body>
</html>
