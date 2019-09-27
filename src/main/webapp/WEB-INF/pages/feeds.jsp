<%@ include file="/WEB-INF/pages/includes.jsp"%>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<html>
<head>
    <title>RSS Feed</title>
</head>
<body>
    <div  class="wrapper-left">

        <div class="wireframe">

                <h4>Add XML RSS Feed</h4>
                <h5>Please provide new XML RSS Feed information</h5>

            <form:form action="/FeedsRss_war/feed/add" method="POST" commandName="feedModel">
                    <div class="block">
                        <label class="add-feed-label" for="fUrl">XML RSS Feed URL:</label>
                        <form:input id="fUrl" path="url"/>
                    </div>

                    <div class="block">
                        <label  class="add-feed-label"for="fName">XML RSS Feed Name:</label>
                        <form:input id="fName" path="feedName"/>
                    </div><br>

                <input type="submit" value="Add Feed"/>
            </form:form>
        </div>

        <div class="wireframe" >
            <h4>XML RSS Feed</h4>
            <h5>Please find the list of all available feeds</h5>

            <c:if test="${!empty listFeeds}">
                <c:forEach items="${listFeeds}" var="feed">
                    <form:form action="/FeedsRss_war/remove/${feed.id}" method="POST" >
                        <ul class="list-group">
                            <li class="list-group-item">
                                <a href="/FeedsRss_war/item/${feed.id}">${feed.feedName}</a>
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



<c:if test="${!empty listItemDetails}">
    <div class="wrapper-right">
        <div class="wireframe">
            <h4>XML RSS Feed Details</h4>
            <button class="right btn btn-outline-secondary" onclick="window.location.href = '/FeedsRss_war/update/${listFeedDetails.id}';">Update</button>

            <div class="item-detail-info">
                <p>Feed name: ${listFeedDetails.feedName}</p>
                <p>URL: ${listFeedDetails.url}</p>
            </div>

            <div class="item-detail-info">
                <p>Last update: ${listFeedDetails.lastUpdate}</p>
                <p>Total article count: ${listFeedDetails.articleCount}</p>
            </div>

            <div class="detail-list">
                <c:forEach items="${listItemDetails}" var="item">
                    <ul>
                        <a href="${item.link}">${item.title}</a>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>
