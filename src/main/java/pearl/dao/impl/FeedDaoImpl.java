package pearl.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pearl.dao.FeedDao;
import pearl.model.FeedModel;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of {@link FeedDao}
 */

@Repository
public class FeedDaoImpl implements FeedDao {
    private static final Logger LOG = Logger.getLogger(FeedDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveFeed(FeedModel feedModel) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.save(feedModel);
            LOG.info("Feed successfully saved. Feed details: " + feedModel);
        } catch (Exception e) {
            LOG.error("Error has occurred while save feed model" + e);
        }
    }

    @Override
    @Transactional
    public FeedModel getFeedById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FeedModel feed = null;
        try {
            feed = (FeedModel) session.get(FeedModel.class, id);
            LOG.info("Feed successfully loaded. Feed details: " + feed);
        } catch (Exception e) {
            LOG.error("Error has occurred while get feed model by id" + e);
        }

        return feed;
    }

    @Override
    @Transactional
    public List<FeedModel> getListFeeds() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FeedModel> list = new ArrayList<>();

        try {
            list = session.createQuery("from FeedModel").list();
        } catch (Exception e) {
            LOG.error("Error has occurred while get feed model list" + e);
        }

        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }

        return list ;
    }

    @Override
    @Transactional
    public void removeFeed(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        FeedModel feed = getFeedById(id);

        if(feed != null){
            session.delete(feed);
            LOG.info("Feed successfully removed. Feed details: " + feed);
        } else {
            LOG.warn("No feed with id:" + id + " were found!");
        }
    }
}
