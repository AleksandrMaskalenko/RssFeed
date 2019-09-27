package pearl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pearl.dto.FeedData;
import pearl.facade.FeedFacade;

/**
 * Feed Controller. Provides common for all functionality
 */
@Controller
public class FeedController {

    @Autowired
    private FeedFacade feedFacade;

    @RequestMapping(value = "/feeds", method = RequestMethod.GET)
    public String setupForm(Model model){
        addDefaultAttributes(model);
        return feedFacade.getJspFileName();
    }

    @RequestMapping(value = "/feed/add", method = RequestMethod.POST)
    public String addFeed(@ModelAttribute FeedData feedData, Model model){
        feedFacade.addFeed(feedData);
        addDefaultAttributes(model);
        return feedFacade.getJspFileName();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String getItem(@PathVariable("id") int id, Model model){
        addDefaultAttributes(model);
        model.addAttribute("listItemDetails", feedFacade.getListItems(id));
        model.addAttribute("listFeedDetails", feedFacade.getFeedById(id));
        return feedFacade.getJspFileName();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String removeFeed(@PathVariable("id") int id, Model model){
        feedFacade.removeFeed(id);
        addDefaultAttributes(model);
        return feedFacade.getJspFileName();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateFeed(@PathVariable("id") int id, Model model){
        FeedData feedData = feedFacade.updateFeed(id);
        addDefaultAttributes(model);
        model.addAttribute("listItemDetails", feedFacade.getListItems(feedData.getId()));
        model.addAttribute("listFeedDetails", feedData);
        return feedFacade.getJspFileName();
    }

    private void addDefaultAttributes(Model model) {
        model.addAttribute("feedModel", new FeedData());
        model.addAttribute("listFeeds", feedFacade.getListFeeds());
    }

}
