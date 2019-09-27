package pearl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/feeds")
public class FeedController {

    @Value("${main.page}")
    private String mainPage;

    @Autowired
    private FeedFacade feedFacade;

    /**
     * Prepare main page and display any feeds for current session.
     *
     * @param model the main page
     *
     */
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model){
        addDefaultAttributes(model);
        return mainPage;
    }

    /**
     * Add new feed to list and refresh main page.
     *
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFeed(@ModelAttribute FeedData feedData, Model model){
        feedFacade.addFeed(feedData);
        addDefaultAttributes(model);
        return mainPage;
    }

    /**
     * Get feed by id for display feed details.
     *
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getItem(@PathVariable("id") int id, Model model){
        addDefaultAttributes(model);
        model.addAttribute("listItemDetails", feedFacade.getListItems(id));
        model.addAttribute("listFeedDetails", feedFacade.getFeedById(id));
        return mainPage;
    }

    /**
     * Remove feed by id and refresh main page.
     *
     */
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String removeFeed(@PathVariable("id") int id, Model model){
        feedFacade.removeFeed(id);
        addDefaultAttributes(model);
        return mainPage;
    }

    /**
     * Update feed by id and refresh main page. Download latest items for current feed.
     *
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateFeed(@PathVariable("id") int id, Model model){
        FeedData feedData = feedFacade.updateFeed(id);
        addDefaultAttributes(model);
        model.addAttribute("listItemDetails", feedFacade.getListItems(feedData.getId()));
        model.addAttribute("listFeedDetails", feedData);
        return mainPage;
    }

    /**
     * Add default model attributes for page
     *
     * @param model current page
     *
     */
    private void addDefaultAttributes(Model model) {
        model.addAttribute("feedModel", new FeedData());
        model.addAttribute("listFeeds", feedFacade.getListFeeds());
    }

}
