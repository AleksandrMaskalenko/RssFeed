package pearl.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pearl.dao.ItemDao;
import pearl.model.ItemModel;

import java.util.Collections;
import java.util.List;

/**
 * Default implementation of the {@link ItemDao}
 */

@Repository
public class ItemDaoImpl implements ItemDao {
    private static final Logger LOG = Logger.getLogger(ItemDaoImpl.class);

    private static final String GET_LIST_ITEMS_BY_ID = "FROM ItemModel WHERE feed_id = :feed_id";

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveItem(ItemModel itemModel) {
        this.sessionFactory.getCurrentSession().save(itemModel);
        LOG.info("Item successfully saved. Item details: " + itemModel);
    }

    @Override
    @Transactional
    public List<ItemModel> getListItemsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery(GET_LIST_ITEMS_BY_ID);
        query.setParameter("feed_id", id);
        List<ItemModel> list = (List<ItemModel>) query.list();

        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }

        return list;
    }

    @Override
    @Transactional
    public void removeItem(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        ItemModel itemModel = (ItemModel) session.get(ItemModel.class, id);

        if(itemModel!=null){
            session.delete(itemModel);
        }
        LOG.info("Item successfully removed!");
    }
}
