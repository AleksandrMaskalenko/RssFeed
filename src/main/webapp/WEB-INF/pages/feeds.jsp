<%@ include file="/WEB-INF/pages/includes.jsp"%>
<html>
<head>
    <title>RSS Feed</title>
</head>
<body>
    <div  class="wrapper first">

        <div class="wireframe wire-first">
            <form:form action="/FeedsRss_war/feed/add" method="POST" commandName="feedModel">
                <h4>Add XML RSS Feed</h4>
                <h5>Please provide new XML RSS Feed information</h5>

                <div>
                    <div class="col-sm-12 remove-pading">
                        <label class="left col-sm-6 remove-pading" for="fUrl">XML RSS Feed URL:</label>
                        <form:input class="right col-sm-6" id="fUrl" path="url"/>
                    </div>

                    <div class="col-sm-12 remove-pading">
                        <label class="left col-sm-6 remove-pading" for="fName">XML RSS Feed Name:</label>
                        <form:input class="right col-sm-6" id="fName" path="feedName"/>
                    </div>
                </div>
                <br>

                <input class="add-feed-button btn btn-outline-secondary" type="submit" value="Add Feed"/>
            </form:form>
        </div>


        <br>
        <div class="wireframe wire-second" >
            <h4>XML RSS Feed</h4>
            <h5>Please find the list of all available feeds</h5>

            <c:if test="${!empty listFeeds}">
                <c:forEach items="${listFeeds}" var="feed">
                    <form:form action="/FeedsRss_war/remove/${feed.id}" method="POST" >
                        <ul class="list-group">
                            <li class="list-group-item remove-brd">
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



<br>
<c:if test="${!empty listItemDetails}">
    <div class="wireframe second">
        <h4 class="left">XML RSS Feed Details</h4>
        <button class="right btn btn-outline-secondary" onclick="window.location.href = '/FeedsRss_war/update/${listFeedDetails.id}';">Update</button>

        <br>
        <br>

        <div class="col-sm-12">
            <div class="left col-sm-6">
                <p>Feed name: ${listFeedDetails.feedName}</p>
                <p>URL: ${listFeedDetails.url}</p>
            </div>


            <div class="right col-sm-6">
                <div class="right">
                    <p>Last update: ${listFeedDetails.lastUpdate}</p>
                    <p>Article count: ${listFeedDetails.articleCount}</p>
                </div>
            </div>
        </div>


        <div class="detail-list">
            <c:forEach items="${listItemDetails}" var="item">
                <ul>
                    <a href="${item.link}">${item.title}</a>
                </ul>
            </c:forEach>
        </div>
    </div>
</c:if>
</body>
</html>
